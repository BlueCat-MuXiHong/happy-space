package com.bookServer.facade.bookChapter.controller;

import com.bookServer.exception.CustomException;
import com.bookServer.facade.bookChapter.service.BookChapterService;
import com.commons.bookServer.entity.bookChapter.BookChapter;
import com.commons.bookServer.entity.common.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("bookChapter")
public class BookChapterController {

    @Autowired
    private BookChapterService bookChapterService;
    /**
     * 获取图书章节
     * @param bookId
     * @param pageNo
     * @return
     * @throws CustomException
     */
    @GetMapping("getBookChapterByBookId")
    public Object getBookChapterByBookId(Integer bookId, Integer pageNo) throws CustomException {
        return  bookChapterService.getBookChapterByBookId(bookId,pageNo);
    }
}
