package com.example.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.user.model.Address;
import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;

@SpringBootTest
public class UserApplicationTests2 {

	@Autowired
	private UserService service;
	
	@MockBean
	private UserRepository repository;
	
	Address address1 = new Address(2,"Minneapolis","MN",55343);
	
	User user1 = new User(2,"Bat","J","Man",address1,"102656768");
	Optional<User> op = Optional.of(user1);
	
	@Test
	public void getUserByIdTest() {
		Mockito.when(repository.findById(2)).thenReturn(op);
		
		assertEquals("Bat", op.get().getFirstName());
	}
}
