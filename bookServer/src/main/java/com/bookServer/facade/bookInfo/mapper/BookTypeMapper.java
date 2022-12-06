package com.bookServer.facade.bookInfo.mapper;


import com.commons.bookServer.entity.bookType.BookType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 图书类别
 */
@Mapper
public interface BookTypeMapper {
    /**
     * 获取所有的图书类别
     * @return 图书类别列表
     */
    @Select("SELECT * FROM book_type")
    List<BookType> getBookTypeList();
}
