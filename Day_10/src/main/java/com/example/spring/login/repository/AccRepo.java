package com.example.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.login.models.Acc;

@Repository
public interface AccRepo extends JpaRepository<Acc, Integer>{

}