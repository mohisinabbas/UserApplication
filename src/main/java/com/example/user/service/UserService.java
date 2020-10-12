
package com.example.user.service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.model.User;
import com.example.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	public UserRepository userRepository;

	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserById(int id) {
		return userRepository.findById(id);
	}
	
	public Optional<User> getUserByPhone(String phone) {
		return userRepository.findByPhone(phone);
	}

	public String addUser(User user) {
		if(userRepository.save(user)!=null)
			return "User added Successfully";
		else
			return "Some error..Try again";
	}

	public String updateUser(User user) {
		String response="";
		try {
			userRepository.save(user);
			response = "Update successful";
		}catch(Exception e) {
			response ="Some error in updating";
		}
		
		return response;
	}
	
	public String deleteUser(int id) {
		
		try{
			userRepository.deleteUser(id);
			return "deleted successfully";
		}catch(Exception e) {
			e.printStackTrace();
			return "some issue";
		}
	}

}
