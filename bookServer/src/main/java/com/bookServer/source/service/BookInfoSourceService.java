package com.bookServer.source.service;

import com.bookServer.source.dao.BookInfoDao;
import com.commons.bookServer.entity.bookInfo.BookInfo;
import com.commons.bookServer.entity.bookChapter.BookForChapterModel;
import com.bookServer.util.BaseHtmlParse;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class BookInfoSourceService {
    @Autowired
    private BookInfoDao bookInfoDao;

    public Integer insertBookInfo(BookInfo bookInfo){
        return bookInfoDao.insertBookInfo(bookInfo);
    }

    public Integer insertBookInfoList(List<BookInfo> bookInfos){
        return bookInfoDao.insertBookInfoList(bookInfos);
    }
    
    public BookInfo getBookInfoById(Integer bookId){
        return bookInfoDao.getBookInfoById(bookId);
    }
    
    public List<BookInfo> getBookInfoByName(String bookName){
        return bookInfoDao.getBookInfoByName(bookName);
    }
    
    public List<BookInfo> getAllBookInfo(){
        return bookInfoDao.getAllBookInfo();
    }

    public List<BookForChapterModel> getAllBookModel(Integer bookType){
        return bookInfoDao.getAllBookModel(bookType);
    }

    public BookInfo getBookInfoByUrl(String bookUrl){
        return bookInfoDao.getBookInfoByUrl(bookUrl);
    }


    /**
     * 每个类型的图书根地址
     * @param allUrl
     * @return
     */
    public List<String> getBookPageUrl(List<String> allUrl){
        List<String> allPageUrl = new ArrayList<>();

        for (String url : allUrl) {
            Document document = BaseHtmlParse.getDocument(url);
            String pageStr = document.getElementsByClass("pagination").get(0).getElementsByTag("li").get(0).getElementsByTag("a").get(0).text().split("/")[1];
            int pageNum = Integer.parseInt(pageStr);
            for (int i = 1; i < pageNum+1; i++) {
                String bookPageUrl = url.split("-")[0]+"-"+i+ ".html";
                allPageUrl.add(bookPageUrl);
            }
        }
        return allPageUrl;
    }

    /**
     * 图书信息写入数据库
     * @param baseUrl 根地址
     * @param url
     * @return
     * @throws UnsupportedEncodingException
     */
    @Async("test")
    public Integer getBookInfosByUrl(String baseUrl,String url) throws UnsupportedEncodingException {
        log.info(url);
        Document document = null;
        try {
            document = Jsoup.parse(new URL(url), 5000);
        }catch(Exception e){
            System.out.println("解析图书信息错误，正在重试。。。");
            getBookInfosByUrl(baseUrl,url);
            return null;
        }
        List<BookInfo> bookInfoList = new ArrayList<>();
        Elements media = document.getElementsByClass("media");
        for (Element element : media) {
            String bookUrl = element.getElementsByClass("media-heading book-title").get(0).getElementsByTag("a").get(0).attr("href");
//            BookInfo bookInfoByUrl = this.getBookInfoByUrl(baseUrl + bookUrl);
//            if (this.getBookInfoByUrl(baseUrl+bookUrl)!=null) {
//                log.info("图书："+bookUrl+"->已存在.");
//                continue;
//            }
            String imgUrl = element.getElementsByClass("media-left media-heading").get(0).getElementsByTag("a").get(0).getElementsByTag("img").get(0).attr("src");
            String bookName =  element.getElementsByClass("media-heading book-title").get(0).getElementsByTag("a").get(0).text();
            String author =  element.getElementsByClass("book_author").get(0).getElementsByTag("a").get(0).text();
            String title = "";
            if (element.getElementsByClass("book-intro-index").size()!=0){
                title = element.getElementsByClass("book-intro-index").get(0).text().replace("[点击阅读]","");
            }
            Integer type =   Integer.parseInt(url.replace("http://www.kuaishuku.com/list/","").split("-")[0]);
            BookInfo bookInfo = new BookInfo(null, bookName, author, type, title,baseUrl+bookUrl, baseUrl+imgUrl,bookUrl);
            bookInfoList.add(bookInfo);

        }
        Integer integer = insertBookInfoList(bookInfoList);
        return integer;

    }



    
    
    
    
    
}
