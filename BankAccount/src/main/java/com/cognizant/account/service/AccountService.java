package com.cognizant.account.service;

import java.util.List;
import java.util.Optional;

import com.cognizant.account.model.Account;


public interface AccountService {
	
	Account createAccount(Account account);
	Optional<Account> getById(int id);
	Account findByAccountNo(long accountNo);
	public void updateAccountById(Account account);
	public void deleteAccountById(int id);
	public List<Account> findByPan(String pan);
}
