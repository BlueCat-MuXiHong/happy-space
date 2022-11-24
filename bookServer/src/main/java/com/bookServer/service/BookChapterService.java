package com.bookServer.service;

import com.bookServer.dao.BookChapterDao;
import com.bookServer.dao.BookChapterDao;
import com.bookServer.entity.BookChapter;
import com.bookServer.entity.BookInfo;
import com.bookServer.entity.model.BookForChapterModel;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class BookChapterService {

    @Autowired
    private BookChapterDao bookChapterDao;

    public Integer insertChapter1(List<BookChapter> bookChapters){
        return bookChapterDao.insertBookChapter1(bookChapters);
    }
    public Integer insertChapter2(List<BookChapter> bookChapters){
        return bookChapterDao.insertBookChapter2(bookChapters);
    }
    public Integer insertChapter3(List<BookChapter> bookChapters){
        return bookChapterDao.insertBookChapter3(bookChapters);
    }
    public Integer insertChapter4(List<BookChapter> bookChapters){
        return bookChapterDao.insertBookChapter4(bookChapters);
    }
    public Integer insertChapter5(List<BookChapter> bookChapters){
        return bookChapterDao.insertBookChapter5(bookChapters);
    }
    public Integer insertChapter6(List<BookChapter> bookChapters){
        return bookChapterDao.insertBookChapter6(bookChapters);
    }
    public Integer insertChapter7(List<BookChapter> bookChapters){
        return bookChapterDao.insertBookChapter7(bookChapters);
    }
    public Integer insertChapter8(List<BookChapter> bookChapters){
        return bookChapterDao.insertBookChapter8(bookChapters);
    }

    public Integer insertChapterError(BookForChapterModel bookForChapterModel){
        return bookChapterDao.insertChapterError(bookForChapterModel);
    }


    @Async("test")
    public Integer getBookChapterByUrl(String baseUrl,BookForChapterModel bookForChapterModel){
//        log.info(bookForChapterModel.getBook_url());
        Document document = null;
        try {
            document = Jsoup.parse(new URL(bookForChapterModel.getBook_url()), 5000);
        }catch(Exception e){
            System.out.println("执行到这里");
            getBookChapterByUrl(baseUrl,bookForChapterModel);
            return null;
        }
        List<BookChapter> bookChapterList = new ArrayList<>();
        Elements chapterListLis = document.getElementById("stylechapter").getElementsByTag("li");
        for (Element li : chapterListLis) {
            String chapterUrl = baseUrl + li.getElementsByTag("a").attr("href");
            String chapterName = li.getElementsByTag("a").text();
            BookChapter bookChapter = new BookChapter(null,bookForChapterModel.getBook_id(), chapterName, chapterUrl);
            bookChapterList.add(bookChapter);
        }
        try {
            insetBookChapterByType(bookForChapterModel, bookChapterList);
            log.info(bookForChapterModel.getBook_id()+"--------章节插入完毕");
        }catch (Exception e){
            log.error("插入错误");
            insertChapterError(bookForChapterModel);
        }

        return  bookForChapterModel.getBook_id();
    }

    private Integer insetBookChapterByType(BookForChapterModel bookForChapterModel,List<BookChapter> bookChapterList){
        switch (bookForChapterModel.getBook_type()){
            case 1:
                return insertChapter1(bookChapterList);
            case 2:
                return insertChapter2(bookChapterList);
            case 3:
                return insertChapter3(bookChapterList);
            case 4:
                return insertChapter4(bookChapterList);
            case 5:
                return insertChapter5(bookChapterList);
            case 6:
                return insertChapter6(bookChapterList);
            case 7:
                return insertChapter7(bookChapterList);
            case 8:
                return insertChapter8(bookChapterList);

        }
        return null;
    }

    public List<BookChapter> getBookChapterByBook(BookInfo bookInfo){
//        System.out.println(bookInfo);
        switch (bookInfo.getBook_type()){
            case 1:
                return bookChapterDao.getChapterByBookId1(bookInfo.getBook_id());
            case 2:
                return bookChapterDao.getChapterByBookId2(bookInfo.getBook_id());
            case 3:
                return bookChapterDao.getChapterByBookId3(bookInfo.getBook_id());
            case 4:
                return bookChapterDao.getChapterByBookId4(bookInfo.getBook_id());
            case 5:
                return bookChapterDao.getChapterByBookId5(bookInfo.getBook_id());
            case 6:
                return bookChapterDao.getChapterByBookId6(bookInfo.getBook_id());
            case 7:
                return bookChapterDao.getChapterByBookId7(bookInfo.getBook_id());
            case 8:
                return bookChapterDao.getChapterByBookId8(bookInfo.getBook_id());
        }
        return null;
    }

}