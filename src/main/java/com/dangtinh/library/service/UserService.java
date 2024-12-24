package com.haianh123.library.service;

import com.haianh123.library.dto.request.UserCreateRequest;
import com.haianh123.library.dto.response.UserResponse;
import jakarta.mail.MessagingException;

public interface UserService {
    UserResponse register(UserCreateRequest request) throws MessagingException;

    boolean accountVerify(String request, String email);
}
