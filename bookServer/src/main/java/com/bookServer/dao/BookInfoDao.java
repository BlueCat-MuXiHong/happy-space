package com.bookServer.dao;

import com.bookServer.entity.BookInfo;
import com.bookServer.entity.model.BookForChapterModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 图书信息类
 */
@Mapper
public interface BookInfoDao {


    /**
     * 插入图书
     * @param bookInfo
     * @return
     */
    @Insert("INSERT INTO book_info(book_name,book_author,book_type,book_title,book_url,book_img_url)VALUES(#{book_name},#{book_author},#{book_type},#{book_title},#{book_url},#{book_img_url});")
    Integer insertBookInfo(BookInfo bookInfo);

    /**
     * 批量插入图书
     * @param bookInfos
     * @return
     */
    @Insert("<script>" +
            "replace into book_info (book_name,book_author,book_type,book_title,book_url,book_img_url)"
            + "values"
            + "<foreach collection =\"bookInfos\" item=\"item\" index= \"index\" separator =\",\"> "
            + "(#{item.book_name},#{item.book_author},#{item.book_type},#{item.book_title},#{item.book_url},#{item.book_img_url})"
            + "</foreach>"
            + "</script>")
    Integer insertBookInfoList(@Param("bookInfos") List<BookInfo> bookInfos);

    /**
     * 根据图书id获取图书
     * @param bookId
     * @return
     */
    @Select("SELECT book_id,book_name,book_author,book_type,book_title,book_url,book_img_url FROM book_info WHERE book_id = #{bookId};")
    BookInfo getBookInfoById(@Param("bookId") Integer bookId);

    @Select("SELECT book_id,book_name,book_author,book_type,book_title,book_url,book_img_url FROM book_info WHERE book_name LIKE #{bookName};")
    List<BookInfo> getBookInfoByName(@Param("bookName") String bookName);

    /**
     * 获取全部的图书
     * @return
     */
    @Results(value = {
            @Result(property = "book_id", column = "book_id"),
            @Result(property = "book_type", column = "book_type"),
            @Result(property = "book_url", column = "book_url"),
            @Result(property = "book_name", column = "book_name"),
            @Result(property = "book_author", column = "book_author"),
            @Result(property = "book_title", column = "book_title"),
            @Result(property = "book_img_url", column = "book_img_url")
    })
    @Select("SELECT book_id,book_name,book_author,book_type,book_title,book_url,book_img_url FROM book_info ORDER BY book_id asc")
    List<BookInfo> getAllBookInfo();


    /**
     * 根据图书类型获取图书
     * @param bookType
     * @return
     */
    @Results(value = {
            @Result(property = "book_id", column = "book_id"),
            @Result(property = "book_type", column = "book_type"),
            @Result(property = "book_url", column = "book_url"),
    })
    @Select("SELECT book_id,book_type,book_url FROM book_info where book_type = #{bookType};")
    List<BookForChapterModel> getAllBookModel(@Param("bookType") Integer bookType);

}
