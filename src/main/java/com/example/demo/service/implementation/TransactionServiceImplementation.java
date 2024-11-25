package com.example.demo.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Transactions;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.service.TransactionService;

@Service
public class TransactionServiceImplementation implements TransactionService{

	@Autowired
	private TransactionRepository transactionrepository;

	@Override
	public Transactions saveTransaction(Transactions transaction) {
		// TODO Auto-generated method stub
		return null;
	}

}
