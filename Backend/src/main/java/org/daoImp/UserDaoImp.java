package org.daoImp;

import org.Dao.UserDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao {
	@Autowired
	SessionFactory sf;
	
	@Autowired
	public UserDaoImp(SessionFactory factory) {
		System.out.println("User Bean is Created");
		this.sf=factory;
	}

	public void insertUser(User user) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		
	}

	public User findingbyemail(String emailid) {
		Session session=sf.openSession();
		User user=null;
		try {
			session.beginTransaction();
			user = session.get(User.class, emailid);
			session.getTransaction().commit();
			
			
		}catch(HibernateException ex) {
			System.out.println(ex.getMessage());
			session.getTransaction().rollback();
			
		}
		return user;
	}

}
