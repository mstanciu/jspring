package com.mstanciu.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mstanciu.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
	

}
