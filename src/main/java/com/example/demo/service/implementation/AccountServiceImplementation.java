package com.example.demo.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.accdto.AccountDto;
import com.example.demo.entity.Accounts;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;

@Component
public class AccountServiceImplementation implements AccountService{

	@Autowired
	AccountRepository accountrepository;
	
	@Override
	public AccountDto createAccount(AccountDto accountdto) {
		Accounts accounts=AccountMapper.maptoaccount(accountdto);
		Accounts accountsaved=accountrepository.save(accounts);
		return AccountMapper.maptoaccountdto(accountsaved);
	}

	@Override
	public AccountDto getAccountById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
