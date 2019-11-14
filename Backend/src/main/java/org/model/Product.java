package org.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
@Entity

public class Product {
@Id
@GeneratedValue
private int productid;
private String productname;
private String description;
private String stock;
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "cid")
private Category category;
private float price;
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "sid")
private Supplier supplier;

@Transient
MultipartFile pimage;

private String imagename;

public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getStock() {
	return stock;
}
public void setStock(String stock) {
	this.stock = stock;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public Supplier getSupplier() {
	return supplier;
}
public void setSupplier(Supplier supplier) {
	this.supplier = supplier;
}
public MultipartFile getPimage() {
	return pimage;
}
public void setPimage(MultipartFile pimage) {
	this.pimage = pimage;
}
public String getImagename() {
	return imagename;
}
public void setImagename(String imagename) {
	this.imagename = imagename;
}

}
