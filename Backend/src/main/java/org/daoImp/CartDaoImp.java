package org.daoImp;

import java.util.List;

import org.Dao.CartDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CartDaoImp implements CartDao{
	
	@Autowired
	SessionFactory sf;
	
	@Autowired
	public CartDaoImp (SessionFactory sf) {
		super();
		System.out.println("CartBean is created");
		this.sf  =  sf;
		}
	public void  insertCart(Cart cart) {
		Session s =sf.openSession();
		s.beginTransaction();
		s.saveOrUpdate(cart);
		s.getTransaction().commit();
		
	}
	@SuppressWarnings("uncheckes")
	public List<Cart> findingbycartid(String userid) {
		Session s=sf.openSession();
		List<Cart> cr =null;
		try {
		
		s.beginTransaction();
		cr = (List <Cart>)s.createQuery("from Cart where emailid=:email ").setString("email", userid).list();
		s.getTransaction().commit();
				
	}
		catch(HibernateException e) {
		e.printStackTrace();
		s.getTransaction().rollback();
		}
return cr;
		}
	public void deleteCart(int cartID) {
		Session s = sf.openSession();
		s.beginTransaction();
		Cart cr = (Cart)s.get(Cart.class, cartID);
	    s.delete(cr);
	    s.getTransaction().commit();
	}
	public void update(Cart car) {
		Session s = sf.openSession();
		s.beginTransaction();
		s.update(car);
		s.getTransaction().commit();
		
	}
	public Cart getCartById(int cartProductId, String usermail) {
		Session s = sf.openSession();
		Cart cr = null;
		s.beginTransaction();
		cr = (Cart )s.createQuery("from Cart where emailid=:emailid and CartProductId=:cid ").setString("emailid", usermail).setInteger("id",cartProductId).uniqueResult();
		s.getTransaction().commit();
		return cr;
	}
	

}
	