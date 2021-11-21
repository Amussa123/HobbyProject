package com.qa.springHobby.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class School {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String SchoolName;
	
	@Column(nullable = false)
	private String MagicClass;
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.ALL})
	private Student student;

	public School() {}

	public School(long id, String schoolName, String magicClass, Student student) {
		super();
		this.id = id;
		SchoolName = schoolName;
		MagicClass = magicClass;
		this.student = student;
	}

	public School(String schoolName, String magicClass, Student student) {
		super();
		SchoolName = schoolName;
		MagicClass = magicClass;
		this.student = student;
	}
		
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSchoolName() {
		return SchoolName;
	}

	public void setSchoolName(String schoolName) {
		SchoolName = schoolName;
	}

	public String getMagicClass() {
		return MagicClass;
	}

	public void setMagicClass(String magicClass) {
		MagicClass = magicClass;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MagicClass == null) ? 0 : MagicClass.hashCode());
		result = prime * result + ((SchoolName == null) ? 0 : SchoolName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((student == null) ? 0 : student.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		School other = (School) obj;
		if (MagicClass == null) {
			if (other.MagicClass != null)
				return false;
		} else if (!MagicClass.equals(other.MagicClass))
			return false;
		if (SchoolName == null) {
			if (other.SchoolName != null)
				return false;
		} else if (!SchoolName.equals(other.SchoolName))
			return false;
		if (id != other.id)
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}

	
}