package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	UserEntity findByEmail(String email);

	}



