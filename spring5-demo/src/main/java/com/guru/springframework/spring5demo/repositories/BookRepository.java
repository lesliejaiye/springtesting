package com.guru.springframework.spring5demo.repositories;

import org.springframework.data.repository.CrudRepository;
import com.guru.springframework.spring5demo.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {   
}
