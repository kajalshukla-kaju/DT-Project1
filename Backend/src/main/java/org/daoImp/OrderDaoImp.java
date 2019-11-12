package org.daoImp;

import org.Dao.OrderDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImp implements OrderDao {

	@Autowired
	SessionFactory sf;
	
	@Autowired
	public OrderDaoImp(SessionFactory sf) {
		super();
		System.out.println("OrderBean is Create");
		this.sf=sf;
		
	}
	
	public void addorder(Order order) {
		try {
	Session s= sf.openSession();
	s.beginTransaction();
	s.persist(order);
	s.getTransaction().commit();
	
		
	}catch(HibernateException exc) {
		
	}
		
	}

}
