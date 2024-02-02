package com.tka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tka.dao.RagistrationDao;
import com.tka.entity.User;

@Service
public class RagistrationService 
{
	@Autowired
	RagistrationDao dao;
	public void savaData(User user)
	{
		dao.saveUser(user);
	}
}
