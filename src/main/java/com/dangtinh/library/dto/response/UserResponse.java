package com.dangtinh.library.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class UserResponse {
    private String userName;
    private String userImage;
    private String userPhoneNumber;
    private String userAddress;
    private String userAccountName;
    private String userRole;
    private Date createdAt;
    private Date updatedAt;
    private BigDecimal userMoney;
}
