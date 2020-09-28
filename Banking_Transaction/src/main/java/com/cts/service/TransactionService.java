package com.cts.service;
import org.slf4j.Logger;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.logger.GlobalResource;
import com.cts.model.Transaction;
import com.cts.repository.TransactionRepository;


@Service
@Transactional
public class TransactionService implements ITransactionService {
	
	@Autowired
	TransactionRepository repository;
	
	private Logger logger = GlobalResource.getLogger(TransactionService.class);

	public List<Transaction> getAllTransact(){
		//logging
			String methodName = "getAllTransact()";
			logger.info(methodName+" called");
			
		return (List<Transaction>) repository.findAll();
	}
	
	
	public Transaction saveTransact(Transaction transact) {
		//logging
		String methodName = "saveTransact()";
		logger.info(methodName+" called");
		
		return repository.save(transact);
	}
	
	
	public Optional<Transaction> getById(Long id) {
		//logging
				String methodName = "getByIdService()";
				logger.info(methodName+" called");
		return repository.findById(id);
	}
	
	public void deleteTransact(Long id) {
		//logging
		String methodName = "deleteTransact()";
		logger.info(methodName+" called");
		repository.deleteById(id);
	}
	public List<Transaction> findByPan(String pan) {
		return repository.findByPan(pan);
	}



}
