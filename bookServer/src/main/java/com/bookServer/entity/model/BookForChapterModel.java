package com.bookServer.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookForChapterModel {
    private Integer book_id;
    private Integer book_type;
    private String book_url;
}
