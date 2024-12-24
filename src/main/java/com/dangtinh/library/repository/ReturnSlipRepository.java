package com.dangtinh.library.repository;

import com.dangtinh.library.entity.ReturnSlip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnSlipRepository extends JpaRepository<ReturnSlip, Integer> {
}
