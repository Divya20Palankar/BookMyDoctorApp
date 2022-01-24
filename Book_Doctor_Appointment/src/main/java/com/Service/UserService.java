package com.Service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Advices.UserException;
import com.Entity.User;
import com.Repository.IUserRepo;

@Service
public class UserService {
	
	@Autowired
	IUserRepo repo;
	
	
	public List<User> addUser(List<User> ls) {
		repo.saveAll(ls);
		return ls;
	}
	
	public User addUser(User c)
	{
		repo.save(c);
		return c;	
	}
	
	
	public String deleteUser(int userId) {
		repo.deleteById(userId);
		
		return "Deleted";
	}
	
	
	public User updateUser(User bean) throws Throwable {
		int id=bean.getUserId();
		Supplier s1= ()->new UserException("User Id Does not exist in the database");
		User a1=repo.findById(id).orElseThrow();
		
		a1.setUsername(bean.getUsername());
			a1.setPassword(bean.getPassword());
			a1.setRole(a1.getRole());
			
			repo.save(a1);
			return a1;	
	}

}
