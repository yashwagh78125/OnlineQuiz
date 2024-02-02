package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.QuestionDao;
import com.tka.entity.Questions;

@Service
public class QuestionService
{
	@Autowired
	QuestionDao dao;
	
	public List<Questions> getAllQuestions(String subject)
	{
			return dao.getAllQuestion(subject);
	}

}
