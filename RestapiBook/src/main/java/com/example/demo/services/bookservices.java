package com.example.demo.services;

import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.example.demo.dao.BookRepository;
import com.example.demo.entities.Book;

@Component
public class bookservices {
	
	@Autowired
	BookRepository bookrepo;
	
	
	public List<Book> getList(){
		List<Book> itrIterable=(List<Book>) bookrepo.findAll();
		return itrIterable;
	}
	
	public Book getSinglebook(int id) {
		return bookrepo.findById(id);
	}
	public Book addBook(Book b) {
		return bookrepo.save(b);
	}
	public void deleteBook(int id){
		 bookrepo.deleteById(id);
	}
	public void updateBook(Book b,int x){
		b.setId(x);
		bookrepo.save(b);
	}
}
