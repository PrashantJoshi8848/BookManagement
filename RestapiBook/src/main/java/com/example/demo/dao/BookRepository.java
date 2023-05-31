package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Book;
@Component
public interface BookRepository extends CrudRepository<Book,Integer> {
	public Book findById(int id);

}
