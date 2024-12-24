package com.dangtinh.library.service;

import com.dangtinh.library.dto.request.CategoryCreateRequest;
import com.dangtinh.library.dto.response.BooksResponse;
import com.dangtinh.library.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService{
    //get sach theo danh muc(co phan trang sap xep)
    BooksResponse getBooksByCategory(int id,int pageNo,int pageSize,String sortBy,String sortDir);

    // lay tat ca danh muc
    List<CategoryResponse> getAllCategories();

    // Tao category
    CategoryResponse createCategory(CategoryCreateRequest request);

    // Remove categories
    void removeCategory(int categoryId);

    CategoryResponse updateCategory(Integer id, CategoryCreateRequest request);
}


















