package com.example.demo.entities;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Auther {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID AutherID;
	public Auther() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UUID getAutherID() {
		return AutherID;
	}

	public void setAutherID(UUID autherID) {
		AutherID = autherID;
	}

	public String getAuther_FirstName() {
		return Auther_FirstName;
	}
	public void setAuther_FirstName(String auther_FirstName) {
		Auther_FirstName = auther_FirstName;
	}
	
	public String getAutherAddress() {
		return autherAddress;
	}
	public void setAutherAddress(String autherAddress) {
		this.autherAddress = autherAddress;
	}

	
	
	public String getAuther_LastName() {
		return Auther_LastName;
	}
	public void setAuther_LastName(String auther_LastName) {
		Auther_LastName = auther_LastName;
	}



	private String Auther_FirstName;
	private String autherAddress;
	private String Auther_LastName;
	@OneToOne(mappedBy = "auther")
	@JsonBackReference
	private Book book;
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
}
