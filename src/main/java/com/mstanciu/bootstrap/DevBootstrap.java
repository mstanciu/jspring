package com.mstanciu.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.mstanciu.model.Author;
import com.mstanciu.model.Book;
import com.mstanciu.model.Publisher;
import com.mstanciu.repositories.AuthorRepository;
import com.mstanciu.repositories.BookRepository;
import com.mstanciu.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepo;
	private BookRepository bookRepo;
	private PublisherRepository publisherRepo;

	public DevBootstrap(AuthorRepository authorRepo, BookRepository bookRepo, PublisherRepository publisherRepo) {
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
		this.publisherRepo = publisherRepo;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
	}
	
	private void initData() {
		
		//Publisher corint and luxoft
		Publisher corint  = new Publisher("corint", "Principala");
		Publisher luxoft  = new Publisher("luxoft", "Pipera");
		publisherRepo.save(corint);
		publisherRepo.save(luxoft);
		//Marius
				
		Author marius = new Author("marius","stanciu");
		Book marius_book = new Book("Dragon boss", "1234",  corint);
		marius.getBooks().add(marius_book);
		marius_book.getAuthors().add(marius);
		
		authorRepo.save(marius);
		bookRepo.save(marius_book);
		
		//Rod
		Author rod = new Author("Rod","Johnson");
		Book rod_book = new Book("Java dev without EJB", "23334",  luxoft);
		rod.getBooks().add(rod_book);

		authorRepo.save(rod);	
		bookRepo.save(rod_book);
		
		

	}

}
