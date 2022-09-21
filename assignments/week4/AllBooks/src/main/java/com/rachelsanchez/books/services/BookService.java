package com.rachelsanchez.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rachelsanchez.books.models.Book;
import com.rachelsanchez.books.repositories.BookRepository;

@Service
public class BookService {
	    // adding the book repository as a dependency
	@Autowired
	private final BookRepository bookRepository;
	    
	    public BookService(BookRepository bookRepository) {
	        this.bookRepository = bookRepository;
	    }
	    // returns all the books
	    public List<Book> allBooks() {
	        return this.bookRepository.findAll();
	    }
	    public BookRepository getBookRepository() {
			return bookRepository;
		}
		// creates a book
	    public Book createBook(Book b) {
	        return (Book) bookRepository.save(b);
	    }
	    // retrieves a book
	    public com.rachelsanchez.books.models.Book findBook(Long id) {
	        Optional<Book> optionalBook = (bookRepository).findById(id);
	        if(optionalBook.isPresent()) {
	            return optionalBook.get();
	        } else {
	            return null;
	        }
	    }
	}

