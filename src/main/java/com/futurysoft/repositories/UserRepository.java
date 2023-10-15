package com.futurysoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futurysoft.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}