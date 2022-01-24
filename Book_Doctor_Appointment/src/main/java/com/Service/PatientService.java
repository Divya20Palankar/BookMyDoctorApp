package com.Service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Advices.CoderNotFoundException;
import com.Entity.Patient;
import com.Repository.PatientRepository;
import com.Advices.ResourceNotFoundException;


@Service
public class PatientService {
	
	@Autowired
	PatientRepository  patientRepository ;
	
	public Patient addPatient(Patient p)
	{
		patientRepository.save(p);
       return p;
	}
	
	public Patient editPatient(Patient p) throws Throwable {
		int id=p.getUserId();
		Supplier s1= ()->new CoderNotFoundException("Coder Id Does not exist in the database");
		Patient p1=patientRepository.findById(id).orElseThrow(s1);
		
		p1.setPatientName(p.getPatientName());
		p1.setMobileNo(p.getMobileNo());
		p1.setEmail(p.getEmail());
		p1.setPassword(p.getPassword());
		p1.setBloodGroup(p.getBloodGroup());
		p1.setAge(p.getAge());
		p1.setAddress(p.getAddress());
		
		patientRepository.save(p1);
		return p1;	
	}
	
      public String removePatientDetails(Patient p) {
		
    	  patientRepository.delete(p);
    	  return "Deleted";

	}

      public List<Patient> getAllPatient() {
		List<Patient> ls=patientRepository.findAll();
		return ls;
	}
    public List<Patient> getPatient(String s1)
	{
		List<Patient> lc=patientRepository.getPatient(s1);
		return lc;
	}
    public Patient getPatById(int userId) throws Exception
	{
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("Employee id is not present in the database");
		//String tech="JAVA";
		Patient e1=patientRepository.findById(userId).orElseThrow(s1);
		//List<Employee> e2=erepo.findByTech(tech);
		//System.out.println(e2);
		return e1;
	}
    public String deletePatById(int userId) {
		//Employee e=erepo.findById(eid).orElse(null);
    	patientRepository.deleteById(userId);
		return "Deleted";
	}

}
