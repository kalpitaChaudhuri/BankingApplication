package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Transactions;
import com.example.demo.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	 @PostMapping("/save")
	    public ResponseEntity<Transactions> saveTransaction(@RequestBody Transactions transaction) {
		 Transactions savedTransaction = transactionService.saveTransaction(transaction);
	        return ResponseEntity.ok(savedTransaction);
	    }
}
