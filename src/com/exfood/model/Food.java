package com.exfood.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Food entity. @author MyEclipse Persistence Tools
 */

public class Food implements java.io.Serializable {

	// Fields

	private Integer foodid;
	private String foodname;
	private Double unitprice;
	private Double vipprice;
	private Set comments = new HashSet(0);
	private Set comments_1 = new HashSet(0);
	private Set orders = new HashSet(0);
	private Set orders_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Food() {
	}

	/** full constructor */
	public Food(String foodname, Double unitprice, Double vipprice,
			Set comments, Set comments_1, Set orders, Set orders_1) {
		this.foodname = foodname;
		this.unitprice = unitprice;
		this.vipprice = vipprice;
		this.comments = comments;
		this.comments_1 = comments_1;
		this.orders = orders;
		this.orders_1 = orders_1;
	}

	// Property accessors

	public Integer getFoodid() {
		return this.foodid;
	}

	public void setFoodid(Integer foodid) {
		this.foodid = foodid;
	}

	public String getFoodname() {
		return this.foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public Double getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	public Double getVipprice() {
		return this.vipprice;
	}

	public void setVipprice(Double vipprice) {
		this.vipprice = vipprice;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

	public Set getComments_1() {
		return this.comments_1;
	}

	public void setComments_1(Set comments_1) {
		this.comments_1 = comments_1;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

	public Set getOrders_1() {
		return this.orders_1;
	}

	public void setOrders_1(Set orders_1) {
		this.orders_1 = orders_1;
	}

}