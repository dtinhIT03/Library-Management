package com.haianh123.library.dto.response;

import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CounponCodesResponse {
    private int pageNo;
    private int pageSize;
    private int totalPages;
    private int totalElements;
    private boolean last;
    private List<CouponCodeResponse> content;
}
