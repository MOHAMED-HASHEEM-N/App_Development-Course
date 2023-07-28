package com.example.spring.login.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Transaction {
	@Id
	private int id;
	private long acc_no_from;
	private int amount;
	private long acc_no_to;
	private String tr_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getAcc_no_from() {
		return acc_no_from;
	}
	public void setAcc_no_from(long acc_no_from) {
		this.acc_no_from = acc_no_from;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public long getAcc_no_to() {
		return acc_no_to;
	}
	public void setAcc_no_to(long acc_no_to) {
		this.acc_no_to = acc_no_to;
	}
	public String getTr_date() {
		return tr_date;
	}
	public void setTr_date(String tr_date) {
		this.tr_date = tr_date;
	}
	public Transaction(int id, long acc_no_from, int amount, long acc_no_to, String tr_date) {
		super();
		this.id = id;
		this.acc_no_from = acc_no_from;
		this.amount = amount;
		this.acc_no_to = acc_no_to;
		this.tr_date = tr_date;
	}
	public Transaction() {
		super();
	}
	
	

}
