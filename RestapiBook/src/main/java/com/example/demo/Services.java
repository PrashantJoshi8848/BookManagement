package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.example.demo.dao.BookRepository;
import com.example.demo.entities.Book;

@Component
public class Services {

/*
	  private static List<Book> books = new ArrayList<>();
	  
	  static { 
		  Book book = new Book(); 
		  book.setId(1); 
		  book.setName("spring");
	      book.setAuther("prashant");
	  
	  Book book1 = new Book(); book1.setId(2); book1.setName("spring");
	  book1.setAuther("prashant");
	  
	  Book book2 = new Book(); book2.setId(3); book2.setName("spring");
	  book2.setAuther("prashant");
	  
	  Book book3 = new Book(); book3.setId(5); book3.setName("spring");
	  book3.setAuther("prashant");
	  
	  books.add(book3); books.add(book2); books.add(book1); books.add(book); }
	  
	  public List<Book> getList() { return books; }
	  
	  public Book getSinglebook(int id) { Book bkBook = null; try {
	  
	  bkBook = books.stream().filter(e -> e.getId() == id).findFirst().get(); }
	  catch (Exception e2) {  e2.getStackTrace(); } return bkBook; } 
	  
	  public Book addBook(Book b) { books.add(b); return b; }
	  
	  public List<Book> deleteBook(int id) {
	  books=books.stream().filter(e->e.getId()!=id?true:false).collect(Collectors.
	  toList()); return books; }
	  
	  public List<Book> updateBook(Book b,int x) { books=books.stream().map(e->{
	  if(e.getId()==x) { e.setName(b.getName()); e.setAuther(b.getAuther()); }
	  return e; }).collect(Collectors.toList()); return books; }
	 */

   @Autowired
	BookRepository bookRepository;	
	
	public List<Book> getList(){
		List<Book> itrIterable=(List<Book>) bookRepository.findAll();
		return itrIterable;
	}
	
	public Book getSinglebook(int id) {
		System.out.println(id);
		return  bookRepository.findById(id);
	}
	public Book addBook(Book b) {
	Book book=	bookRepository.save(b);
		return book ;
	}
	public void deleteBook(int id){
		 bookRepository.deleteById(id);
	}
	public void updateBook(Book b,int x){
		b.setId(x);
		bookRepository.save(b);
	}

}
