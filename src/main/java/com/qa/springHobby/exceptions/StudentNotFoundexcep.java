package com.qa.springHobby.exceptions;


	import javax.persistence.EntityNotFoundException;
	import org.springframework.http.HttpStatus;
	import org.springframework.web.bind.annotation.ResponseStatus;

	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "A Student with that ID does not exist")
	public class StudentNotFoundexcep extends EntityNotFoundException {

		static final long serialVersionUID = -2746986270221225273L;

	}
	


