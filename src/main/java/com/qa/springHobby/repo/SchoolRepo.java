package com.qa.springHobby.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.springHobby.domain.School;

	@Repository
	public interface SchoolRepo extends JpaRepository<School, Long>{

	@Query(value = "SELECT * FROM School WHERE SchoolName = 1", nativeQuery = true)
	Optional<School> findBySchoolName(String SchoolName);

}
