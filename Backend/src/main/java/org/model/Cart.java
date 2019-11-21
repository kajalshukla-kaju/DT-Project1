package org.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="Cart")

public class Cart implements Serializable {
	private static final long serialVersionUID =1L;
	@Id @GeneratedValue
	@Column(name="CartId")
	private int cartid;
	private int CartProductId;
	@OneToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "userMailID")
	@Column(name="cartdetail")
	private User cartuserDetail;
	//cartPrice ; cartStock ; cartImage ; cartProductName
	@Column
	private double cartprice;
	@Column
	private String cartstock;
	
	private String cartproductname;
	private String cartimage;
	public Cart()
	{}
	public Cart(int cartid,int CartProductId, User cartuserDetail, double cartprice, String cartstock, String cartproductname,
			String cartimage) {
		super();
		this.cartid = cartid;
		this.CartProductId = CartProductId;
		this.cartuserDetail = cartuserDetail;
		this.cartprice = cartprice;
		this.cartstock = cartstock;
		this.cartproductname = cartproductname;
		this.cartimage = cartimage;
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	
	public int getCartProductId() {
		return CartProductId;
	}
	public void setCartProductId(int cartProductId) {
		CartProductId = cartProductId;
	}
	public User getCartuserDetail() {
		return cartuserDetail;
	}
	public void setCartuserDetail(User cartuserDetail) {
		this.cartuserDetail = cartuserDetail;
	}
	public double getCartprice() {
		return cartprice;
	}
	public void setCartprice(double cartprice) {
		this.cartprice = cartprice;
	}
	public String getCartstock() {
		return cartstock;
	}
	public void setCartstock(String qty) {
		this.cartstock = qty;
	}
	public String getCartproductname() {
		return cartproductname;
	}
	public void setCartproductname(String cartproductname) {
		this.cartproductname = cartproductname;
	}
	public String getCartimage() {
		return cartimage;
	}
	public void setCartimage(String cartimage) {
		this.cartimage = cartimage;
	}
	
	

}
