package com.library.bookservice.service;

import com.library.bookservice.dto.BookDto;
import com.library.bookservice.entity.Book;
import com.library.bookservice.exception.BookNotFoundException;
import com.library.bookservice.exception.IsbnAlreadyExistsException;
import com.library.bookservice.mapper.BookMapper;
import com.library.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookDto saveBook(BookDto bookDto) {

        if (bookRepository.findByIsbn(bookDto.getIsbn()).isPresent()) {
            throw new IsbnAlreadyExistsException("ISBN already exists");
        }

        Book book = BookMapper.mapToEntity(bookDto);

        Book savedBook = bookRepository.save(book);

        return BookMapper.mapToDto(savedBook);
    }

    public List<BookDto> getAllBooks() {

        return bookRepository.findAll()
                .stream()
                .map(BookMapper::mapToDto)
                .toList();
    }

    public BookDto getBookById(Long id) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new BookNotFoundException("Book not found"));

        return BookMapper.mapToDto(book);
    }

    public BookDto updateBook(Long id, BookDto bookDto) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new BookNotFoundException("Book not found"));

        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setIsbn(bookDto.getIsbn());

        Book updatedBook = bookRepository.save(book);

        return BookMapper.mapToDto(updatedBook);
    }

    public void deleteBook(Long id) {

        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Book not found");
        }

        bookRepository.deleteById(id);
    }
}