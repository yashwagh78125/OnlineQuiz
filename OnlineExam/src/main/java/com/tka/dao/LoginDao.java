package com.tka.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.User;

@Repository
public class LoginDao 
{
   
	@Autowired 
	SessionFactory factory;
	
	public User getUser(String user)
	{
		Session session=factory.openSession();
		User obj=session.get(User.class,user);
		return obj;
	}
}