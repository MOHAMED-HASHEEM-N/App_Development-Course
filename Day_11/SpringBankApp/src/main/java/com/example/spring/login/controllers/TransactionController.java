package com.example.spring.login.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.login.models.Transaction;
import com.example.spring.login.repository.TransactionRepo;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
@RequestMapping("api/auth")
@RestController
public class TransactionController {
	
	@Autowired
	TransactionRepo rep;
	
	@PostMapping("/pay")
	public Transaction addTran(@RequestBody Transaction tran)
	{
		return rep.save(tran);
	}
	
	@GetMapping("/gethis")
	public List<Transaction> getTran(){
		return rep.findAll();
	}
}
