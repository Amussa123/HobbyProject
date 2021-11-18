package com.qa.springHobby.Controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springHobby.Service.StudentService;
import com.qa.springHobby.domain.Student;

@RestController
@RequestMapping("/Student")
public class StudentController {
	
		private StudentService service;
		
		// Constructor Injection
		public StudentController(StudentService service) {
			this.service = service;
		}

		// Create
		@PostMapping("/create")
		public ResponseEntity<Student> create(@RequestBody Student student) {
			return new ResponseEntity<Student>(this.service.create(student), HttpStatus.CREATED);
		}
		
		// Read
		@GetMapping("/getAll")
		public ResponseEntity<List<Student>> getAll() {
			return new ResponseEntity<List<Student>>(this.service.getAll(), HttpStatus.OK);
		}
		
		// Read by ID
		@GetMapping("/getById/{id}")
		public ResponseEntity<Student> getOne(@PathVariable Long id) {
			return new ResponseEntity<Student>(this.service.getById(id), HttpStatus.OK);
		}
		
		// Custom Query - Get by name
		@GetMapping("/getByName/{Name}")
		public ResponseEntity<Student> getByUsername(@PathVariable String Name) {
			return new ResponseEntity<Student>(this.service.getByName(Name), HttpStatus.OK);
		}
		
		// Update
		@PutMapping("/update/{id}")
		public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
			return new ResponseEntity<Student>(this.service.update(id, student), HttpStatus.ACCEPTED);
		}
		
		// Delete
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Student> delete(@PathVariable Long id) {
			return this.service.delete(id) ? new ResponseEntity<Student>(HttpStatus.NO_CONTENT) 
					: new ResponseEntity<Student>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

}
