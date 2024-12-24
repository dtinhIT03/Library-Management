package com.haianh123.library.dto.request;

import lombok.*;

import java.math.BigDecimal;
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CounponCodeRequest {
    private int counponCodeCount;
    private BigDecimal counponCodeSalePrice;
}
