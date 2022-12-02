package com.commons.bookServer.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookContent implements Serializable {
    private Integer book_id;
    private Integer book_chapter_id;
    private String content;
}
