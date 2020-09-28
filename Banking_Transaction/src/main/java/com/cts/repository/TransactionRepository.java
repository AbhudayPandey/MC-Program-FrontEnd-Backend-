package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query(value="SELECT * from transaction_details where pan=?", nativeQuery = true)
	List<Transaction> findByPan(String pan);
}
