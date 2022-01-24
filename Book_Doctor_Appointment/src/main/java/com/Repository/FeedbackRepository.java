package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.Feedback;


@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {

	@Query("Select f from Feedback f where f.rating=?1")
	List<Feedback> findByRating(int rating);
	

}
