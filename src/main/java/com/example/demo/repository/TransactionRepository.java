package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, Integer>{

	List<Transactions> findByAccountId(int id);
}
