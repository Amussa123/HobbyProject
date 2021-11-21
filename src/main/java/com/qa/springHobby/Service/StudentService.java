package com.qa.springHobby.Service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.qa.springHobby.domain.Student;
import com.qa.springHobby.exceptions.StudentNotFoundexcep;
import com.qa.springHobby.repo.StudentRepo;


@Service
public class StudentService {

	private StudentRepo repo;
	
	public StudentService(StudentRepo repo) {
		this.repo = repo;
	}
	
	// Create
	public Student create(Student student) {
		return this.repo.saveAndFlush(student);
	}
	
	// Read All
	public List<Student> getAll() {
		return this.repo.findAll();
	}
	
	// Read By Id
	public Student getById(Long id) {
		return this.repo.findById(id).orElseThrow(StudentNotFoundexcep::new);
	}
	

	public Student getByName(String Name) {
		return this.repo.findByName(Name).get();
	}
	
//	public Student getByMagicType(String MagicType) {
//		return this.repo.findByMagicType(MagicType).get();
//	}
	
	// Update
    public Student update(Long id, Student student) {
    	Student existing = this.repo.findById(id).get();
    	existing.setName(student.getName());
    	existing.setMagicType(student.getMagicType());
    	existing.setAge(student.getAge());
    	return this.repo.saveAndFlush(existing);
    }

    public boolean delete(Long id) {
        this.repo.deleteById(id);
        return !this.repo.existsById(id);
    }
    
}