package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/id/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable int id) {
		AccountDto accountdto=accountservice.getAccountById(id);
		return ResponseEntity.ok(accountdto);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<AccountDto> getAccountByName(@PathVariable String name) throws Exception {
		AccountDto accountdto=accountservice.getAccountByName(name);
		return ResponseEntity.ok(accountdto);
	}
	
	@GetMapping("/age/{age}")
	public ResponseEntity<List<AccountDto>> getAccountByAge(@PathVariable int age) throws Exception {
		List<AccountDto> accountdto=accountservice.getAccountByAge(age);
		return ResponseEntity.ok(accountdto);
	}
	
	@GetMapping
	public ResponseEntity<List<AccountDto>> GetAllAccounts() {
		List<AccountDto> acconuts = accountservice.getAll();

		return ResponseEntity.ok(acconuts);
	}
	
	@PutMapping("/deposit/{id}")
	public ResponseEntity<AccountDto> deposit(@PathVariable int id, @RequestBody Map<String, Double> request) {
		Double amount = request.get("amount");
		AccountDto accountDto = accountservice.deposit(id, amount);
		return ResponseEntity.ok(accountDto);
	}
	
	@PutMapping("/withdraw/{id}")
	public ResponseEntity<AccountDto> withdraw(@PathVariable int id, @RequestBody Map<String, Double> request) {
		Double amount = request.get("amount");
		AccountDto accountDto = accountservice.withdraw(id, amount);
		return (ResponseEntity<AccountDto>) ResponseEntity.ok(accountDto);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable int id) {
      accountservice.deleteAccount(id);
      return ResponseEntity.ok("Account deleted");
	}
}
