package org.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;
@Component
@Entity
public class Order implements Serializable {

@Id
@GeneratedValue
private int orderid;
@ManyToOne
@JoinColumn
private User user;
private String payment;
private double total;
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String getPayment() {
	return payment;
}
public void setPayment(String payment) {
	this.payment = payment;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}

}
