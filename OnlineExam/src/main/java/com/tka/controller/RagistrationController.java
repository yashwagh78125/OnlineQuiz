package com.tka.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.User;
import com.tka.service.RagistrationService;
@CrossOrigin("http://localhost:4200/")
@RestController
public class RagistrationController
{
   
	 @Autowired
	 RagistrationService service;
	 
	 @PostMapping("/saveUser")
	 public ResponseEntity<Boolean> saveData( @RequestBody User user)
	 {
		 service.savaData(user);
		 ResponseEntity<Boolean> response=new ResponseEntity<Boolean>(true,HttpStatus.CREATED);
		return response;
	 }
		 

	 

}
