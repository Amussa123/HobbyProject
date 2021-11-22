package com.qa.springHobby;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.qa.springHobby.domain.Student;




@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql(scripts = {
		"classpath:Student-schema.sql",
		"classpath:Student-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class StudentCtrollerIntergrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	
	@Test 
	void testCreate() throws Exception {
		Student me = new Student ("Test", "TestType", 18, null);
		String meAsJSON = this.mapper.writeValueAsString(me);
		RequestBuilder request = post("/Student/create").contentType(MediaType.APPLICATION_JSON).content(meAsJSON);
		
		ResultMatcher checkStatus = status().isCreated();
		
		Student meSaved = new Student(2, "Test", "TestType", 18, null);
		String meSavedAsJSON = this.mapper.writeValueAsString(meSaved);
		
		ResultMatcher checkBody = content().json(meSavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	
		
	}
	@Test 
	void testCreate2() throws Exception {
		Student me = new Student ("Test", "TestType", 18, null);
		String meAsJSON = this.mapper.writeValueAsString(me);
		RequestBuilder request = post("/Student/create").contentType(MediaType.APPLICATION_JSON).content(meAsJSON);
		
		ResultMatcher checkStatus = status().isCreated();
		
		Student meSaved = new Student(2, "Test", "TestType", 18, null);
		String meSavedAsJSON = this.mapper.writeValueAsString(meSaved);
		
		ResultMatcher checkBody = content().json(meSavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	
		
	}
	

	
 
	@Test
	void testGetId() throws Exception {
		Student jb = new Student(1, "Test", "TestType", 18, null);
		String jbAsJSON = this.mapper.writeValueAsString(jb);
		RequestBuilder request = get("/Student/getById/1");

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(jbAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetAll() throws Exception {
		Student jb = new Student(1, "Test", "TestType", 18, null);
		String usersJSON = this.mapper.writeValueAsString(List.of(jb));
		RequestBuilder request = get("/Student/getAll");

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(usersJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	

	@Test
	void testUpdate() throws Exception {
		Student me = new Student("Test", "TestType", 18, null);
		String meAsJSON = this.mapper.writeValueAsString(me);
		RequestBuilder request = put("/Student/update/1").contentType(MediaType.APPLICATION_JSON).content(meAsJSON);

		ResultMatcher checkStatus = status().isAccepted(); 

		Student meSaved = new Student(1, "Test", "TestType", 18, null);
		String meSavedAsJSON = this.mapper.writeValueAsString(meSaved);

		ResultMatcher checkBody = content().json(meSavedAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}
	
	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/Student/delete/1")).andExpect(status().isNoContent());
	}
	
}
