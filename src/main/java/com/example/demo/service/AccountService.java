package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.accdto.AccountDto;

@Service
public interface AccountService {

	AccountDto createAccount(AccountDto accountdto);
	
	AccountDto getAccountById(int id);
	
	AccountDto getAccountByName(String name) throws Exception;
	
	List<AccountDto> getAccountByAge(int age) throws Exception;
	
	AccountDto deposit(int id,double amount);
}
