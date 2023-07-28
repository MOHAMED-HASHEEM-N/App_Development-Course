package com.example.spring.login.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.login.models.Acc;
import com.example.spring.login.repository.AccRepo;

	@RequestMapping("/api/v1")
	@CrossOrigin("*")

	@RestController

	public class AccController {
		@Autowired
		private AccRepo eRepo;
		
		@GetMapping("/accs")
		public List<Acc> getAllEmployees() {
			return eRepo.findAll();
		}
		
		@GetMapping("/accs/{id}")
		public Acc getEmployeeById(@PathVariable Integer id) {
			return eRepo.findById(id).get();
		}
		
		@PostMapping("/accs")
		public Acc saveEmployeeDetails(@RequestBody Acc movie) {
			return eRepo.save(movie);
		}
		
		@PutMapping("/accs")
		public Acc updateEmployee(@RequestBody Acc movie) {
			return eRepo.save(movie);
		}
		
		@DeleteMapping("/accs/{id}")
		public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable Integer id) {
			eRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

}
