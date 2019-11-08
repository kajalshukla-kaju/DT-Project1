package org.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity	
@Table(name="Customer")

public class User implements Serializable {
	private static final long serialVersionUID=1L;
@Id @GeneratedValue
@Column(name="CustomerID")
private int cusid;
@Column(name="CustomerName")
private String cusname;
@Column(name="CustomerMobile")
private String mobile;
@Column(name="CustomerAddress" )
private String address;
@Column
private String emailid;
public int getCusid() {
	return cusid;
}
public void setCusid(int cusid) {
	this.cusid = cusid;
}
public String getCusname() {
	return cusname;
}
public void setCusname(String cusname) {
	this.cusname = cusname;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
	
}
