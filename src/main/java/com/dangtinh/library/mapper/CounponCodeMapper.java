package com.haianh123.library.mapper;

import com.haianh123.library.dto.response.CouponCodeResponse;
import com.haianh123.library.entity.Author;
import com.haianh123.library.entity.CouponCode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CounponCodeMapper {
    @Mapping(source = "couponCode.couponCodeId", target = "couponCodeId")
    @Mapping(source = "couponCode.couponCodeCount", target = "couponCodeCount")
    @Mapping(source = "couponCode.couponCodeSalePrice", target = "couponCodeSalePrice")
    CouponCodeResponse toCouponCodeResponse(CouponCode couponCode);
}
