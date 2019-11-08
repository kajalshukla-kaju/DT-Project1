package org.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;
@Component
@Entity

public class Category {
	@Id
private int cid;
private String Categoryname;
@OneToOne(targetEntity = Product.class, fetch = FetchType.EAGER, mappedBy = "category")
private Set<Product> product = new HashSet<Product>(0);
private Set<Product> getProduct(){
	return product;
}

public void setProduct(Set<Product> product) {
	this.product = product;
}

public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCategoryname() {
	return Categoryname;
}
public void setCategoryname(String categoryname) {
	Categoryname = categoryname;
}

}
