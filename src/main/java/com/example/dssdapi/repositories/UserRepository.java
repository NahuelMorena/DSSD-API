package com.example.dssdapi.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.dssdapi.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByUsername(String username);

}
