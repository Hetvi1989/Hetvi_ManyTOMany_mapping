package com.LMS.Security.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.LMS.Security.Entity.Book;
import com.LMS.Security.Entity.Role;
import com.LMS.Security.Entity.User;
import com.LMS.Security.Repository.BookJpaRepository;
import com.LMS.Security.Repository.UserJpaRepository;

@Configuration
public class BootstrapAppData {
	@Autowired
	private BookJpaRepository bookJpaRepository;
	
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	public BootstrapAppData(BookJpaRepository bookJpaRepository, UserJpaRepository userJpaRepository) {
		this.bookJpaRepository = bookJpaRepository;
		this.userJpaRepository = userJpaRepository;
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void onRead(ApplicationReadyEvent event) {
		Book book1 = Book.builder().author("Vinay").name("Small is big").Category("Motivational").build();
		
		Book book2 = Book.builder().author("Nayan").name("What is Wrong").Category("Fictional").build();
		
		Book book3 = Book.builder().author("Jatan").name("What is Programming Language").Category("IT").build();
		
		this.bookJpaRepository.save(book1);
		this.bookJpaRepository.save(book2);
		this.bookJpaRepository.save(book3);
		
		User hetvi = new User("hetvi", "welcome");
		User rutvik = new User("rutvik", "welcome");
		
		Role userRole = new Role ("Role_User");
		Role adminRole = new Role ("Role_Admin");
		
		hetvi.addRole(userRole);
		rutvik.addRole(adminRole);
		rutvik.addRole(userRole);
		
		this.userJpaRepository.save(hetvi);
		this.userJpaRepository.save(rutvik);
		}
}
