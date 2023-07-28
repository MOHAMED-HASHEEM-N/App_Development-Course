package com.example.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.login.models.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction,Integer>{

}
