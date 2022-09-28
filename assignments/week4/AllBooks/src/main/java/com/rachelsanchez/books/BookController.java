package com.rachelsanchez.books;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rachelsanchez.books.models.Book;
import com.rachelsanchez.books.services.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	    
	
    @RequestMapping("/")
    public String add(Model model) {
    	
       List<Book> books = bookService.allBooks();
       model.addAttribute("books", books);
       return "index.jsp";
    }
	private static Book save(Book b) {
		// TODO Auto-generated method stub
		return b;
	}
	
}
