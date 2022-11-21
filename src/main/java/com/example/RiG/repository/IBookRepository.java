package com.example.RiG.repository;

import com.example.RiG.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByName(String name);
}
