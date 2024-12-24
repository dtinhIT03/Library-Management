package com.dangtinh.library.service.impl;

import com.dangtinh.library.dto.request.BookRequest;
import com.dangtinh.library.dto.response.BookResponse;
import com.dangtinh.library.dto.response.BooksResponse;
import com.dangtinh.library.entity.Book;
import com.dangtinh.library.exception.AppException;
import com.dangtinh.library.exception.ErrorCode;
import com.dangtinh.library.mapper.BookMapper;
import com.dangtinh.library.repository.AuthorRepository;
import com.dangtinh.library.repository.BookRepository;
import com.dangtinh.library.repository.CategoryRepository;
import com.dangtinh.library.repository.PublisherRepository;
import com.dangtinh.library.service.BookService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookServiceImpl implements BookService {



    BookRepository bookRepository;
    CategoryRepository categoryRepository;
    AuthorRepository authorRepository;
    PublisherRepository publisherRepository;
    BookMapper bookMapper;

    @Override
    public BooksResponse filterBooks(Map<String, String> filters) {

        return null;
    }

    @Override
    public List<BookResponse> getThreeBookRelease() {
        return bookRepository.findTop3NewestBooks().stream().map(bookMapper::toBookResponse).collect(Collectors.toList());
    }

    @Override
    public BooksResponse getBooksByAuthorId(int id, int pageNo, int pageSize, String sortBy, String sortDir) {
        authorRepository.findById(id).orElseThrow(() ->
           new AppException(ErrorCode.AUTHOR_NOT_EXISTED)
        );


        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);

        Page<Book>  books = bookRepository.findByAuthorId(id,pageable);

        List<BookResponse> bookResponses = books.getContent().stream()
                .map(bookMapper :: toBookResponse).collect(Collectors.toList());
        BooksResponse booksResponse=new BooksResponse();
        booksResponse.setContent(bookResponses);
        booksResponse.setPageNo(books.getNumber());
        booksResponse.setPageSize(books.getSize());
        booksResponse.setTotalPages(books.getTotalPages());
        booksResponse.setTotalElements(books.getTotalElements());
        booksResponse.setLast(books.isLast());

        return booksResponse;
    }

    @Override
    public BooksResponse getAllBooks(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        //create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Book> books = bookRepository.findAll(pageable);
        log.info(books.toString());

        // Get content for page object
        List<Book> listOfBooks = books.getContent();
        List<BookResponse> content = listOfBooks.stream().map(bookMapper::toBookResponse).collect(Collectors.toList());

        // Set BooksResponse
        BooksResponse booksResponse = new BooksResponse();
        booksResponse.setContent(content);
        booksResponse.setPageNo(books.getNumber());
        booksResponse.setPageSize(books.getSize());
        booksResponse.setTotalElements(books.getTotalElements());
        booksResponse.setTotalPages(books.getTotalPages());
        booksResponse.setLast(books.isLast());

        return booksResponse;
    }

    @Override
    public BookResponse getBookById(int id) {
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorCode.BOOK_NOT_EXISTED));
        return bookMapper.toBookResponse(book);
    }

    @Override
    public BookResponse createBook(BookRequest bookRequest) {
        Book book = bookMapper.toBook(bookRequest);
        book.setAuthor(authorRepository.findById(bookRequest.getAuthor()).orElseThrow(
                () -> new AppException(ErrorCode.AUTHOR_NOT_EXISTED)
        ));
        book.setCategory(categoryRepository.findById(bookRequest.getCategory()).orElseThrow(
                () -> new AppException(ErrorCode.CATEGORY_NOT_EXISTED)
        ));
        book.setPublisher(publisherRepository.findById(bookRequest.getPublisher()).orElseThrow(
                () -> new AppException(ErrorCode.PUBLISHER_NOT_EXISTED)
        ));
        Book bookCreate = bookRepository.save(book);
        return bookMapper.toBookResponse(bookCreate);
    }

    @Override
    public void deleteBook(int id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.BOOK_NOT_EXISTED));
        bookRepository.delete(book);

    }

    @Override
    public BookResponse updateBook(BookRequest bookRequest, int id) {
        if (!bookRepository.existsById(id)){
            throw new AppException(ErrorCode.BOOK_NOT_EXISTED);
        }
        Book book = bookMapper.toBook(bookRequest);

        book.setId(id);
        book.setAuthor(authorRepository.findById(bookRequest.getAuthor()).orElseThrow(
                () -> new AppException(ErrorCode.AUTHOR_NOT_EXISTED)
        ));
        book.setCategory(categoryRepository.findById(bookRequest.getCategory()).orElseThrow(
                () -> new AppException(ErrorCode.CATEGORY_NOT_EXISTED)
        ));
        book.setPublisher(publisherRepository.findById(bookRequest.getPublisher()).orElseThrow(
                () -> new AppException(ErrorCode.PUBLISHER_NOT_EXISTED)
        ));
        Book bookCreate = bookRepository.save(book);
        return bookMapper.toBookResponse(bookCreate);
    }
}

















