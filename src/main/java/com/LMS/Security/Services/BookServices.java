package com.LMS.Security.Services;

import java.util.Set;

import com.LMS.Security.Entity.Book;

public interface BookServices {
	
	public Set<Book> findAll();
	
	public Book findByID(int Id);
	
	public Book save(Book book);
	
	public void deleteById(int id);
	
	public Set<Book> searchBook(String name, String author);

}
