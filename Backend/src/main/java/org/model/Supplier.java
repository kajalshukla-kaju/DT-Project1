package org.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;
@Component
@Entity
public class Supplier implements Serializable {
	private static final long serialVersionUID =1L;
	@Id
	private int sid;
	private String suppliername;
	@OneToMany(targetEntity = Product.class, fetch = FetchType.EAGER, mappedBy = "supplier")
	private Set<Product>product= new HashSet<Product>(0);
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public Supplier(int sid, String suppliername) {
		super();
		this.sid = sid;
		this.suppliername = suppliername;
	}
	

}
