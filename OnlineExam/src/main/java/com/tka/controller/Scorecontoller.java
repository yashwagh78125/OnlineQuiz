package com.tka.controller;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Score;
@CrossOrigin("http://localhost:4200")
@RestController
public class Scorecontoller
{
	
     	@Autowired
     	SessionFactory  factory;
     	
    	@PostMapping("saveScore")
		public ResponseEntity<Boolean> getScore(@RequestBody Score score)		
    	{
    		Session session=factory.openSession();
			System.out.println(score);
	        session.save(score);
			session.beginTransaction().commit();
			ResponseEntity<Boolean>response=new ResponseEntity<Boolean>(true,HttpStatus.CREATED);
			return response;
    	}
	

}
