package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Accounts;

public interface AccountRepository extends JpaRepository<Accounts, Integer>{

	public Accounts findByName(String name);
	public Accounts findByAge(int age);
}
