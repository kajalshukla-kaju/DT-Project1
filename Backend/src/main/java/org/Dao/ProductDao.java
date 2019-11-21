package org.Dao;

import java.util.List;

import org.model.Product;

public interface ProductDao {
public   void addProduct(Product products);	
public boolean deleteProduct(int productid);
public Product searchbyid(int productid);
public void update(Product product);
List <Product> retrieve();
public List<Product> retrieve(String cid);
List<Product>getProductByCategoryId(int cid);
}
