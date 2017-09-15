package com.mstanciu.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mstanciu.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
