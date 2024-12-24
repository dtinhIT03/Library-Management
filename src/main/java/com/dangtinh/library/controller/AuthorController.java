package com.dangtinh.library.controller;

import com.dangtinh.library.service.AuthorService;
import com.dangtinh.library.service.BookService;
import com.dangtinh.library.dto.response.ApiResponse;
import com.dangtinh.library.dto.response.AuthorResponse;
import com.dangtinh.library.dto.response.BooksResponse;
import com.dangtinh.library.utils.AppConstants;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthorController {
    AuthorService authorService;
    BookService bookService;

    @GetMapping
    public ApiResponse<List<AuthorResponse>> getAllAuthors(){
        return ApiResponse.<List<AuthorResponse>>builder()
                .result(authorService.getAllAuthors())
                .build();
    };

    @GetMapping("/{id}/books")
    public ApiResponse<BooksResponse> getBookByAuthorId(
            @PathVariable int id,
            @RequestParam(value = "pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required = false) int pageNo,
            @RequestParam(value = "pageSize",defaultValue = AppConstants.DEFAULT_PAGE_SIZE,required = false) int pageSize,
            @RequestParam(value = "sortBy",defaultValue = AppConstants.DEFAULT_SORT_BY,required = false) String sortBy,
            @RequestParam(value = "sortDir",defaultValue = AppConstants.DEFAULT_SORT_DIRECTION,required = false) String sortDir
            ){

        return ApiResponse.<BooksResponse>builder()
                .result(bookService.getBooksByAuthorId(id,pageNo,pageSize, sortBy, sortDir))
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<AuthorResponse> getAuthorById(@PathVariable(value = "id") int id){
        return ApiResponse.<AuthorResponse>builder()
                .result(authorService.getAuthorById(id))
                .build();
    }
}
