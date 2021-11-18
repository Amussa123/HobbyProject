package com.qa.springHobby.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.springHobby.domain.School;
import com.qa.springHobby.exceptions.StudentNotFoundexcep;
import com.qa.springHobby.repo.SchoolRepo;

@Service
public class SchoolService {

	private SchoolRepo repo;
	
	public SchoolService(SchoolRepo repo) {
		this.repo = repo;
	}
	
	// Create
	public School create(School school) {
		return this.repo.saveAndFlush(school);
	}
	
	// Read All
	public List<School> getAll() {
		return this.repo.findAll();
	}
	
	// Read By Id
	public School getById(Long id) {
		return this.repo.findById(id).orElseThrow(StudentNotFoundexcep::new);
	}
	

	public School getBySchoolName(String SchoolName) {
		return this.repo.findBySchoolName(SchoolName).get();
	}
	

	
	// Update
    public School update(Long id, School school) {
    	School existing = this.repo.findById(id).get();
    	existing.setSchoolName(school.getSchoolName());
    	existing.setMagicClass(school.getMagicClass());
    	return this.repo.saveAndFlush(existing);
    }

    public boolean delete(Long id) {
        this.repo.deleteById(id);
        return !this.repo.existsById(id);
    }
}

