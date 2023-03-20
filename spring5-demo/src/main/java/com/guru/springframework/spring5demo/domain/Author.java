package com.guru.springframework.spring5demo.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {
    @Id
    //Means the underlying database of this model will be provding the generation of this 
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id; 

    private String firstName;
    private String lastName;

    //Relationship
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();
    
    public Author() {

    }

    //Constructor 
    public Author(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters + Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    //ToStrng Method
    @Override
    public String toString() {
        return "Author {" + 
            "id=" + id +
            ", firstName'" + firstName + '\'' + 
            ", lastName'" + lastName + '\'' +
            '}';
    }

    //Equals and Haschode Methods | for Leakage
    //This defines how to call the object in *Boot Strap Data*
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return id != null ? id.equals(author.id) : author.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


}
