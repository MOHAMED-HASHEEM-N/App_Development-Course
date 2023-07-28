package com.example.spring.login.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.spring.login.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//  Optional<User> findByUsername(String username);
//
//  Boolean existsByUsername(String username);
//
//  Boolean existsByEmail(String email);

	@Query("Select e from User e where e.username = :name")
	public List<User> Login(@Param("name") String name);
	
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
