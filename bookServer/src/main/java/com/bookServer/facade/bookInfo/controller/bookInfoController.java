package com.bookServer.facade.bookInfo.controller;

import com.bookServer.facade.bookInfo.service.BookInfoService;
import com.commons.bookServer.entity.BookInfo;
import com.commons.bookServer.entity.common.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("bookInfo")
public class bookInfoController {

    @Resource
    private BookInfoService bookInfoService;

    /**
     * 根据id获取图书信息
     * @param bookId 图书id
     * @return 图书信息
     */
    @GetMapping("getBookById")
    public BookInfo getBookById(Integer bookId){
        return bookInfoService.getBookById(bookId);
    }

    /**
     * getBookInfoList
     * @param bookType 图书类型
     * @param pageNo 第几页
     * @param pageSize 大小
     * @return 分页数据
     */
    @GetMapping("getBookInfoList")
    public PageInfo<BookInfo> getBookInfoList(Integer bookType,Integer pageNo,Integer pageSize){
        return bookInfoService.getBookInfoList(bookType,pageNo,pageSize);
    }






}
