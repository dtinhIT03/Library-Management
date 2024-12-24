package com.dangtinh.library.service;

import com.dangtinh.library.dto.response.AuthorResponse;

import java.util.List;

public interface AuthorService {
    List<AuthorResponse> getAllAuthors();

    AuthorResponse getAuthorById(int id);
}
