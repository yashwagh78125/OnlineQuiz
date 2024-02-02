package com.tka.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Answer;
import com.tka.entity.Questions;
import com.tka.service.QuestionService;


@RestController
@CrossOrigin("http://localhost:4200")
public class QuestionController 
{

	@Autowired
	QuestionService questionService;
	

	
	@RequestMapping("getFirstQuestion/{subject}")
	public ResponseEntity<Questions> getFirstQuestion(@PathVariable String subject,HttpServletRequest request)
	{

	    HttpSession httpsession=LoginController.httpsession;

		List<Questions> list=questionService.getAllQuestions(subject);
		
		Questions question=list.get(0);		
		
		ResponseEntity<Questions> responseEntity=new ResponseEntity<Questions>(question,HttpStatus.OK);
		
		System.out.println(question);
		
        httpsession.setAttribute("list",list);
        
        System.out.println(list);
		
        return responseEntity;
		
	}
	
	
	@RequestMapping("next")
	public ResponseEntity<Questions> next(@RequestBody Answer answer,HttpServletRequest request)
	{
				
		HttpSession httpsession=LoginController.httpsession;
	
		System.out.println(answer);
		
		System.out.println(httpsession.getId());
		
		List<Questions> list=(List<Questions>) httpsession.getAttribute("list");

		  // 0 1 2
		//   1 2 3
		// 3-2

		Questions question=null;
		
		System.out.println(httpsession.getAttribute("qno"));
		
		if((int)httpsession.getAttribute("qno")<=list.size()-2)
		{
			httpsession.setAttribute("qno", (int)httpsession.getAttribute("qno") + 1);
		
			question=list.get((int)httpsession.getAttribute("qno"));
		}
		else
		{
			question=list.get(list.size()-1);
			
		}
		
		// add/update user response in HashMap
		
		if(answer.getSubmittedAnswer()!=null)
		{
			HashMap<Integer,Answer> hashMap=(HashMap<Integer, Answer>) httpsession.getAttribute("submittedDetails");
			hashMap.put(answer.getQno(),answer);
			System.out.println(hashMap);
		}
		

		ResponseEntity<Questions> responseEntity=new ResponseEntity<Questions>(question,HttpStatus.OK);
		
		return responseEntity;
	
		
		// 0 1 2 3 4 5
		// 1 2 3 4 5 6
		// 6-2=4
	}

	
	@RequestMapping("previous")
	public ResponseEntity<Questions> previous(@RequestBody Answer answer,HttpServletRequest request)
	{
				
	    HttpSession httpsession=LoginController.httpsession;
	
		System.out.println(answer);
		
		System.out.println(httpsession.getId());
		
		// Object getAttribute(String name);
		
	   List<Questions> list= (List<Questions>) httpsession.getAttribute("list");

		  // 0 1 2  index
		//   1 2 3
		// 3-2

		Questions question=null;
		
		System.out.println(httpsession.getAttribute("qno"));
		
		if((int)httpsession.getAttribute("qno")>0)
		{
			httpsession.setAttribute("qno", (int)httpsession.getAttribute("qno") - 1);
		
			int index=(int)httpsession.getAttribute("qno");
			
			question=list.get(index);
		    System.out.println("hello");
		    System.out.println(question);
		}
		else
		{
			question=list.get(0);
			
		}
		
		// add/update user response in HashMap
		
		if(answer.getSubmittedAnswer()!=null)
		{
			HashMap<Integer,Answer> hashMap=(HashMap<Integer, Answer>) httpsession.getAttribute("submittedDetails");
			hashMap.put(answer.getQno(),answer);
			System.out.println(hashMap);
		}
		

		
		ResponseEntity<Questions> responseEntity=new ResponseEntity<Questions>(question,HttpStatus.OK);
		
		return responseEntity;
	
		
	}
	

	
	
	
	
	
	@RequestMapping("endexam")
	public ResponseEntity<Integer> endexam(Answer answer)
	{	
	

		HttpSession httpsession=LoginController.httpsession;
	
		
		if(answer.getSubmittedAnswer()!=null)
		{
					HashMap<Integer,Answer> hashMap=(HashMap<Integer, Answer>) httpsession.getAttribute("submittedDetails");
					hashMap.put(answer.getQno(), answer);
					System.out.println(hashMap);
		}
		
		HashMap<Integer,Answer> hashMap=(HashMap<Integer, Answer>) httpsession.getAttribute("submittedDetails");
		
		Collection<Answer> collection=hashMap.values();
		
		for (Answer ans : collection) 
		{
			if(ans.getSubmittedAnswer().equals(ans.getOriginalAnswer()))
			{
				httpsession.setAttribute("score", (int)httpsession.getAttribute("score") + 1);
				
			}
		}
		


		Integer score=(Integer)httpsession.getAttribute("score");
		
		ResponseEntity<Integer> responseEntity=new ResponseEntity<Integer>(score,HttpStatus.OK);

		return responseEntity;
		
	}
	
	
	
	@RequestMapping("allAnswers")
	public ResponseEntity<Collection<Answer>> getAllAnswers()
	{

		HttpSession httpsession=LoginController.httpsession;

		HashMap<Integer,Answer> hashMap=(HashMap<Integer, Answer>) httpsession.getAttribute("submittedDetails");
		
		Collection<Answer> collection=hashMap.values();
		
		ResponseEntity<Collection<Answer>> responseEntity=new ResponseEntity<>(collection,HttpStatus.OK);

		return responseEntity;
		
	}
	
	
	
	
	
	


}
