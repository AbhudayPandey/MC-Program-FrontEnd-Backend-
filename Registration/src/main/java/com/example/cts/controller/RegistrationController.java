package com.example.cts.controller;

import java.util.List;
import java.util.Optional;

import javax.imageio.spi.RegisterableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cts.model.User;
import com.example.cts.service.RegistrationService;

@RestController
public class RegistrationController {
	@Autowired
	private  RegistrationService service;
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins ="http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId=user.getEmailId();
		if(tempEmailId !=null && !"".equals(tempEmailId)) {
			User userobj=service.fetchUserByEmailId(tempEmailId);
			if(userobj !=null) {
				throw new Exception("user with "+tempEmailId+"is already exist");
			}
		}
		User userObj=null;
		userObj=service.saveUser(user);
		return userObj;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins ="http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception{
		String tempEmailId = user.getEmailId();
		String tempPass = user.getPassword();
		String tempPan=user.getPan();
		User userObj=null;
//		if(tempEmailId !=null && tempPass !=null) {
//			userObj=service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
//		}
		if(tempPan !=null && tempPass !=null) {
			userObj=service.fetchUserPanAndPassword(tempPan, tempPass);
		}

		if(userObj==null) {
			throw new Exception("bad credentials");
		}
		return userObj;
	}
	
	@GetMapping(path="/customerbypan/{pan}")
	@CrossOrigin(origins ="http://localhost:4200")
	public List<User> get(@PathVariable String pan) {
		return service.findByPan(pan);
	}

}