package guru.springframework.spring7webapp.services;

import org.springframework.stereotype.Service;

import guru.springframework.spring7webapp.domain.Author;
import guru.springframework.spring7webapp.repositories.AuthorRepository;

@Service
class AuthorServiceImpl implements AuthorService {

	private final AuthorRepository authorRepository;;
	
	public AuthorServiceImpl(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	@Override
	public Iterable<Author> findAll() {
		// TODO Auto-generated method stub
		return authorRepository.findAll();
	}

}
