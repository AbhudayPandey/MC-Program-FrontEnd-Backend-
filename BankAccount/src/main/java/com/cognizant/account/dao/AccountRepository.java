package com.cognizant.account.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cognizant.account.model.Account;
@Repository
@EnableTransactionManagement
public interface AccountRepository extends JpaRepository<Account, Integer> {
	Account findByAccountNo(long accountNo);
	@Query(value="SELECT * from account where pan=?", nativeQuery = true)
	List<Account> findByPan(String pan);
}
