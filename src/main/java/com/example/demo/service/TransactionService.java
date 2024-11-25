package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Transactions;

@Service
public interface TransactionService {

	Transactions saveTransaction(Transactions transaction);
}
