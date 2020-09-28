package com.cts;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import com.cts.model.Transaction;
import com.cts.repository.TransactionRepository;
import com.cts.service.ITransactionService;
import com.cts.service.TransactionService;
import com.google.common.util.concurrent.Service;



@SpringBootTest
@RunWith(SpringRunner.class)

class MutualFundServiceApplicationTests {
   
	
	@MockBean
	TransactionRepository repository;
	
	@Autowired
	TransactionService service;
	
	//test case for getAlltransaction
    
	@Test
	public void  getAllTransactTest()
	{
		when(repository.findAll()).thenReturn(Stream.of(new Transaction(14l,1000d),new Transaction(15l,2000d)).collect(Collectors.toList()));
		assertEquals(2,service.getAllTransact().size());
	}
    
	//test case for savetransaction
	@Test
	public void saveTransactTest()
	{
	  Transaction transact=new Transaction(12l,1000d);
	  when(repository.save(transact)).thenReturn(transact);
	  assertEquals(transact,service.saveTransact(transact));
	}

	
	
}
