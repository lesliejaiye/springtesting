package com.guru.springframework.spring5demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.guru.springframework.spring5demo.repositories.AuthorRepository;

@Controller
public class AuthorController {
    
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;

    }

    @RequestMapping("/authors")
    public String getAuthors(Model model1){

        model1.addAttribute("authors", authorRepository.findAll());

        return "authors/list";
    }

}
