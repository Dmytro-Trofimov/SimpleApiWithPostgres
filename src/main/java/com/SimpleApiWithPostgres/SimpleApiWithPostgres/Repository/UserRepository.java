package com.SimpleApiWithPostgres.SimpleApiWithPostgres.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SimpleApiWithPostgres.SimpleApiWithPostgres.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
