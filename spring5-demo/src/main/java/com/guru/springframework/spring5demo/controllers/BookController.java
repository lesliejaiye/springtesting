package com.guru.springframework.spring5demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guru.springframework.spring5demo.repositories.BookRepository;

//Tells the environment that we want this to be a Spring MVC Controller
@Controller
public class BookController {
   
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    //defined mapping request 
    @RequestMapping("/books")
    //gives us the model object, this object is what will be returned to the view
    public String getBooks(Model model){
    

    //executes getBooks method, provide that method a 'model' object 
    //our code defines that for that model we are going to define the attribute name 'books'
    //then execute book repository, which will give a list of books | 'find all'
    //and this will be provided to he clients view 
    model.addAttribute("books", bookRepository.findAll());
        return "books";

    }
}
