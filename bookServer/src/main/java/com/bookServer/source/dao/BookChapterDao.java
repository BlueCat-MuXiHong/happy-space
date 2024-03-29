package com.bookServer.source.dao;

import com.commons.bookServer.entity.bookChapter.BookChapter;
import com.commons.bookServer.entity.bookChapter.BookForChapterModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookChapterDao {

//    private Integer id;
//    private Integer book_id;
//    private String book_chapter_name;
//    private String book_chapter_ip;



    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM bookchapterxuanhuan WHERE book_id = #{bookId}")
    List<BookChapter> getChapterByBookId1(@Param("bookId") Integer bookId);

    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM book_2_chapter WHERE book_id = #{bookId}")
    List<BookChapter> getChapterByBookId2(@Param("bookId") Integer bookId);

    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM book_3_chapter WHERE book_id = #{bookId}")
    List<BookChapter> getChapterByBookId3(@Param("bookId") Integer bookId);

    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM book_4_chapter WHERE book_id = #{bookId}")
    List<BookChapter> getChapterByBookId4(@Param("bookId") Integer bookId);

    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM book_5_chapter WHERE book_id = #{bookId}")
    List<BookChapter> getChapterByBookId5(@Param("bookId") Integer bookId);

    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM book_6_chapter WHERE book_id = #{bookId}")
    List<BookChapter> getChapterByBookId6(@Param("bookId") Integer bookId);

    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM book_7_chapter WHERE book_id = #{bookId}")
    List<BookChapter> getChapterByBookId7(@Param("bookId") Integer bookId);

    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM bookchapterqita WHERE book_id = #{bookId}")
    List<BookChapter> getChapterByBookId8(@Param("bookId") Integer bookId);

    @Insert("insert into chapter_error(book_id,book_url)values(#{book_id},#{book_url}) ")
    Integer insertChapterError(BookForChapterModel bookForChapterModel);

    @Insert("<script>" +
            "replace into bookchapterxuanhuan (book_id,book_chapter_name,book_chapter_ip)"
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
            "replace into bookchapterqita (book_id,book_chapter_name,book_chapter_ip)"
            + "values"
            + "<foreach collection =\"bookChapters\" item=\"item\" index= \"index\" separator =\",\"> "
            + "(#{item.book_id},#{item.book_chapter_name},#{item.book_chapter_ip})"
            + "</foreach>"
            + "</script>")
    Integer insertBookChapter8(@Param("bookChapters") List<BookChapter> bookChapters);

}
