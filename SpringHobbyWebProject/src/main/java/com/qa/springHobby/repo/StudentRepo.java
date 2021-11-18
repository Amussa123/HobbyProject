package com.qa.springHobby.repo;


	
	
	import java.util.Optional;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.stereotype.Repository;
	import com.qa.springHobby.domain.Student;


	@Repository
	public interface StudentRepo extends JpaRepository<Student, Long>{

		@Query(value = "SELECT * FROM user WHERE Name = ?1", nativeQuery = true)
		Optional<Student> findByName(String Name);
		
//		@Query(value = "SELECT * FROM user WHERE MagicType = ?1", nativeQuery = true)
//		Optional<Student> findByMagicType(String MaigcType);
//		
		
		
		
	}
