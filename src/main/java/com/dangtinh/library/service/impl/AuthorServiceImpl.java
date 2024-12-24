package com.dangtinh.library.service.impl;

import com.dangtinh.library.dto.response.AuthorResponse;
import com.dangtinh.library.entity.Author;
import com.dangtinh.library.exception.AppException;
import com.dangtinh.library.exception.ErrorCode;
import com.dangtinh.library.mapper.AuthorMapper;
import com.dangtinh.library.repository.AuthorRepository;
import com.dangtinh.library.service.AuthorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthorServiceImpl implements AuthorService {
    AuthorRepository authorRepository;
    AuthorMapper authorMapper;

    @Override
    public List<AuthorResponse> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(authorMapper::toAuthorResponse).toList();
    }

    @Override
    public AuthorResponse getAuthorById(int id) {
        Author author = authorRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorCode.AUTHOR_NOT_EXISTED)
        );

        return authorMapper.toAuthorResponse(author);
    }
}












