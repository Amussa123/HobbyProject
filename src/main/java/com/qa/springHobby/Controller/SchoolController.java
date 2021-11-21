package com.qa.springHobby.Controller;

	import java.util.List;

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

import com.qa.springHobby.Service.SchoolService;

import com.qa.springHobby.domain.School;
	
	@CrossOrigin
	@RestController
	@RequestMapping("/School")
	public class SchoolController  {
		
			private SchoolService service;
			
			// Constructor Injection
			public SchoolController(SchoolService service) {
				this.service = service;
			}

			// Create
			@PostMapping("/create")
			public ResponseEntity<School> create(@RequestBody School school) {
				return new ResponseEntity<School>(this.service.create(school), HttpStatus.CREATED);
			}
			
			// Read
			@GetMapping("/getAll")
			public ResponseEntity<List<School>> getAll() {
				return new ResponseEntity<List<School>>(this.service.getAll(), HttpStatus.OK);
			}
			
			// Read by ID
			@GetMapping("/getById/{id}")
			public ResponseEntity<School> getOne(@PathVariable Long id) {
				return new ResponseEntity<School>(this.service.getById(id), HttpStatus.OK);
			}
			
			
			
			// Update
			@PutMapping("/update/{id}")
			public ResponseEntity<School> update(@PathVariable Long id, @RequestBody School school) {
				return new ResponseEntity<School>(this.service.update(id, school), HttpStatus.ACCEPTED);
			}
			
			// Delete
			@DeleteMapping("/delete/{id}")
			public ResponseEntity<School> delete(@PathVariable Long id) {
				return this.service.delete(id) ? new ResponseEntity<School>(HttpStatus.NO_CONTENT) 
						: new ResponseEntity<School>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

	}


