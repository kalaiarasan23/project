package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entityClasses.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{
	Optional<Users> findByUserName(String name);
}
