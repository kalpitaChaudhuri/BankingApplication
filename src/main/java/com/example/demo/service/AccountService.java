package com.example.demo.service;

import java.util.List;

import com.example.demo.accdto.AccountDto;

public interface AccountService {

	AccountDto createAccount(AccountDto accountdto);
	
	AccountDto getAccountById(int id);
	
	AccountDto getAccountByName(String name) throws Exception;
	
	List<AccountDto> getAccountByAge(int age) throws Exception;
	
	List<AccountDto> getAll();
	
	AccountDto deposit(int id, double amount);
	
	AccountDto withdraw(int id ,double amount);
	
	void deleteAccount(int id);
}
