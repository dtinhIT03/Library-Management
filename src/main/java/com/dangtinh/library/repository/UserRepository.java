package com.dangtinh.library.repository;

import com.dangtinh.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUserAccountName(String userAccountName);
    Optional<User> findByUserAccountName(String userAccountName);
}
