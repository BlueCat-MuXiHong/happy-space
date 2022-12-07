package com.bookServer.source.dao;

import com.commons.bookServer.entity.bookInfo.BookInfo;
import com.commons.bookServer.entity.bookChapter.BookForChapterModel;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;

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
    @Select("SELECT `book_id`,`book_name`,`book_author`,`book_type`,`book_title`,`book_url`,`book_img_url` FROM book_info WHERE book_id=#{bookId}")
    BookInfo getBookInfoById(@Param("bookId") Integer bookId);


    /**
     * 根据书名获取数据库
     * @param bookName
     * @return
     */
    @Select("SELECT book_id,book_name,book_author,book_type,book_title,book_url,book_img_url FROM book_info WHERE book_name LIKE #{bookName};")
    List<BookInfo> getBookInfoByName(@Param("bookName") String bookName);

    /**
     * 根据书地址获取图书
     * @param book_url
     * @return
     */
    @Select("SELECT book_id,book_name,book_author,book_type,book_title,book_url,book_img_url FROM book_info WHERE book_url = #{book_url};")
    BookInfo getBookInfoByUrl(@Param("book_url") String book_url);


    /**
     * 获取全部的图书
     * @return
     */

    @Select("SELECT book_id,book_name,book_author,book_type,book_title,book_url,book_img_url FROM book_info ORDER BY book_id asc")
    List<BookInfo> getAllBookInfo();


    /**
     * 根据图书类型获取图书
     * @param bookType
     * @return
     */
    @Select("SELECT book_id,book_type,book_url FROM book_info where book_type = #{bookType};")
    List<BookForChapterModel> getAllBookModel(@Param("bookType") Integer bookType);

    @Select("SELECT book_id,book_name,book_author,book_type,book_title,book_url,book_img_url FROM book_info where book_type=#{bookType}")
    Page<BookInfo> getBookInfoListByBookType(@Param("bookType") Integer bookType);
}
