package com.dangtinh.library.service;

import com.dangtinh.library.dto.request.UserCreateRequest;
import com.dangtinh.library.dto.response.UserResponse;
import jakarta.mail.MessagingException;

public interface UserService {
    UserResponse register(UserCreateRequest request) throws MessagingException;

    boolean accountVerify(String request, String email);
}
