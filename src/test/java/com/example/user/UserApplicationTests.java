package com.example.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.user.controller.UserController;
import com.example.user.model.Address;
import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.MediaType;

@SpringBootTest
//@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class UserApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	// @SpyBean
	/*
	 * @MockBean private UserRepository repository;
	 */
	// private UserService service;

	Address address1 = new Address(2, "Minneapolis", "MN", 55343);
	Address address2 = new Address(1, "Louisville", "KY", 40222);
	ObjectMapper om = new ObjectMapper();
	
	User user1 = new User(8, "Bat3", "J", "Man", address1, "102656768");
	User user2 = new User(7, "Mohisin", "J", "Mohammed", address2, "5026566768");
	
	@Test
	public void getUserById() throws Exception {
		/*
		 * Optional<User> op = Optional.of(user1); Optional<User> op2 =
		 * Optional.of(user2);
		 */
		// Mockito.when(service.getUserById(Mockito.anyInt())).thenReturn(op);
		// Mockito.when(repository.findById(2)).thenReturn(op);
		// Mockito.when(repository.findById(1)).thenReturn(op2);
		// Mockito.doNothing().when(service.getUserById(Mockito.anyInt()));
		RequestBuilder requestBuilder1 = MockMvcRequestBuilders.get("/user/7").accept(MediaType.APPLICATION_JSON);
		// RequestBuilder requestBuilder2 =
		// MockMvcRequestBuilders.get("/hello/2").accept(MediaType.APPLICATION_JSON);
		String expected1 = om.writeValueAsString(user2);
		String expected2 ="Hello 2";
		System.out.println(expected1);
		// String expected2 = "Hello Bat";
		// System.out.println(requestBuilder1.toString());
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/hello/2"))
				.andExpect(status().isOk())
				.andExpect(content().string(expected2)).andReturn();
		

		//System.out.println(result.getResponse().getContentAsString());

	}
	
	@Test
	public void addUserTest() throws Exception {
		String jsonRequest = om.writeValueAsString(user1);
		//System.out.println(jsonRequest);
		MvcResult result2 = mockMvc
				.perform(MockMvcRequestBuilders.post("/user").content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		//System.out.println(result2.getResponse().getContentAsString());
	}

}
