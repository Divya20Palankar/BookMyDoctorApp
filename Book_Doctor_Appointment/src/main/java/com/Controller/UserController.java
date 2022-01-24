package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.User;
import com.Service.UserService;

@RestController
@RequestMapping(path="/api")
@CrossOrigin
public class UserController {
	@Autowired
	UserService userservice;
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addCoder(@RequestBody User c)
	{
		User c1=userservice.addUser(c);
		ResponseEntity re=new ResponseEntity<User>(c1,HttpStatus.OK);
		return re;
	}
	@PutMapping(path="/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody User e) throws Throwable
	{
		User e1=userservice.updateUser(e);
		
		ResponseEntity re=new ResponseEntity<User>(e1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteUser/{eid}")
	public ResponseEntity<String> deleteCoderById(@PathVariable int eid)
	{
		userservice.deleteUser(eid);
		 
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
}
