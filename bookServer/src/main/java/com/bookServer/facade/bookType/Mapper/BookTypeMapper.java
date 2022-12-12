package com.bookServer.facade.bookType.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookTypeMapper {

    @Select("select book_type from book_type where #{id}")
    String getBookTypeById(@Param("id") Integer id);
}
