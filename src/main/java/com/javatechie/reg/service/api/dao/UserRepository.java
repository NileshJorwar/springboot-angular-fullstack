package com.javatechie.reg.service.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.reg.service.api.model.UserObject;

import java.util.List;

public interface UserRepository extends JpaRepository<UserObject, Integer> {
    List<UserObject> findByEmail(String email);
    List<UserObject> findByNameAndPassword(String name, String password);
}
