package com.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Entity.Admin;
import com.Repository.AdminRepo;



@SpringBootTest
class AdminServiceTest {
	
	@MockBean
	AdminRepo repo;
	
	@Autowired
	AdminService adminService;
	
	@Test
	void testAddAdmin() {
		Admin a1=new Admin();
		a1.setAdminId(1);
		a1.setEmail("dhanya@gmail.com");
		a1.setPassword("Dhanya@900");
		Mockito.when(repo.save(a1)).thenReturn(a1);		
		assertThat(adminService.addAdmin(a1)).isEqualTo(a1);
	}

	@Test
	void testUpdateAdmin() throws Throwable {
		Admin a1=new Admin();
		a1.setAdminId(1);
		a1.setEmail("dhanya@gmail.com");
		a1.setPassword("Dhanya@900");
		
        Optional<Admin> a2=Optional.of(a1);
		
	    Mockito.when(repo.findById(1)).thenReturn(a2);		
	    Mockito.when(repo.save(a1)).thenReturn(a1);
	   
		a1.setEmail("dhanya@yahoo.com");
		a1.setPassword("Dhanya@90");
	    
		assertThat(adminService.updateAdmin(a1)).isEqualTo(a1);
	    
	    
	}

	@Test
	void testRemoveAdmin() {
		Admin a1=new Admin();
		a1.setAdminId(1);
		a1.setEmail("dhanya@gmail.com");
		a1.setPassword("Dhanya@900");
		
		 Optional<Admin> a2=Optional.of(a1);
			
			Mockito.when(repo.findById(1)).thenReturn(a2);
			 Mockito.when(repo.existsById(a1.getAdminId())).thenReturn(false);
			   assertFalse(repo.existsById(a1.getAdminId()));
	}

	@Test
	void testViewAdmin() {
		Admin a1=new Admin();
		a1.setAdminId(1);
		a1.setEmail("dhanya@gmail.com");
		a1.setPassword("Dhanya@900");
		
		Admin a2=new Admin();
		a2.setAdminId(2);
		a2.setEmail("dh@gmail.com");
		a2.setPassword("Dhanya@9");
		
		List<Admin> adminList = new ArrayList<>();
		adminList.add(a1);
		adminList.add(a2);
		
		Mockito.when(repo.findAll()).thenReturn(adminList);
		
		assertThat(adminService.viewAdmin()).isEqualTo(adminList);
	}

}
