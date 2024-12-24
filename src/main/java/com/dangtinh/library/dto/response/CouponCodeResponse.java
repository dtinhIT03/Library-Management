package com.haianh123.library.dto.response;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CouponCodeResponse {
    private int counponCodeId;
    private int counponCodeCount;
    private BigDecimal counponCodeSalePrice;
}
