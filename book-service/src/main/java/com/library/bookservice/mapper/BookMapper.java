package com.library.bookservice.mapper;

import com.library.bookservice.dto.BookDto;
import com.library.bookservice.entity.Book;

public class BookMapper {

    public static BookDto mapToDto(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn()
        );
    }

    public static Book mapToEntity(BookDto dto) {

        Book book = new Book();

        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(dto.getIsbn());

        return book;
    }
}