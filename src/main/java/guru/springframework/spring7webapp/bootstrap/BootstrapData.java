package guru.springframework.spring7webapp.bootstrap;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import guru.springframework.spring7webapp.domain.Author;
import guru.springframework.spring7webapp.domain.Book;
import guru.springframework.spring7webapp.domain.Publisher;
import guru.springframework.spring7webapp.repositories.AuthorRepository;
import guru.springframework.spring7webapp.repositories.BookRepository;
import guru.springframework.spring7webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements org.springframework.boot.CommandLineRunner {

	private final Logger logger = org.slf4j.LoggerFactory.getLogger(BootstrapData.class);
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Author eric = new Author();
		eric.setFirstName("Eric");
		eric.setLastName("Evans");

		Book ddd = new Book();
		ddd.setTitle("Domain Driven Design");
		ddd.setIsbn("123456");

		Author ericSaved = authorRepository.save(eric);
		Book dddSaved = bookRepository.save(ddd);

		Author rod = new Author();
		rod.setFirstName("Rod");
		rod.setLastName("Johnson");

		Book noEJB = new Book();
		noEJB.setTitle("J2EE Development without EJB");
		noEJB.setIsbn("54757585");

		Author rodSaved = authorRepository.save(rod);
		Book noEJBSaved = bookRepository.save(noEJB);
		
		//ericSaved.getBooks().add(dddSaved);
		dddSaved.getAuthors().add(ericSaved);
		
		//rodSaved.getBooks().add(noEJBSaved);
        noEJBSaved.getAuthors().add(rodSaved);
        
        //bookRepository.save(dddSaved);
        //bookRepository.save(noEJBSaved);
        
        Publisher publisher = new Publisher();
        publisher.setPublisherName("SFG Publishing");
        publisher.setAddress("123 Main Street");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");
        publisher.setZip("33701");
        
        Publisher publisherSaved = publisherRepository.save(publisher);
        logger.info("Publisher saved: ");
        
        dddSaved.setPublisher(publisherSaved);
        noEJBSaved.setPublisher(publisherSaved);
        
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);
        logger.info("dddSaved, noEJBSaved saved: ");
        
        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
	}
}
