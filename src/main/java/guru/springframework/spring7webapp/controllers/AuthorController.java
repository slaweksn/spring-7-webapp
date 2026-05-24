package guru.springframework.spring7webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import guru.springframework.spring7webapp.services.AuthorService;
import guru.springframework.spring7webapp.services.BookService;

@Controller
public class AuthorController {

	private final AuthorService authorService;
	
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@GetMapping("/authors")
	public String getBooks(Model model) {
		System.out.println("Getting books...");
		model.addAttribute("authors", authorService.findAll());
		
		return "authors";
	}
	
}
