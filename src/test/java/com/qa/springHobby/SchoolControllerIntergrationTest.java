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
import com.qa.springHobby.domain.School;
import com.qa.springHobby.domain.Student;


	
	@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
	@AutoConfigureMockMvc
	@ActiveProfiles("test")
	@Sql(scripts = {
			"classpath:School-Schema.sql",
			"classpath:School-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class SchoolControllerIntergrationTest {

		
		@Autowired
		private MockMvc mvc;
		
		@Autowired
		private ObjectMapper mapper;
	
		@Test 
		void testCreate() throws Exception {
			School me = new School ("TestSchool", "TestType" , null);
			String meAsJSON = this.mapper.writeValueAsString(me);
			RequestBuilder request = post("/School/create").contentType(MediaType.APPLICATION_JSON).content(meAsJSON);
			
			ResultMatcher checkStatus = status().isCreated();
			
			School meSaved = new School(2, "TestSchool","TestType", null);
			String meSavedAsJSON = this.mapper.writeValueAsString(meSaved);
			
			ResultMatcher checkBody = content().json(meSavedAsJSON);
			
			this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

		}
		
		@Test 
		void testCreate2() throws Exception {
			School me = new School ("TestSchool", "TestType" , null);
			String meAsJSON = this.mapper.writeValueAsString(me);
			RequestBuilder request = post("/School/create").contentType(MediaType.APPLICATION_JSON).content(meAsJSON);
			
			ResultMatcher checkStatus = status().isCreated();
			
			School meSaved = new School(2, "TestSchool","TestType", null);
			String meSavedAsJSON = this.mapper.writeValueAsString(meSaved);
			
			ResultMatcher checkBody = content().json(meSavedAsJSON);
			
			this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

		}
	

		
	 
		@Test
		void testGetId() throws Exception {
			School jb = new School(1, "TestSchool", "TestType",  null);
			String jbAsJSON = this.mapper.writeValueAsString(jb);
			RequestBuilder request = get("/School/getById/1");

			ResultMatcher checkStatus = status().isOk();

			ResultMatcher checkBody = content().json(jbAsJSON);

			this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
		}
		
		
		
		@Test
		void testGetAll() throws Exception {
			School jb = new School(1,"TestSchool", "TestType",  null);
			String usersJSON = this.mapper.writeValueAsString(List.of(jb));
			RequestBuilder request = get("/School/getAll");

			ResultMatcher checkStatus = status().isOk();

			ResultMatcher checkBody = content().json(usersJSON);

			this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
		}
		
		
	
		
		
		@Test
		void testUpdate() throws Exception {
			School me = new School("TestSchool", "TestType",  null);
			String meAsJSON = this.mapper.writeValueAsString(me);
			RequestBuilder request = put("/School/update/1").contentType(MediaType.APPLICATION_JSON).content(meAsJSON);

			ResultMatcher checkStatus = status().isAccepted(); 

			School meSaved = new School(1, "TestSchool", "TestType",  null);
			String meSavedAsJSON = this.mapper.writeValueAsString(meSaved);

			ResultMatcher checkBody = content().json(meSavedAsJSON);

			this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

		}
		
		@Test
		void testDelete() throws Exception {
			this.mvc.perform(delete("/School/delete/1")).andExpect(status().isNoContent());
		}
		
	}

	


