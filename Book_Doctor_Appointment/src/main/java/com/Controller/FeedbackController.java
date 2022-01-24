package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Feedback;
import com.Service.FeedbackService;

@RestController
@RequestMapping(path="/feed")
@CrossOrigin
public class FeedbackController {

	@Autowired
	FeedbackService feedbackService;
	
	@PostMapping("/addFeedback")
	public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback p) {
      Feedback p1=feedbackService.addFeedback(p);
		ResponseEntity re=new ResponseEntity<Feedback>(p1,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateFeedback")
	public ResponseEntity<Feedback> updateFeedback(@RequestBody Feedback p) throws Throwable
	{
		Feedback p1=feedbackService.editFeedback(p);
		ResponseEntity re=new ResponseEntity<Feedback>(p1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteFeedback")
	public ResponseEntity<String> deleteFeedback(@RequestBody Feedback p)
	{
		feedbackService.removeFeedbackDetails(p);
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	

	
	@GetMapping(path="/getFeedbacks")
	public ResponseEntity<List<Feedback>> getFeedbacks()
	{
		List<Feedback> lc=feedbackService.getAllFeedback();
		ResponseEntity re=new ResponseEntity<List<Feedback>>(lc,HttpStatus.OK);
		return re;
	}
	@DeleteMapping(path="/deleteFeedback/{feedbackId}")
	public ResponseEntity<String> deleteFeedbackById(@PathVariable int feedbackId)
	{
		feedbackService.deleteFeedById(feedbackId);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getFeedback/{feedbackId}")
	public ResponseEntity<Feedback> getPatById(@PathVariable int feedbackId) throws Exception
	{
		Feedback e1=feedbackService.getFeedById(feedbackId);
		
		ResponseEntity re=new ResponseEntity<Feedback>(e1,HttpStatus.OK);
		return re;
	}
	
	/*
	 * @GetMapping(path="/getFeedback/{s1}") public ResponseEntity<List<Feedback>>
	 * getFeedback(@PathVariable String s1) { List<Feedback>
	 * lc=FeedbackService.getFeedback(s1); ResponseEntity re=new
	 * ResponseEntity<List<Feedback>>(lc,HttpStatus.OK); return re; }
	 */
	
}
