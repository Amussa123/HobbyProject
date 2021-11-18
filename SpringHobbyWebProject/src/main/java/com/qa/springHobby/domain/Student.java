package com.qa.springHobby.domain;

import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String Name;
	
	@Column(nullable = false)
	private String MagicType;
	
	@Column(nullable = false)
	private long Age;
	
	@Column(nullable = false)
	private Long Tuition;
	
	@JsonIgnore
	@OneToMany(mappedBy="student")
	private List<School> school;

	public Student() {}
	
	
	//constructor without the ID
	
	public Student(String name, String magicType, long age, Long tuition, List<School> school) {
		
		Name = name;
		MagicType = magicType;
		Age = age;
		Tuition = tuition;
		this.school = school;
	}
//with ID For the Testing


	public Student(long id, String name, String magicType, long age, Long tuition, List<School> school) {
		super();
		this.id = id;
		Name = name;
		MagicType = magicType;
		Age = age;
		Tuition = tuition;
		this.school = school;
	}
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getMagicType() {
		return MagicType;
	}


	public void setMagicType(String magicType) {
		MagicType = magicType;
	}


	public long getAge() {
		return Age;
	}


	public void setAge(long age) {
		Age = age;
	}


	public Long getTuition() {
		return Tuition;
	}


	public void setTuition(Long tuition) {
		Tuition = tuition;
	}


	public List<School> getSchool() {
		return school;
	}


	public void setSchool(List<School> school) {
		this.school = school;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (Age ^ (Age >>> 32));
		result = prime * result + ((MagicType == null) ? 0 : MagicType.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((Tuition == null) ? 0 : Tuition.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((school == null) ? 0 : school.hashCode());
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
		Student other = (Student) obj;
		if (Age != other.Age)
			return false;
		if (MagicType == null) {
			if (other.MagicType != null)
				return false;
		} else if (!MagicType.equals(other.MagicType))
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Tuition == null) {
			if (other.Tuition != null)
				return false;
		} else if (!Tuition.equals(other.Tuition))
			return false;
		if (id != other.id)
			return false;
		if (school == null) {
			if (other.school != null)
				return false;
		} else if (!school.equals(other.school))
			return false;
		return true;
	}
	
	}
	