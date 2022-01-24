package com.Service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Advices.DoctorNotFoundException;
import com.Advices.ResourceNotFoundException;
import com.Entity.Doctor;
import com.Entity.Patient;
import com.Repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	DoctorRepository doctorRepo;

	public Doctor addDoctor(Doctor d) {
		doctorRepo.save(d);
		return d;
	}

	public List<Doctor> getDoctorList() {
		List<Doctor> d=doctorRepo.findAll();
		return d;

	}

	public List<Doctor> getDoctorListbySpeciality(String speciality) throws Throwable  {
		Supplier s1= ()->new DoctorNotFoundException("Doctor Does not exist in the database");
		List<Doctor> d= doctorRepo.findBySpeciality(speciality);
		return d;
	}

	public Doctor updateDoctorProfile(Doctor d) throws Throwable {
		int id=d.getUserId();
		Supplier s1= ()->new DoctorNotFoundException("Doctor Does not exist in the database");
		Doctor doc=doctorRepo.findById(id).orElseThrow(s1);

		doc.setDoctorName(d.getDoctorName());
		doc.setEmail(d.getEmail());
		doc.setHospitalName(d.getHospitalName());
		doc.setLocation(d.getLocation());
		doc.setMobileNo(d.getMobileNo());
		doc.setPassword(d.getPassword());
		doc.setSpeciality(d.getSpeciality());
		doc.setChargedPerVisit(d.getChargedPerVisit());
		doctorRepo.save(doc);
		return doc;	
	}

	public String removeDoctorById(int doctorId) {
		doctorRepo.deleteById(doctorId);
		return "Doctor deleted succesfully.....";
	}

	public Doctor getDoctorById(int userId) throws Exception{
		Supplier<Exception> s1 = ()->new DoctorNotFoundException("Doctor id is not present in the database");
		//String tech="JAVA";
		Doctor e1=doctorRepo.findById(userId).orElseThrow(s1);
		return e1;
	}

}
