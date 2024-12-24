package com.dangtinh.library.mapper;

import com.dangtinh.library.dto.request.CategoryCreateRequest;
import com.dangtinh.library.dto.response.CategoryResponse;
import com.dangtinh.library.entity.Category;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponse toCategoryResponse(Category category);

    Category toCategory(CategoryCreateRequest request);
}
