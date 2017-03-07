package com.exfood.dao;

import java.util.ArrayList;

import java.util.List;
import com.exfood.model.Order;
import com.exfood.model.Customer;
import com.exfood.model.Food;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service @Transactional
public class OrderDao {
	@Resource SessionFactory factory;//factory��ȡ����Դ�����ݿ�
	 public void addOrder(Order order) throws Exception {//����food�����е�����
	    	Session s = factory.getCurrentSession();
	    	s.save(order);
	    }
	 public void deleteOrder (int orderid) throws Exception {
	        Session s = factory.getCurrentSession(); 
	        Object order = s.load(Order.class, orderid);
	        s.delete(order);
	    }
	 /*����Book��Ϣ*/
	    public void updateOrder(Order order) throws Exception {
	        Session s = factory.getCurrentSession();
	        s.update(order);
	    }
	    public Order getOrderByorderid(int orderid) {
	        Session s = factory.getCurrentSession();
	        Order order = (Order)s.get(Order.class, orderid);
	        return order;
	    }
	   
	    public ArrayList<Order> getAllOrders() {
	        Session s = factory.getCurrentSession();
	        String hql = "From Order";//=select*from food
	        Query q = s.createQuery(hql);
	        List orderList = q.list();
	        return (ArrayList<Order>) orderList;
	    }
	   
	    public ArrayList<Order> QueryOrderInfo(String customer) { //����customer���Ҷ�Ӧ�Ķ�������֪���Բ���
	    	Session s = factory.getCurrentSession();
	    	String hql = "From Order order where 1=1";                             //foodNumΪ�����Ĳ���
	    	if(!customer.equals("")) hql = hql + " and order.customer like '%" + customer + "%'";//��һ��foodΪ��һ�е�food����Food�Ĵ���
	    	Query q = s.createQuery(hql);
	    	List orderList = q.list();
	    	return (ArrayList<Order>) orderList;
	    }
	    public ArrayList<Order> QueryOrderInfo(Customer customer, Food food) {
	    	Session s = factory.getCurrentSession();
	    	String hql = "From Order order where 1=1";
	    	if(null != customer && customer.getCustomerid()!=0) 
	    		hql = hql + " and order.customer.customerid = '" + customer.getCustomerid() + "'";
	    	if(null != food && null!=food.getFoodname()) 
	    		hql = hql + " and order.food.foodname like '%" + food.getFoodname() + "%'";
	    	Query q = s.createQuery(hql);
	    	List orderList = q.list();
	    	return (ArrayList<Order>) orderList;
	    }
}





