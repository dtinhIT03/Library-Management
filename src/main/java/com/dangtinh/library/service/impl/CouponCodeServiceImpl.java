package com.dangtinh.library.service.impl;

import com.dangtinh.library.dto.request.CounponCodeRequest;
import com.dangtinh.library.dto.response.CounponCodesResponse;
import com.dangtinh.library.dto.response.CouponCodeResponse;
import com.dangtinh.library.entity.CouponCode;
import com.dangtinh.library.exception.AppException;
import com.dangtinh.library.exception.ErrorCode;
import com.dangtinh.library.mapper.CounponCodeMapper;
import com.dangtinh.library.repository.CouponCodeRepository;
import com.dangtinh.library.service.CouponCodeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

public class CouponCodeServiceImpl implements CouponCodeService {
    CouponCodeRepository couponCodeRepository;
    CounponCodeMapper counponCodeMapper;

    public CouponCodeServiceImpl(CouponCodeRepository couponCodeRepository, CounponCodeMapper counponCodeMapper) {
        this.couponCodeRepository = couponCodeRepository;
        this.counponCodeMapper = counponCodeMapper;
    }

    @Override
    public CouponCodeResponse getCounponCodeById(int id) {
        CouponCode counponCode= couponCodeRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.COUPONCODE_NOT_EXISTED));

        return counponCodeMapper.toCouponCodeResponse(counponCode);
    }

    @Override
    public CounponCodesResponse getAllCounponCode(int pageNo, int pageSize, String sortDir, String sortBy) {

        Sort sort =sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable= PageRequest.of(pageNo,pageSize,sort);

        Page<CouponCode> couponCodes=couponCodeRepository.findAll(pageable);
        //get content for pageObject
        List<CouponCode> listOfBooks=couponCodes.getContent();
        List<CouponCodeResponse> content = listOfBooks.stream().map(counponCodeMapper::toCouponCodeResponse).collect(Collectors.toList());
        //set couponCodeResponse
        CounponCodesResponse counponCodesResponse=new CounponCodesResponse();
        counponCodesResponse.setContent(content);
        counponCodesResponse.setPageNo(couponCodes.getNumber());
        counponCodesResponse.setPageSize(couponCodes.getSize());
        counponCodesResponse.setTotalElements((int) couponCodes.getTotalElements());
        counponCodesResponse.setTotalPages(couponCodes.getTotalPages());
        counponCodesResponse.setLast(couponCodes.isLast());
        return counponCodesResponse;
    }

    @Override
    public CouponCodeResponse createCounponCode(CounponCodeRequest counponCodeRequest) {
        return null;
    }

    @Override
    public CouponCodeResponse updateCounponCode(int id, CounponCodeRequest counponCodeRequest) {
        return null;
    }

    @Override
    public void deleteCounponCode(int id) {

    }
}
