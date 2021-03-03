package swd20.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd20.Bookstore.domain.Book;
import swd20.Bookstore.domain.BookRepository;
import swd20.Bookstore.domain.Category;
import swd20.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository Crepository) {
		return (args) -> {
			Book a = new Book ("Taru sormusten herrasta", "J.R.R Tolkien", 1954, "978-951-0-33337-2", 38.40);
			Book b = new Book("Harry Potter ja salaisuuksien kammio", "J.K Rowling", 1998, "951-31-1472-4", 17.95);
			
			Category c = new Category("sci-fi");
			Category d = new Category("romance");
			
			repository.save(a);
			repository.save(b);
			Crepository.save(c);
			Crepository.save(d);
		};
		
	}

}
