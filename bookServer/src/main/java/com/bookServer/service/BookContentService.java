package com.bookServer.service;

import com.alibaba.fastjson.JSON;
import com.commons.bookServer.entity.BookChapter;
import com.commons.bookServer.entity.BookContent;
import com.commons.bookServer.entity.BookInfo;
import lombok.extern.log4j.Log4j2;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Log4j2
@Service
public class BookContentService {

    @Autowired
    private BookInfoSourceService bookInfoService;

    @Autowired
    private BookChapterService bookChapterService;
    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;
    @Async("test")
    public Integer getChapterList(BookInfo bookInfo) {
        List<BookChapter> bookChapterByBook = bookChapterService.getBookChapterByBook(bookInfo);
        if (bookChapterByBook.size() != 0) {
            for (BookChapter bookChapter : bookChapterByBook) {
                getBookContent(bookChapter,bookInfo.getBook_type());
            }
        }
        return null;
    }

    @Async("test")
    public BookContent getBookContent(BookChapter bookChapter,int type){
        Document document = null;
        try {
            document = Jsoup.parse(new URL(bookChapter.getBook_chapter_ip()), 5000);
        } catch (Exception e) {
            System.out.println("执行到这里");
            getBookContent(bookChapter,type);
            return null;
        }
        String text = document.getElementsByClass("book-content").get(0).text();
        log.info(bookChapter.getBook_chapter_ip());
        BookContent bookContent = new BookContent(bookChapter.getBook_id(), bookChapter.getId(), text);
        insertEs(bookContent,type);
        return bookContent;
//        client.close();
    }
    public void insertEs(BookContent bookContent,int type){
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("2m"); // 可更具实际业务是指
        String index = this.indexName(type);
        bulkRequest.add(new IndexRequest(index).id("" + bookContent.getBook_id() + bookContent.getBook_chapter_id())
                .source(JSON.toJSONString(bookContent), XContentType.JSON));
        try {
            BulkResponse bulk = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String indexName(int type){
        switch (type){
            case 1:
                return "book_1_chapter";
            case 2:
                return "book_2_chapter";
            case 3:
                return "book_3_chapter";
            case 4:
                return "book_4_chapter";
            case 5:
                return "book_5_chapter";
            case 6:
                return "book_6_chapter";
            case 7:
                return "book_7_chapter";
            case 8:
                return "book_8_chapter";
        }
        return null;
    }

}