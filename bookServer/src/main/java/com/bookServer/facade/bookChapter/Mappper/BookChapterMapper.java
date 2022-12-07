package com.bookServer.facade.bookChapter.Mappper;

import com.commons.bookServer.entity.bookChapter.BookChapter;
import com.commons.bookServer.entity.bookChapter.BookForChapterModel;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface BookChapterMapper {

    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM bookchapterxuanhuan WHERE book_id = #{bookId}")
    Page<BookChapter> getChapterByBookId1(@Param("bookId") Integer bookId);

    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM book_2_chapter WHERE book_id = #{bookId}")
    Page<BookChapter> getChapterByBookId2(@Param("bookId") Integer bookId);

    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM book_3_chapter WHERE book_id = #{bookId}")
    Page<BookChapter> getChapterByBookId3(@Param("bookId") Integer bookId);

    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM book_4_chapter WHERE book_id = #{bookId}")
    Page<BookChapter> getChapterByBookId4(@Param("bookId") Integer bookId);

    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM book_5_chapter WHERE book_id = #{bookId}")
    Page<BookChapter> getChapterByBookId5(@Param("bookId") Integer bookId);

    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM book_6_chapter WHERE book_id = #{bookId}")
    Page<BookChapter> getChapterByBookId6(@Param("bookId") Integer bookId);

    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM book_7_chapter WHERE book_id = #{bookId}")
    Page<BookChapter> getChapterByBookId7(@Param("bookId") Integer bookId);

    @Select("SELECT id,book_id,book_chapter_name,book_chapter_ip FROM bookchapterqita WHERE book_id = #{bookId}")
    Page<BookChapter> getChapterByBookId8(@Param("bookId") Integer bookId);

    @Insert("insert into chapter_error(book_id,book_url)values(#{book_id},#{book_url}) ")
    Integer insertChapterError(BookForChapterModel bookForChapterModel);



}
