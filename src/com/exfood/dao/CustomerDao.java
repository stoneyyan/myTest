package com.exfood.dao;

import java.util.ArrayList;
import java.util.List;
import com.exfood.model.Customer;
import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service @Transactional
public class CustomerDao {
	@Resource SessionFactory factory;//factory获取数据源打开数据库
	 public void addCustomer(Customer customer) throws Exception {//对象food中所有的内容
	    	Session s = factory.getCurrentSession();
	    	s.save(customer);
	    }
	 public void deleteCustomer (int customerid) throws Exception {
	        Session s = factory.getCurrentSession(); 
	        Object customer = s.load(Customer.class, customerid);
	        s.delete(customer);
	    }
	 /*更新Book信息*/
	    public void updateCustomer(Customer customer) throws Exception {
	        Session s = factory.getCurrentSession();
	        s.update(customer);
	    }
	    public Customer getCustomerBycustomerid(int customerid) {
	        Session s = factory.getCurrentSession();
	        Customer customer = (Customer)s.get(Customer.class, customerid);
	        return customer;
	    }
	   
	    public ArrayList<Customer> getAllCustomers() {
	        Session s = factory.getCurrentSession();
	        String hql = "From Customer";//=select*from food
	        Query q = s.createQuery(hql);
	        List customerList = q.list();
	        return (ArrayList<Customer>) customerList;
	    }
	  
	    public ArrayList<Customer> QueryCustomerInfo(String CustomerName) { 
	    	Session s = factory.getCurrentSession();
	    	String hql = "From Customer customer where 1=1";                             //foodNum为传进的参数
	    	if(!CustomerName.equals("")) hql = hql + " and customer.name like '%" + CustomerName + "%'";//第一个food为上一行的food，是Food的代称
	    	Query q = s.createQuery(hql);
	    	List customerList = q.list();
	    	return (ArrayList<Customer>) customerList;
	    }
}
