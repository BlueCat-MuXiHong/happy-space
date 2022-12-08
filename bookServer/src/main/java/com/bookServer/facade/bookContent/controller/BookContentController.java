package com.bookServer.facade.bookContent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookContent")
public class BookContentController {

    @GetMapping("")
    public Object getBookContent(Integer bookId,Integer bookChapterId){



        return null;
    }


}
