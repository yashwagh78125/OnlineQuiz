package com.tka.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tka.entity.Questions;

@Repository
public class QuestionDao
{
	@Autowired
	SessionFactory factory;
	@RequestMapping("getFirstQuestion/{subject}")
    public List<Questions> getAllQuestion(String subject)
    {
		Session session=factory.openSession();
		Criteria criteria=session.createCriteria(Questions.class);
		criteria.add(Restrictions.eq("subject",subject));
		return criteria.list();
    }

}
