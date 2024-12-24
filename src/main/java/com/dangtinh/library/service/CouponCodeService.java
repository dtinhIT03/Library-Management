package com.dangtinh.library.service;

import com.dangtinh.library.dto.request.CounponCodeRequest;
import com.dangtinh.library.dto.response.CounponCodesResponse;
import com.dangtinh.library.dto.response.CouponCodeResponse;

public interface CouponCodeService {
    CouponCodeResponse getCounponCodeById(int id);
    CounponCodesResponse getAllCounponCode(int pageNo, int pageSize, String sortDir, String sortBy);
    CouponCodeResponse createCounponCode(CounponCodeRequest counponCodeRequest);
    CouponCodeResponse updateCounponCode(int id, CounponCodeRequest counponCodeRequest);
    void deleteCounponCode(int id);

}
