package com.bookServer.facade.bookType.controller;

import com.bookServer.facade.bookType.service.BookTypeService;
import com.commons.bookServer.entity.bookType.BookType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("bookType")
public class BookTypeController {

    @Resource
    private BookTypeService bookTypeService;

    /**
     * 获取全部的类型
     * @return
     */
    @GetMapping("getBookTypeList")
    public Object getBookTypeList(){
        return bookTypeService.getBookTypeList();
    }
}
