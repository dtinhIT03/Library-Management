package com.haianh123.library.service;

import com.haianh123.library.dto.request.CounponCodeRequest;
import com.haianh123.library.dto.response.CounponCodesResponse;
import com.haianh123.library.dto.response.CouponCodeResponse;
import com.haianh123.library.entity.CouponCode;
import org.springframework.data.domain.Page;

public interface CouponCodeService {
    CouponCodeResponse getCounponCodeById(int id);
    CounponCodesResponse getAllCounponCode(int pageNo, int pageSize, String sortDir, String sortBy);
    CouponCodeResponse createCounponCode(CounponCodeRequest counponCodeRequest);
    CouponCodeResponse updateCounponCode(int id, CounponCodeRequest counponCodeRequest);
    void deleteCounponCode(int id);

}
