package com.LMS.Security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LMS.Security.Entity.User;
@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {

}
