package com.example.spring.login.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.login.models.Transaction;
import com.example.spring.login.repository.TransactionRepo;

public class TransactionService {

	@Service
	public class PayService {
		@Autowired
		TransactionRepo rep;
		
		public Transaction addTran(Transaction tran)
		{
			return rep.save(tran);
		}
		
		public List<Transaction> getTran(){
			return rep.findAll();
		}
	}

}
