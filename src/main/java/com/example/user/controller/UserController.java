package com.example.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	public UserService userService;

	@GetMapping(path = "/user/{id}")
	public Optional<User> getUserById(@PathVariable int id) { 
		Optional<User> op = Optional.ofNullable(userService.getUserById(id));
		return op;
	}
	//Get User by Phone
	@GetMapping(path = "/userByPhone")
	public Optional<User> getUserByPhone(@RequestParam(value = "phone", required = true) String phone) {
		return userService.getUserByPhone(phone);
	}
	
	@GetMapping(path="/hello/{id}")
	public String sayHello(@PathVariable int id){
		
		return "Hello "+id;
	}
	
	@GetMapping(path = "/user/all")
	@ResponseBody
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping(path = "/user")
	public String addUser(@RequestBody User user) {
		System.out.println(user);
		return userService.addUser(user);
	}

	@PutMapping(path = "/user/{userId}")
	public String updateUser(@PathVariable int userId, @RequestBody User user) throws Exception {
		
		if (userService.getUserById(userId)!=null) {
			User checkUser = userService.getUserById(userId);
			checkUser.setFirstName(user.getFirstName());
			checkUser.setMiddleName(user.getMiddleName());
			checkUser.setLastName(user.getLastName());
			checkUser.setPhone(user.getPhone());	
			return userService.updateUser(checkUser);
		}else {
			return "User Not Found";
		}
	}

	@DeleteMapping(path = "/user/{userId}")
	public String deleteUser(@PathVariable int userId) {
		if (userService.getUserById(userId)!=null) {
			
			return userService.deleteUser(userId);
			
		}else {
			return "User Not Found";
		}
		
	}

}
