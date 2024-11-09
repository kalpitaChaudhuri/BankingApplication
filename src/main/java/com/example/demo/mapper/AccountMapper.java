package com.example.demo.mapper;

import com.example.demo.accdto.AccountDto;
import com.example.demo.entity.Accounts;

public class AccountMapper {

	public static Accounts maptoaccount(AccountDto accountdto) {
		Accounts account=new Accounts(accountdto.getId(), accountdto.getName(), accountdto.getAge(), accountdto.getBalance());
		return account;
	}
	
	public static AccountDto maptoaccountdto(Accounts accounts) {
		AccountDto accountdto=new AccountDto(accounts.getId(), accounts.getName(), accounts.getAge(), accounts.getBalance());
		return accountdto;
	}
}
