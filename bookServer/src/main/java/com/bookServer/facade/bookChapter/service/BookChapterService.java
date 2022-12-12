package com.bookServer.facade.bookChapter.service;

import com.bookServer.exception.CustomException;
import com.bookServer.facade.bookChapter.Mappper.BookChapterMapper;
import com.bookServer.facade.bookInfo.service.BookInfoService;
import com.commons.bookServer.entity.bookChapter.BookChapter;
import com.commons.bookServer.entity.bookInfo.BookInfo;
import com.commons.bookServer.entity.common.PageInfo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookChapterService {

    @Resource
    private BookChapterMapper bookChapterMapper;

    @Resource
    private BookInfoService bookInfoService;


    /**
     * 返回章节   分页有问题，要改
     * @param bookId
     * @param pageNo
     * @return
     * @throws CustomException
     */
    public PageInfo<BookChapter> getBookChapterByBookId(Integer bookId, Integer pageNo,Integer pageSize) throws CustomException {
        BookInfo book = bookInfoService.getBookById(bookId);
        PageHelper.startPage(pageNo, pageSize);
        Page<BookChapter> bookChapterByBookType = this.getBookChapterByBookType(book.getBook_type(), bookId);
        if (bookChapterByBookType.size()==0){
            throw new CustomException(204,"这本图书的还没有100章节，建议养肥了再看发ヾ(≧▽≦*)o");
        }
        return new PageInfo<>(bookChapterByBookType);
    }


    /**
     * 获取章节
     * @param bookType
     * @param bookId
     * @return
     */
    public Page<BookChapter> getBookChapterByBookType(Integer bookType, Integer bookId){
        switch (bookType){
            case 1:
                return bookChapterMapper.getChapterByBookId1(bookId);
            case 2:
                return bookChapterMapper.getChapterByBookId2(bookId);
            case 3:
                return bookChapterMapper.getChapterByBookId3(bookId);
            case 4:
                return bookChapterMapper.getChapterByBookId4(bookId);
            case 5:
                return bookChapterMapper.getChapterByBookId5(bookId);
            case 6:
                return bookChapterMapper.getChapterByBookId6(bookId);
            case 7:
                return bookChapterMapper.getChapterByBookId7(bookId);
            case 8:
                return bookChapterMapper.getChapterByBookId8(bookId);
        }
        return null;
    }

}
