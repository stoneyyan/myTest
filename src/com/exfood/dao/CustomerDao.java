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
	@Resource SessionFactory factory;//factory��ȡ����Դ�����ݿ�
	 public void addCustomer(Customer customer) throws Exception {//����food�����е�����
	    	Session s = factory.getCurrentSession();
	    	s.save(customer);
	    }
	 public void deleteCustomer (int customerid) throws Exception {
	        Session s = factory.getCurrentSession(); 
	        Object customer = s.load(Customer.class, customerid);
	        s.delete(customer);
	    }
	 /*����Book��Ϣ*/
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
	    	String hql = "From Customer customer where 1=1";                             //foodNumΪ�����Ĳ���
	    	if(!CustomerName.equals("")) hql = hql + " and customer.name like '%" + CustomerName + "%'";//��һ��foodΪ��һ�е�food����Food�Ĵ���
	    	Query q = s.createQuery(hql);
	    	List customerList = q.list();
	    	return (ArrayList<Customer>) customerList;
	    }
}
