package swd20.Bookstore.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swd20.Bookstore.domain.Book;
import swd20.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value = "/index")
	public String doWelcome() {
		
		return "welcome";
		
	}
	
	@RequestMapping(value = "/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@RequestMapping(value = "/add")
	public String addBook (Model model) {
		model.addAttribute("book", new Book());
		
		return "addBook";
	}
	
	@RequestMapping(value ="/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		return "bookedit";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:../booklist";
	}
	

	
}
