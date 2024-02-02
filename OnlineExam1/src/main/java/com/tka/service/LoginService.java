package com.tka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.LoginDao;
import com.tka.entity.User;

@Service
public class LoginService 
{
	@Autowired
	LoginDao dao;


	public User getUser(String user)
	{
		User obj =dao.getUser(user);
		return obj;
	}

}
