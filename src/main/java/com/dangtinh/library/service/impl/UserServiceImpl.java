package com.dangtinh.library.service.impl;

import com.dangtinh.library.dto.request.UserCreateRequest;
import com.dangtinh.library.entity.User;
import com.dangtinh.library.exception.AppException;
import com.dangtinh.library.exception.ErrorCode;
import com.dangtinh.library.mapper.UserMapper;
import com.dangtinh.library.repository.UserRepository;
import com.dangtinh.library.service.MyEmailService;
import com.dangtinh.library.service.UserService;
import com.dangtinh.library.utils.Role;
import com.dangtinh.library.dto.response.UserResponse;
import jakarta.mail.MessagingException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {
    MyEmailService myEmailService;
    UserRepository userRepository;
    UserMapper userMapper;
    @Override
    public UserResponse register(UserCreateRequest request) throws MessagingException {
        // Kiểm tra xem userAccountName có tồn tại rồi hay không
        if(userRepository.existsByUserAccountName(request.getUserAccountName())){
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        User user = userMapper.toUser(request);
        // Xét role USER
        user.setUserRole(Role.USER.name());

        // Xét active = false
        user.setUserActive(false);

        // Sinh ngẫu nhiên keyactive
        int code = (int) Math.floor(((Math.random() * 8999) + 1000));
        String keyActive = code + "";
        user.setKeyActive(keyActive);

        //Gửi email
        myEmailService.sendHtmlMail(user.getUserAccountName(),
                "Account confirmation code",
                myEmailService.generateVerificationEmailContent(user.getKeyActive()));


        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public boolean accountVerify(String request, String email) {
        User user = userRepository.findByUserAccountName(email).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_EXISTED)
        );

        if (!request.equals(user.getKeyActive())){
            throw new AppException(ErrorCode.WRONG_VERIFY_KEYACTIVE);
        }

        user.setUserActive(true);
        User userUpdate = userRepository.save(user);

        return true;
    }
}











