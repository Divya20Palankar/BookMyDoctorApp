package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Admin;
import com.Service.AdminService;


@RestController
@RequestMapping(path="/api")
@CrossOrigin
public class AdminController {
	@Autowired
	AdminService adminservice;
	
	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin a)
	{
		Admin a1=adminservice.addAdmin(a);
		ResponseEntity re=new ResponseEntity<Admin>(a1,HttpStatus.OK);
		return re;
	}
	@PutMapping(path="/updateAdmin")
	public ResponseEntity<Admin> updateAdmin(Admin admin) throws Throwable {
Admin e1=adminservice.updateAdmin(admin);
		
		ResponseEntity re=new ResponseEntity<Admin>(e1,HttpStatus.OK);
		return re;
		
		
	}
	public ResponseEntity<Admin> removeAdmin(Admin admin) {
adminservice.removeAdmin(admin);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	public ResponseEntity<List<Admin>> viewAdmin(){
		List<Admin> lc1=adminservice.viewAdmin();
		ResponseEntity re=new ResponseEntity<List<Admin>>(lc1,HttpStatus.OK);
		return re;
		
	}
	

}
