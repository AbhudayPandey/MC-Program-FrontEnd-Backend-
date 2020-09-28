package com.example.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cts.model.User;

public interface RegistrationRepository extends JpaRepository<User, Integer> {
	public User findByEmailId(String emailId);
	public User findByEmailIdAndPassword(String emailId,String password);
	public User findByPanAndPassword(String pan,String password);
	
	@Query(value="SELECT * from user where pan=?", nativeQuery = true)
	List<User> findByPan(String pan);
}
