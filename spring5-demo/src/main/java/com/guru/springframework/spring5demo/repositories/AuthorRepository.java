package com.guru.springframework.spring5demo.repositories;

import org.springframework.data.repository.CrudRepository;
import com.guru.springframework.spring5demo.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    
}
