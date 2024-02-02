package com.tka.controller;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.User;
import com.tka.service.LoginService;

@CrossOrigin("http://localhost:4200/")
@RestController
public class LoginController<Answer> 
{
    static HttpSession httpsession;
	@Autowired
	LoginService service;
	 
	 @GetMapping("getUser/{username}")
	 public ResponseEntity<User> getUser( @PathVariable String username,HttpServletRequest request)
	 {
		  httpsession=request.getSession();
		  User obj=  service.getUser(username);
		  if(obj!=null)
		  {
			  httpsession.setAttribute("qno",0);
			  httpsession.setAttribute("score",0);
			  HashMap<Integer,Answer> hashmap=new HashMap<Integer, Answer>();
			  httpsession.setAttribute("submittedDetails",hashmap);
		  }
		  ResponseEntity<User> response=new ResponseEntity<User>(obj,HttpStatus.CREATED);
		  return  response ;
	 }


}
