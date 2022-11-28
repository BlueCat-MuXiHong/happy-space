package com.bookServer.task;

import com.bookServer.entity.model.BookForChapterModel;
import com.bookServer.service.BookChapterService;
import com.bookServer.service.BookInfoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Component
public class Task {
    public static final String url1 = "http://www.kuaishuku.com/list/1-1.html";
    public static final String url2 = "http://www.kuaishuku.com/list/2-1.html";
    public static final String url3 = "http://www.kuaishuku.com/list/3-1.html";
    public static final String url4 = "http://www.kuaishuku.com/list/4-1.html";
    public static final String url5 = "http://www.kuaishuku.com/list/5-1.html";
    public static final String url6 = "http://www.kuaishuku.com/list/6-1.html";
    public static final String url7 = "http://www.kuaishuku.com/list/7-1.html";
    public static final String url8 = "http://www.kuaishuku.com/list/8-1.html";

    public static final String baseUrl = "http://www.kuaishuku.com";

    @Autowired
    private BookInfoService bookInfoService;

    @Autowired
    private BookChapterService bookChapterService;
//
//    @Autowired
//    private BookContentService bookContentService;

    @Scheduled(cron = "*/2 * * * * ?")
    public void bookInfoTask() throws Exception {
        List<String> urls = new ArrayList<>();
//        urls.add(url1);
//        urls.add(url2);
//        urls.add(url3);
//        urls.add(url4);
//        urls.add(url5);
//        urls.add(url6);
//        urls.add(url7);
        urls.add(url8);
        List<String> bookPageUrl = bookInfoService.getBookPageUrl(urls);
        for (String bookUrl : bookPageUrl) {
            bookInfoService.getBookInfosByUrl(baseUrl,bookUrl);
        }
    }


//    @Scheduled(cron = "*/2 * * * * ?")
    public void bookChapterTask() throws Exception {
        List<BookForChapterModel> allBookModel1 = bookInfoService.getAllBookModel(1);
//        List<BookForChapterModel> allBookModel2 = bookInfoService.getAllBookModel(2);
//        List<BookForChapterModel> allBookModel3 = bookInfoService.getAllBookModel(3);
//        List<BookForChapterModel> allBookModel4 = bookInfoService.getAllBookModel(4);
//        List<BookForChapterModel> allBookModel5 = bookInfoService.getAllBookModel(5);
//        List<BookForChapterModel> allBookModel6 = bookInfoService.getAllBookModel(6);
//        List<BookForChapterModel> allBookModel7 = bookInfoService.getAllBookModel(7);
//        List<BookForChapterModel> allBookModel8 = bookInfoService.getAllBookModel(8);
        List<List<BookForChapterModel>> allBookModels = new ArrayList<>();
        allBookModels.add(allBookModel1);
//        allBookModels.add(allBookModel2);
//        allBookModels.add(allBookModel3);
//        allBookModels.add(allBookModel4);
//        allBookModels.add(allBookModel5);
//        allBookModels.add(allBookModel6);
//        allBookModels.add(allBookModel7);
//        allBookModels.add(allBookModel8);


        int i = 0;
        log.info("图书列表组装完毕");
        for (List<BookForChapterModel> allBookModel : allBookModels) {
            for (BookForChapterModel bookForChapterModel : allBookModel) {
                bookChapterService.getBookChapterByUrl(baseUrl,bookForChapterModel);
                log.info(i);
                i+=1;
            }
        }
    }

//    public void insertEsBookContent(){
//        List<BookInfo> allBookInfo = bookInfoService.getAllBookInfo();
////        for (BookInfo bookInfo : allBookInfo) {
////            System.out.println(bookInfo);
////        }
//        log.info("开始");
//        for (BookInfo bookInfo : allBookInfo) {
//            System.out.println(bookInfo.getBook_id()+"----------"+bookInfo.getBook_name()+"------"+bookInfo.getBook_type());
//            bookContentService.getChapterList(bookInfo);
//        }
//    }





}
