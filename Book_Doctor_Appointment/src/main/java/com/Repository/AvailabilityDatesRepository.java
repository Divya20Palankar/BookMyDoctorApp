package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.AvailabilityDates;
import com.Entity.Doctor;

@Repository
public interface AvailabilityDatesRepository extends JpaRepository<AvailabilityDates, Integer>{

}
