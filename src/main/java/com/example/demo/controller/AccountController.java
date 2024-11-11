package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.accdto.AccountDto;
import com.example.demo.service.AccountService;

@RestController
@RequestMapping("/system")
public class AccountController {

	@Autowired
	AccountService accountservice;
	
	@PostMapping("/save")
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountdto) {
		return new ResponseEntity<AccountDto>(accountservice.createAccount(accountdto), HttpStatus.CREATED);
	}
	
}