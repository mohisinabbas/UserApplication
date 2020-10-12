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

import org.springframework.http.MediaType;

@SpringBootTest
//@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class UserApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	//@SpyBean
	@MockBean
	private UserRepository repository;
	//private UserService service;
	 
	
	Address address1 = new Address(2,"Minneapolis","MN",55343);
	
	User user1 = new User(2,"Bat","J","Man",address1,"102656768");
	User user2 = new User(1,"Mohisin","J","Mohammed",address1,"5026566768");
	
	@Test
	public void getUserById() throws Exception{
		Optional<User> op = Optional.of(user1);
		Optional<User> op2 = Optional.of(user2);
		//Mockito.when(service.getUserById(Mockito.anyInt())).thenReturn(op);
		Mockito.when(repository.findById(2)).thenReturn(op);
		Mockito.when(repository.findById(1)).thenReturn(op2);
		//Mockito.doNothing().when(service.getUserById(Mockito.anyInt()));
		RequestBuilder requestBuilder1 = MockMvcRequestBuilders.get("/hello/2").accept(MediaType.APPLICATION_JSON);
		//RequestBuilder requestBuilder2 = MockMvcRequestBuilders.get("/hello/2").accept(MediaType.APPLICATION_JSON);
		String expected1 = "Hello Bat";
		//String expected2 = "Hello Bat";
		//System.out.println(requestBuilder1.toString());
		MvcResult result = mockMvc.perform(requestBuilder1)
				  .andExpect(status().isOk()) 
				  .andExpect(content().string(expected1))
				  .andReturn();
		System.out.println(result.getResponse().getContentAsString());

	}
	
}
