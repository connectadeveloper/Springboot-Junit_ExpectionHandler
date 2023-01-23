package com.lib.book.entity.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BookDto {

    private int bookId;
    private String bookName;
    private int rating;
}
