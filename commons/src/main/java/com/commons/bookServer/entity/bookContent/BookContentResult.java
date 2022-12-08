package com.commons.bookServer.entity.bookContent;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookContentResult {
    private Integer bookId;
    private Integer bookChapterId;
    private Integer nextChapterId;
    private Integer lastChapterId;
    private String bookContent;
}
