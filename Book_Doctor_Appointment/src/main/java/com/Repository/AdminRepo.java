package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.Admin;


public interface AdminRepo extends JpaRepository<Admin, Integer>{

}
