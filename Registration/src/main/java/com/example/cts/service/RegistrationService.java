package com.example.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cts.model.User;
import com.example.cts.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repo;
	
	public User  saveUser(User user) {
		return repo.save(user);
	}
	
	public User fetchUserByEmailId(String email) {
		return repo.findByEmailId(email);
	}
	public User fetchUserByEmailIdAndPassword(String email,String password) {
		return repo.findByEmailIdAndPassword(email,password);
	}
	public User fetchUserPanAndPassword(String pan,String password) {
		return repo.findByPanAndPassword(pan,password);
	}
	public List<User> findByPan(String pan) {
		return repo.findByPan(pan);
	}
	
}
 