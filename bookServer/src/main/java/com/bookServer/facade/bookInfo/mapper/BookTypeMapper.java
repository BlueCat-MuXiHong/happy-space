package com.bookServer.facade.bookInfo.mapper;


import com.bookServer.facade.bookInfo.Model.BookType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookTypeMapper {

    @Select("select * from book_type")
    List<BookType> getBookTypeList();



}
