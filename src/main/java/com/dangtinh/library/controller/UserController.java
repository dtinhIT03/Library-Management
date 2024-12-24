package com.dangtinh.library.controller;

import com.dangtinh.library.service.FavoriteBooksService;
import com.dangtinh.library.dto.request.UserCreateRequest;
import com.dangtinh.library.dto.response.ApiResponse;
import com.dangtinh.library.dto.response.FavoriteBookResponse;
import com.dangtinh.library.dto.response.UserResponse;
import com.dangtinh.library.service.UserService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    UserService userService;
    FavoriteBooksService favoriteBooksService;

    @PostMapping(value = {"/sigup", "/register"})
    public ApiResponse<UserResponse> createUser(@Valid @RequestBody UserCreateRequest request) throws MessagingException {
        return ApiResponse.<UserResponse>builder()
                .code(1000)
                .result(userService.register(request))
                .build();
    }

    @PostMapping(value = "/varify/keyactive/{email}")
    public ApiResponse<Boolean> verifyKeyActive(@RequestParam(value = "key") String key, @PathVariable(value = "email") String email){


        return ApiResponse.<Boolean>builder()
                .result(userService.accountVerify(key, email))
                .build();
    }

    @GetMapping("/{id}/favoriteBooks")
    public List<FavoriteBookResponse> getAllFavoriteBooksByUserId(@PathVariable(value = "id") int userId){

        return favoriteBooksService.getAllFavoriteBookByUserId(userId);
    }
}













