package com.guru.springframework.spring5demo.repositories;

import org.springframework.data.repository.CrudRepository;
import com.guru.springframework.spring5demo.domain.Publisher;

public interface PublisherRepository extends CrudRepository <Publisher, Long> {
    
}
