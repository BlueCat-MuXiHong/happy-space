package com.bookServer.facade.bookType.Mapper;

import com.commons.bookServer.entity.bookType.BookType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookTypeMapper {


    /**
     * 根据类型id获取类型名
     * @param id
     * @return
     */
    @Select("select book_type from book_type where #{id}")
    String getBookTypeById(@Param("id") Integer id);

    /**
     * 获取全部的类型
     * @return
     */
    @Select("select id,book_type from book_type")
    List<BookType> getBookTypeList();
}
