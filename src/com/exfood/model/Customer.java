package com.exfood.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */

public class Customer implements java.io.Serializable {

	// Fields

	private Integer customerid;
	private String name;
	private String address;
	private Integer phone;
	private Integer role;
	private String password;
	private Set orders = new HashSet(0);
	private Set comments = new HashSet(0);
	private Set orders_1 = new HashSet(0);
	private Set comments_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** minimal constructor */
	public Customer(String name, String address, Integer phone, String password) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.password = password;
	}

	/** full constructor */
	public Customer(String name, String address, Integer phone, Integer role,
			String password, Set orders, Set comments, Set orders_1,
			Set comments_1) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.role = role;
		this.password = password;
		this.orders = orders;
		this.comments = comments;
		this.orders_1 = orders_1;
		this.comments_1 = comments_1;
	}

	// Property accessors

	public Integer getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPhone() {
		return this.phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public Integer getRole() {
		return this.role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

	public Set getOrders_1() {
		return this.orders_1;
	}

	public void setOrders_1(Set orders_1) {
		this.orders_1 = orders_1;
	}

	public Set getComments_1() {
		return this.comments_1;
	}

	public void setComments_1(Set comments_1) {
		this.comments_1 = comments_1;
	}

}