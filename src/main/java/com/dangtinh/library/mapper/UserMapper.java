package com.dangtinh.library.mapper;

import com.dangtinh.library.dto.request.UserCreateRequest;
import com.dangtinh.library.dto.response.UserResponse;
import com.dangtinh.library.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreateRequest request);
    UserResponse toUserResponse(User user);
}
