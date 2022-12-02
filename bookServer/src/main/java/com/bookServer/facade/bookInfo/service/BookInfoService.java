package com.bookServer.facade.bookInfo.service;

import com.bookServer.dao.BookInfoDao;
import com.commons.bookServer.entity.BookInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookInfoService {
    @Resource
    private BookInfoDao bookInfoDao;

    /**
     * 根据图书id获取图书
     * @param bookId
     * @return
     */
    public BookInfo getBookById(Integer bookId) {
        BookInfo bookInfoById = bookInfoDao.getBookInfoById(bookId);
        System.out.println(bookInfoById);
        return bookInfoById;
    }




}
