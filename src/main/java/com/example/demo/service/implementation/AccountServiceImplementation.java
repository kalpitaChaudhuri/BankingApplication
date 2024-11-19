package com.example.demo.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public List<AccountDto> getAccountByAge(int age) throws Exception {
		List<Accounts> accounts = accountrepository.findByAge(age);
	    if (accounts == null || accounts.isEmpty()) {
	        throw new AccountNotFoundException("No accounts with age " + age + " found");
	    }
	    return AccountMapper.maptoaccountsdto(accounts);
	}
	
	@Override
	public List<AccountDto> getAll() {
		List<Accounts> accounts=accountrepository.findAll();
		return (List<AccountDto>) accounts.stream().map((account)->AccountMapper.maptoaccountdto(account)).collect(Collectors.toList());
	}

	@Override
	public AccountDto deposit(int id, double amount) {
		Accounts account=accountrepository.findById(id).orElseThrow(()->new RuntimeException("id does nt exixst"));
		double	balance=account.getBalance();
		balance=balance+amount;
		account.setBalance(balance);
		Accounts savedaccount=accountrepository.save(account);
		return AccountMapper.maptoaccountdto(savedaccount);
	}

	@Override
	public AccountDto withdraw(int id, double amount) {
		Accounts account=accountrepository.findById(id).orElseThrow(()->new RuntimeException("id does nt exixst"));
		if (account.getBalance()<amount) {
			throw new RuntimeException("infsuffient balance");
		}

		double total=account.getBalance()-amount;

		account.setBalance(total);
		Accounts savedacAccount=accountrepository.save(account);

		return AccountMapper.maptoaccountdto(savedacAccount);
	}

	@Override
	public void deleteAccount(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
