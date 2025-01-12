package com.dangtinh.library.repository;

import com.dangtinh.library.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findByPublisherId(int id, Pageable pageable);
    Page<Book> findByCategoryId(int id,Pageable pageable);
    Page<Book> findByAuthorId(int id,Pageable pageable);

    @Query(value = "SELECT b FROM Book b ORDER BY b.createdAt DESC LIMIT 3")
    List<Book> findTop3NewestBooks();
}
