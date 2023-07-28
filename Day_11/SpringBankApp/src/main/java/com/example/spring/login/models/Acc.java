package com.example.spring.login.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="acc_details")

public class Acc {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String accno;
	private String email;
//	private String genre;
	private int year;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Acc(int id, String name, String accno, String email, int year) {
		super();
		this.id = id;
		this.name = name;
		this.accno = accno;
		this.email = email;
		this.year = year;
	}
	public Acc() {
	}
	
		
}
