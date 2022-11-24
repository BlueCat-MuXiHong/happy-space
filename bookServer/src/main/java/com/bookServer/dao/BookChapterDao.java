package com.bookServer.dao;

import com.bookServer.entity.BookChapter;
import com.bookServer.entity.model.BookForChapterModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookChapterDao {

//    private Integer id;
//    private Integer book_id;
//    private String book_chapter_name;
//    private String book_chapter_ip;



    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "book_id", column = "book_id"),
            @Result(property = "book_chapter_name", column = "book_chapter_name"),
            @Result(property = "book_chapter_ip", column = "book_chapter_ip")
    })
    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM book_1_chapter WHERE book_id = #{bookId}")
    List<BookChapter> getChapterByBookId1(@Param("bookId") String bookId);

    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM book_2_chapter WHERE book_id = #{bookId}")
    List<BookChapter> getChapterByBookId2(@Param("bookId") String bookId);

    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM book_3_chapter WHERE book_id = #{bookId}")
    List<BookChapter> getChapterByBookId3(@Param("bookId") String bookId);

    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM book_4_chapter WHERE book_id = #{bookId}")
    List<BookChapter> getChapterByBookId4(@Param("bookId") String bookId);

    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM book_5_chapter WHERE book_id = #{bookId}")
    List<BookChapter> getChapterByBookId5(@Param("bookId") String bookId);

    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM book_6_chapter WHERE book_id = #{bookId}")
    List<BookChapter> getChapterByBookId6(@Param("bookId") String bookId);

    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM book_7_chapter WHERE book_id = #{bookId}")
    List<BookChapter> getChapterByBookId7(@Param("bookId") String bookId);

    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM book_8_chapter WHERE book_id = #{bookId}")
    List<BookChapter> getChapterByBookId8(@Param("bookId") String bookId);

    @Insert("insert into chapter_error(book_id,book_url)values(#{book_id},#{book_url}) ")
    Integer insertChapterError(BookForChapterModel bookForChapterModel);

    @Insert("<script>" +
            "replace into book_1_chapter (book_id,book_chapter_name,book_chapter_ip)"
            + "values"
            + "<foreach collection =\"bookChapters\" item=\"item\" index= \"index\" separator =\",\"> "
            + "(#{item.book_id},#{item.book_chapter_name},#{item.book_chapter_ip})"
            + "</foreach>"
            + "</script>")
    Integer insertBookChapter1(@Param("bookChapters") List<BookChapter> bookChapters);


    @Insert("<script>" +
            "replace into book_2_chapter (book_id,book_chapter_name,book_chapter_ip)"
            + "values"
            + "<foreach collection =\"bookChapters\" item=\"item\" index= \"index\" separator =\",\"> "
            + "(#{item.book_id},#{item.book_chapter_name},#{item.book_chapter_ip})"
            + "</foreach>"
            + "</script>")
    Integer insertBookChapter2(@Param("bookChapters") List<BookChapter> bookChapters);
    @Insert("<script>" +
            "replace into book_3_chapter (book_id,book_chapter_name,book_chapter_ip)"
            + "values"
            + "<foreach collection =\"bookChapters\" item=\"item\" index= \"index\" separator =\",\"> "
            + "(#{item.book_id},#{item.book_chapter_name},#{item.book_chapter_ip})"
            + "</foreach>"
            + "</script>")
    Integer insertBookChapter3(@Param("bookChapters") List<BookChapter> bookChapters);
    @Insert("<script>" +
            "replace into book_4_chapter (book_id,book_chapter_name,book_chapter_ip)"
            + "values"
            + "<foreach collection =\"bookChapters\" item=\"item\" index= \"index\" separator =\",\"> "
            + "(#{item.book_id},#{item.book_chapter_name},#{item.book_chapter_ip})"
            + "</foreach>"
            + "</script>")
    Integer insertBookChapter4(@Param("bookChapters") List<BookChapter> bookChapters);
    @Insert("<script>" +
            "replace into book_5_chapter (book_id,book_chapter_name,book_chapter_ip)"
            + "values"
            + "<foreach collection =\"bookChapters\" item=\"item\" index= \"index\" separator =\",\"> "
            + "(#{item.book_id},#{item.book_chapter_name},#{item.book_chapter_ip})"
            + "</foreach>"
            + "</script>")
    Integer insertBookChapter5(@Param("bookChapters") List<BookChapter> bookChapters);
    @Insert("<script>" +
            "replace into book_6_chapter (book_id,book_chapter_name,book_chapter_ip)"
            + "values"
            + "<foreach collection =\"bookChapters\" item=\"item\" index= \"index\" separator =\",\"> "
            + "(#{item.book_id},#{item.book_chapter_name},#{item.book_chapter_ip})"
            + "</foreach>"
            + "</script>")
    Integer insertBookChapter6(@Param("bookChapters") List<BookChapter> bookChapters);
    @Insert("<script>" +
            "replace into book_7_chapter (book_id,book_chapter_name,book_chapter_ip)"
            + "values"
            + "<foreach collection =\"bookChapters\" item=\"item\" index= \"index\" separator =\",\"> "
            + "(#{item.book_id},#{item.book_chapter_name},#{item.book_chapter_ip})"
            + "</foreach>"
            + "</script>")
    Integer insertBookChapter7(@Param("bookChapters") List<BookChapter> bookChapters);
    @Insert("<script>" +
            "replace into book_8_chapter (book_id,book_chapter_name,book_chapter_ip)"
            + "values"
            + "<foreach collection =\"bookChapters\" item=\"item\" index= \"index\" separator =\",\"> "
            + "(#{item.book_id},#{item.book_chapter_name},#{item.book_chapter_ip})"
            + "</foreach>"
            + "</script>")
    Integer insertBookChapter8(@Param("bookChapters") List<BookChapter> bookChapters);

}
