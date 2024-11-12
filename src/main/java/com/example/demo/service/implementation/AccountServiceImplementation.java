package com.example.demo.service.implementation;

import javax.security.auth.login.AccountNotFoundException;

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
		Accounts account=accountrepository.findById(id).orElseThrow(() ->new  RuntimeException("id does not exist"));
		return AccountMapper.maptoaccountdto(account);
	}

	@Override
	public AccountDto getAccountByName(String name) throws Exception {
		Accounts account=accountrepository.findByName(name);
		if(account == null) {
			throw new AccountNotFoundException("Account with name " + name + " not found");
		}
		return AccountMapper.maptoaccountdto(account);
	}

}
