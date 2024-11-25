package com.example.demo.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.TransactionRepository;

@Component
public class TransactionServiceImplementation implements TransactionRepository{

	@Autowired
	private TransactionRepository transactionrepository;
}
