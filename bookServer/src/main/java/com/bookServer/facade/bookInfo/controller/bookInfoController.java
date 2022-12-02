package com.bookServer.facade.bookInfo.controller;

import com.bookServer.facade.bookInfo.service.BookInfoService;
import com.commons.bookServer.entity.BookInfo;
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
     * @param bookId
     * @return
     */
    @GetMapping("getBookById")
    public BookInfo getBookById(Integer bookId){
        return bookInfoService.getBookById(bookId);
    }








}
