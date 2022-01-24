package com.Service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Advices.AdminException;
import com.Entity.Admin;
import com.Repository.AdminRepo;


@Service
public class AdminService {
	
	@Autowired
	AdminRepo repo;
	
	public Admin addAdmin(Admin admin) {
		repo.save(admin);
		return admin;
		
	}
	public Admin updateAdmin(Admin admin) throws Throwable {
		int id=admin.getAdminId();
		Supplier s1= ()->new AdminException("Admin Id Does not exist in the database");
		Admin c1=repo.findById(id).orElseThrow(s1);
		
		c1.setEmail(admin.getEmail());
			c1.setPassword(admin.getPassword());
			repo.save(c1);
			
		return admin;
	}
	
	public Admin removeAdmin(Admin admin) {
		repo.delete(admin);
		return admin;
	}
	

	public List<Admin> viewAdmin() {
		List<Admin> ls=repo.findAll();
		return ls;
		
	}

}
