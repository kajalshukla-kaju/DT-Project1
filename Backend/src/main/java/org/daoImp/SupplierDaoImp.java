package org.daoImp;

import java.util.List;

import org.Dao.SupplierDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class SupplierDaoImp implements SupplierDao{

	@Autowired
	SessionFactory sf;
	@Autowired
	 public SupplierDaoImp( SessionFactory sf) {
		super();
		System.out.println("Supplier bean create");
		this.sf=sf;
	}
	
	public boolean addSupplier(Supplier supplier) {
	
		try{Session s = sf.openSession();
	s.beginTransaction();
	s.saveOrUpdate(supplier);
	s.getTransaction().commit();
		return true;
		}catch(Exception e) {
			return false;
		}
	}

	public boolean deleteSupplier(Supplier supplier) {
		try {
			Session s=sf.openSession();
			s.beginTransaction();
			s.delete(supplier);
			s.getTransaction().commit();
			return true; 
		}catch (Exception e) {
			return false;
			
		}
		
	}

	public boolean updateSupplier(Supplier supplier) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			session.update(supplier);
			session.getTransaction().commit();
			return true;
		}catch (Exception e) {
			return false;
		
		} 
		
	}

	public Supplier findBySupplierId(int sid) {
	Session session = sf.openSession();
	Supplier supplier=null;
	try {
		session.beginTransaction();
		supplier= session.get(Supplier.class, sid);
		session.getTransaction().commit();
		
	}catch(HibernateException ex) {
		
		System.out.println(ex.getMessage());
		session.getTransaction().rollback();
	}
	
	return supplier;
	}

	public List<Supplier> retrieve() {
		Session s = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Supplier> list=s.createQuery("from Supplier").list();
				s.beginTransaction();
		s.getTransaction().commit();
		return list;
	}

}
