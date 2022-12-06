package com.bookServer.facade.bookInfo.service;

import com.bookServer.source.dao.BookInfoDao;
import com.commons.bookServer.entity.bookInfo.BookInfo;
import com.commons.bookServer.entity.common.PageInfo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookInfoService {
    @Resource
    private BookInfoDao bookInfoDao;

    /**
     * 根据图书id获取图书信息
     * @param bookId
     * @return
     */
    public BookInfo getBookById(Integer bookId) {
        return bookInfoDao.getBookInfoById(bookId);
    }

    /**
     *
     * @param bookType
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<BookInfo> getBookInfoList(Integer bookType, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo, pageSize);
        Page<BookInfo> bookInfoListByBookType = bookInfoDao.getBookInfoListByBookType(bookType);
        return new PageInfo<>(bookInfoListByBookType);
    }




}
