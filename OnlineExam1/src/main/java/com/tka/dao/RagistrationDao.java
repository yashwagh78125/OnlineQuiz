package com.tka.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tka.entity.User;
@Repository
public class RagistrationDao 
{
   
	@Autowired 
	SessionFactory factory;
	
	
	public void saveUser(User user)
	{
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction(); 
		session.save(user);
		tx.commit();
	}

}
