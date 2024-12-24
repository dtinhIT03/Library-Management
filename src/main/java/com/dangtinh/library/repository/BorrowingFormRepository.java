package com.dangtinh.library.repository;

import com.dangtinh.library.entity.BorrowingForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingFormRepository extends JpaRepository<BorrowingForm, Integer> {
}
