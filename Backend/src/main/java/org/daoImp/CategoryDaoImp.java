package org.daoImp;

import java.util.List;

import org.Dao.CategoryDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImp implements CategoryDao{
	@Autowired
	SessionFactory sf;
	@Autowired
	public CategoryDaoImp (SessionFactory sf) {
		super();
		System.out.println("CategoryBean is created ");
		this.sf=sf;
		
	}
	public void addCategory(Category category) {
	try {
		Session s = sf.openSession();
	s.beginTransaction();
	s.saveOrUpdate(category);
	s.getTransaction().commit();
		
	}catch(HibernateException e)
	{
	}
	
	}

	
	public Category searchbyid(Category cid) {
		Session s = sf.openSession();
	Category category =null;
	try {
	
	s.beginTransaction();
	category = s.get(Category.class, cid);
	s.getTransaction().commit();
	
				
	}catch(HibernateException ex) {
	System.out.println(ex.getMessage());
	s.getTransaction().rollback();
		
	}
	return category;
	}

	public List<Category> retrieve() {
	Session s = sf.openSession();
	s.beginTransaction();
	List<Category> list= s.createQuery("from Category").list();
		s.getTransaction().commit();
		return list;
	}
	
	
	
	

}
