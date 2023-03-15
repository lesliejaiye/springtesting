package com.guru.springframework.spring5demo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.guru.springframework.spring5demo.domain.Author;
import com.guru.springframework.spring5demo.domain.Book;
import com.guru.springframework.spring5demo.domain.Publisher;
import com.guru.springframework.spring5demo.repositories.AuthorRepository;
import com.guru.springframework.spring5demo.repositories.BookRepository;
import com.guru.springframework.spring5demo.repositories.PublisherRepository;

//This script defines data for Author and Book objects 

@Component
public class BootStrapData implements CommandLineRunner {
   
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    public BootStrapData (AuthorRepository authorRepository, BookRepository bookRepository, 
    PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
       
        System.out.println("Started in Bootstrap");

        //Define Author Book, and Publisher
        //Publisher Example
        Publisher publisher = new Publisher();
        publisher.setName("Leslie");
        publisher.setCity("Hampton");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Number of Publishers: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "12345");

        //Add Author, Book and Publisher to respective mappping relationships
        eric.getBooks().add(ddd);
        ddd.getAuthor().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        //Save both sets of information into Repository 
        authorRepository.save(eric);
        bookRepository.save(ddd); 


        //Another example
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "38497594");

        rod.getBooks().add(noEJB);
        noEJB.getAuthor().add(rod);
        
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB); 
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books " + publisher.getBooks().size());

    }
}
