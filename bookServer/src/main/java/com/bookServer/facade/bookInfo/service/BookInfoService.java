package com.bookServer.facade.bookInfo.service;

import com.bookServer.facade.bookType.service.BookTypeService;
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

    private BookTypeService bookTypeService;
    /**
     * 根据图书id获取图书信息
     * @param bookId
     * @return
     */
    public BookInfo getBookById(Integer bookId) {
        BookInfo bookInfoById = bookInfoDao.getBookInfoById(bookId);
        bookInfoById.setBook_type_string(bookTypeService.getBookTypeById(bookInfoById.getBook_type()));
        return bookInfoById;
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
