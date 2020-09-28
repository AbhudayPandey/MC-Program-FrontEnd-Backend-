package com.cts.service;

import java.util.List;
import java.util.Optional;

import com.cts.model.Transaction;

public interface ITransactionService {

	public List<Transaction> getAllTransact();
	public Transaction saveTransact(Transaction transact);
	public Optional<Transaction> getById(Long id);
	public void deleteTransact(Long id);
}
