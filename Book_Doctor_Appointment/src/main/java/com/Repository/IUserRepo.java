package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.User;

public interface IUserRepo extends JpaRepository<User, Integer>{

}
