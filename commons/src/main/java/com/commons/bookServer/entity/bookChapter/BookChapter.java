package com.commons.bookServer.entity.bookChapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookChapter {

    private Integer id;
    private Integer book_id;
    private String book_chapter_name;
    private String book_chapter_ip;

}
