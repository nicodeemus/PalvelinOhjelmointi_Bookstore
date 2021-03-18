package swd20.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd20.Bookstore.domain.Book;
import swd20.Bookstore.domain.BookRepository;
import swd20.Bookstore.domain.Category;
import swd20.Bookstore.domain.CategoryRepository;
import swd20.Bookstore.domain.UserRepository;
import swd20.Bookstore.domain.User;



@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository Crepository, UserRepository urepository) {
		return (args) -> {
			
			Category c = new Category("sci-fi");
			Category d = new Category("romance");
			Category e = new Category("fantasy");
			
			Book a = new Book ("Taru sormusten herrasta", "J.R.R Tolkien", 1954, "978-951-0-33337-2", 38.40, e);
			Book b = new Book("Harry Potter ja salaisuuksien kammio", "J.K Rowling", 1998, "951-31-1472-4", 17.95, e);
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			
			urepository.save(user1);
			urepository.save(user2);
			
			
			Crepository.save(c);
			Crepository.save(d);
			Crepository.save(e);
			
			repository.save(a);
			repository.save(b);
			
		
			
		
			
			

		};
		
	}

}
