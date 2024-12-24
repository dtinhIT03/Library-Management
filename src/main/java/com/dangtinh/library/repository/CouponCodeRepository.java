package com.dangtinh.library.repository;

import com.dangtinh.library.entity.CouponCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponCodeRepository extends JpaRepository<CouponCode, Integer> {
}
