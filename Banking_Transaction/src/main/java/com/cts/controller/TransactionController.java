package com.cts.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.TransactionException;
import com.cts.logger.GlobalResource;
import com.cts.model.Transaction;
import com.cts.service.TransactionService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;


@RestController
public class TransactionController {
	
	@Autowired
	TransactionService service;
	
	//get logger variable
		private Logger logger = GlobalResource.getLogger(TransactionController.class);

		
	
	@GetMapping("/transaction")
	
	@HystrixCommand(fallbackMethod="ListOfTransaction_FallBack")
	
	@ApiOperation(value = "Find All Transactions",
	notes="Return all transaction with there details",
	response = Transaction.class)
	public ResponseEntity<Object> getAllTransaction() {
		//logging
		  String methodName = "getAllTransaction()";
	   	  logger.info(methodName+" called");
	   	  
	    return new ResponseEntity<>(service.getAllTransact(),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Create a new Transactions",
			notes="Put new transaction into the List",
			response = Transaction.class)
	@PostMapping("/transaction")
	@CrossOrigin(origins ="http://localhost:4200")
	public Transaction createTransaction(@Valid @RequestBody Transaction transact) {
		//logging
		  String methodName = "createTransaction()";
	   	  logger.info(methodName+" called");
		return service.saveTransact(transact);
	}
	
	@ApiOperation(value = "Find Transactions from the Transaction List",
			notes="Use transaction Id for Searching",
			response = Transaction.class)
	
	
	@GetMapping("/transaction/{id}")	
	//@HystrixCommand(fallbackMethod="ListOfTransactionByID_FallBack")

	public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id) {
		//logging
		  String methodName = "getById()";
	   	  logger.info(methodName+" called");
	   	Transaction transact =service.getById(id)
        .orElseThrow(() -> new TransactionException("Transact", "id", id));
	    return new ResponseEntity<>(transact,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete Transactions from List",
			notes="Delete Existing transaction from the List",
			response = Transaction.class)
	@DeleteMapping("/transaction/{id}")
	public ResponseEntity<?> deleteId(@PathVariable(value = "id") Long id) {
		//logging
		  String methodName = "deleteId()";
	   	  logger.info(methodName+" called");
		Transaction transact = service.getById(id)
	            .orElseThrow(() -> new TransactionException("Transact", "id", id));

		service.deleteTransact(id);

	    return ResponseEntity.ok().build();
	}
	public ResponseEntity<Object> ListOfTransaction_FallBack()
	{	//logging
		  String methodName = "ListOfTransaction_FallBack()";
	   	  logger.info(methodName+" called");
		return new ResponseEntity<>(service.getAllTransact(), HttpStatus.OK);
	}
	
	public ResponseEntity<Object> ListOfTransactionByID_FallBack(@PathVariable("id") Long id) throws InterruptedException
	{   //logging
		String methodName = "ListOfTransactionByID_FallBack()";
	   	logger.info(methodName+" called");
	   	Thread.sleep(4000);
		return new ResponseEntity<>("Not Found", HttpStatus.OK);
	}
	
	@GetMapping(path="/fundbypan/{pan}")
	@CrossOrigin(origins ="http://localhost:4200")
	public List<Transaction> get(@PathVariable String pan) {
		return service.findByPan(pan);
	}
}
