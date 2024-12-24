package com.haianh123.library.repository;

import com.haianh123.library.entity.BorrowingForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingFormRepository extends JpaRepository<BorrowingForm, Integer> {
}
