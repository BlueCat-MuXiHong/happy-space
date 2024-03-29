package com.commons.bookServer.entity.bookInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookInfo {
    private Integer book_id;
    private String book_name;
    private String book_author;
    private Integer book_type;
    private String book_title;
    private String book_url;
    private String book_img_url;
    private String book_type_string;
}
