package com.cjc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	 @Id
	 private int cid;
	 private String cname;

	 @OneToMany(cascade = CascadeType.ALL)
	 private List<Product> products;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<Product> getProduct() {
		return products;
	}

	public void setProducts(List<Product> product) {
		this.products = product;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", product=" + products + "]";
	}

	public Customer(int cid, String cname, List<Product> product) {
		this.cid = cid;
		this.cname = cname;
		this.products = product;
	}

	public Customer() {
	}
	 
	 
}
