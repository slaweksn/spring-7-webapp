package guru.springframework.spring7webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import guru.springframework.spring7webapp.services.BookService;

@Controller
public class BookController {

	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/books")
	public String getBooks(Model model) {
		System.out.println("Getting books...");
		model.addAttribute("books", bookService.findAll());
		
		return "books";
	}
	
}
