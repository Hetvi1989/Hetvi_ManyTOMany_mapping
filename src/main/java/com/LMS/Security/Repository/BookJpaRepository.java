package com.LMS.Security.Repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LMS.Security.Entity.Book;
@Repository
public interface BookJpaRepository extends JpaRepository<Book, Integer> {
	
	Set<Book> findByNameContainsAndAuthorContainsAllIgnoreCase(String name, String author);

}
