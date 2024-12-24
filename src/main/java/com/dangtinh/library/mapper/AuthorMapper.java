package com.dangtinh.library.mapper;

import com.dangtinh.library.dto.response.AuthorResponse;
import com.dangtinh.library.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AuthorMapper {

    @Mapping(source = "description", target = "description")
    AuthorResponse toAuthorResponse(Author author);
}
