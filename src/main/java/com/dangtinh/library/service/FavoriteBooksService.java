package com.dangtinh.library.service;

import com.dangtinh.library.dto.response.FavoriteBookResponse;

import java.util.List;


public interface FavoriteBooksService {
    List<FavoriteBookResponse> getAllFavoriteBookByUserId(int userId);
}
