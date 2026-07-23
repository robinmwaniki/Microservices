package com.library.studentservice.client;

import com.library.studentservice.dto.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "BOOK-SERVICE")
public interface BookClient {

    @GetMapping("/books")
    List<BookDto> getAllBooks();

}