package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.accdto.AccountDto;

@Service
public interface AccountService {

	AccountDto createAccount(AccountDto accountdto);
	
	AccountDto getAccountById(int id);
	
	AccountDto getAccountByName(String name) throws Exception;
}
