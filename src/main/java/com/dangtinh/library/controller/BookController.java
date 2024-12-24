package com.haianh123.library.controller;

import com.haianh123.library.dto.request.BookRequest;
import com.haianh123.library.dto.response.ApiResponse;
import com.haianh123.library.dto.response.BookResponse;
import com.haianh123.library.dto.response.BooksResponse;
import com.haianh123.library.service.BookService;
import com.haianh123.library.utils.AppConstants;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookController {
    BookService bookService;

    @GetMapping
    public ApiResponse<BooksResponse> getAllBooks(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return ApiResponse.<BooksResponse>builder()
                .code(1000)
                .result(bookService.getAllBooks(pageNo, pageSize, sortBy, sortDir))
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<BookResponse> getBookById(@PathVariable(value = "id") int id){
        return ApiResponse.<BookResponse>builder()
                .result(bookService.getBookById(id))
                .build();
    }

    @PostMapping
    public ApiResponse<BookResponse> createBook(@RequestBody BookRequest bookRequest){

        return ApiResponse.<BookResponse>builder()
                .result(bookService.createBook(bookRequest))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<BookResponse> updateBook(@RequestBody BookRequest bookRequest,
                                                @PathVariable(value = "id") int id){

        return ApiResponse.<BookResponse>builder()
                .result(bookService.updateBook(bookRequest, id))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteBook(@PathVariable(value = "id") int id){
        bookService.deleteBook(id);
        return ApiResponse.<Void>builder()
                .message("Remove book successfully!")
                .build();
    }

    @GetMapping("/getthreebookrelease")
    public ApiResponse<List<BookResponse>> getThreeBookRelease(){
        return ApiResponse.<List<BookResponse>>builder()
                .result(bookService.getThreeBookRelease())
                .build();
    }

}
