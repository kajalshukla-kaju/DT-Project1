package org.daoImp;

import java.util.List;

import org.Dao.ProductDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ProductDaoImp implements ProductDao{

	@Autowired
	SessionFactory sf;
	@Autowired
	public ProductDaoImp(SessionFactory sf) {
		super();
		System.out.println("Product Bean is create");
		this.sf = sf;
		
		
	}
	public void addProduct(Product products) {
		try {
			Session s = sf.openSession();
			s.beginTransaction();
			s.saveOrUpdate(products);
			s.getTransaction().commit();
			
		}catch(HibernateException error) {}
		
	}

	public boolean deleteProduct(int productid) {
	
			Session s = sf.openSession();
			
			s.beginTransaction();
			Product products = (Product)s.get(Product.class, productid);
			try {
				s.delete(products);
				s.getTransaction().commit();
		return true;
			}catch (HibernateException e) {
				return false;
			}
	}

	public Product searchbyid(int productid) {
		Session s = sf.openSession();
		Product products = null;
		try {
		s.beginTransaction();
		s.getTransaction().commit();
		products = s.get(Product.class, productid);
		}catch(HibernateException e) {
			e.printStackTrace();
			s.getTransaction().rollback();
			
		}return products;
	}

	public void update(Product product) {
		Session s= sf.openSession();
		s.beginTransaction();
		s.update(product);
		s.getTransaction().commit();
		
	}

	public List<Product> retrieve() {
		Session s = sf.openSession();
		s.beginTransaction();
		@SuppressWarnings("unchecked")
		List <Product> list =s.createQuery("from Product").list() ;
		s.getTransaction().commit();
		return list;
	}

	public List<Product> retrieve(String cid) {
		Session s = sf.openSession();
		s.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Product> list = s.createQuery("from Product where cid ='"+cid+"'").list();
s.getTransaction().commit();
		return list;	}

	@SuppressWarnings("unchecked")
	public List<Product> getProductByCategoryId(int cid) {
		Session s= sf.openSession();
		s.beginTransaction();
		List< Product > products =null;
		try {
			
			products = s.createQuery("from Product where cid =' "+cid+ "'").list();
			s.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			s.getTransaction().rollback();
			
		}
		return products;
		
	}

}
