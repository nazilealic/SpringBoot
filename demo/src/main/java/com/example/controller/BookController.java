package com.example.controller;

import com.example.demo.DemoApplication;
import com.example.entity.Book;
import com.example.repository.BookRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

	private final BookRepository bookRepository;

	public BookController (BookRepository bookRepository) {
		this.bookRepository= bookRepository ;
	}
	
	@PostMapping
	public Book addBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}
	@GetMapping
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Book getBookId(@PathVariable Long id) {
	    
	    Optional<Book> optionalBook = bookRepository.findById(id);

	    if (optionalBook.isPresent()) {
	        return optionalBook.get();
	    } else {
	        throw new RuntimeException("Book not found with id " + id);
	    }
	}
	
	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable Long id) {
		if (!bookRepository.existsById(id)) {
	        throw new RuntimeException("Book not found with id " + id);
	    }
		bookRepository.deleteById(id);
		return "book deleted successfully";
	}
	
	@PutMapping("/{id}")
	public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
		Book book = bookRepository.findById(id).orElse(null);

		if (book != null) {
		    book.setTitle(updatedBook.getTitle());
		    book.setAuthor(updatedBook.getAuthor());
		    book.setPrice(updatedBook.getPrice());
		    return bookRepository.save(book);
		} else {
		    throw new RuntimeException("Book not found with id " + id);
		}

	}
	
}
