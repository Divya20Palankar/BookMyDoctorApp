package com.Service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Advices.CoderNotFoundException;
import com.Entity.Feedback;
import com.Repository.FeedbackRepository;
import com.Advices.ResourceNotFoundException;


@Service
public class FeedbackService {
	
	@Autowired
	FeedbackRepository  feedbackRepository ;
	
	public Feedback addFeedback(Feedback p)
	{
		feedbackRepository.save(p);
       return p;
	}
	
	public Feedback editFeedback(Feedback p) throws Throwable {
		int id=p.getFeedbackId();
		Supplier s1= ()->new CoderNotFoundException("Coder Id Does not exist in the database");
		Feedback p1=feedbackRepository.findById(id).orElseThrow(s1);
		
		p1.setFeedback_details(p.getFeedback_details());
		p1.setRating(p.getRating());
		
		feedbackRepository.save(p1);
		return p1;	
	}
	
      public String removeFeedbackDetails(Feedback p) {
		
    	  feedbackRepository.delete(p);
    	  return "Deleted";

	}

      public List<Feedback> getAllFeedback() {
		List<Feedback> ls=feedbackRepository.findAll();
		return ls;
	}
      
      public List<Feedback> getFeedBackbyRating(int rating) {
  		List<Feedback> f= feedbackRepository.findByRating(rating);
  		return f;
  	}
    public Feedback getFeedById(int feedbackId) throws Exception
	{
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("Employee id is not present in the database");
		//String tech="JAVA";
		Feedback e1=feedbackRepository.findById(feedbackId).orElseThrow(s1);
		//List<Employee> e2=erepo.findByTech(tech);
		//System.out.println(e2);
		return e1;
	}
    public String deleteFeedById(int feedbackId) {
		//Employee e=erepo.findById(eid).orElse(null);
    	feedbackRepository.deleteById(feedbackId);
		return "Deleted";
	}

}
