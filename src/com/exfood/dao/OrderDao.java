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
	@Resource SessionFactory factory;//factory获取数据源打开数据库
	 public void addOrder(Order order) throws Exception {//对象food中所有的内容
	    	Session s = factory.getCurrentSession();
	    	s.save(order);
	    }
	 public void deleteOrder (int orderid) throws Exception {
	        Session s = factory.getCurrentSession(); 
	        Object order = s.load(Order.class, orderid);
	        s.delete(order);
	    }
	 /*更新Book信息*/
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
	   
	    public ArrayList<Order> QueryOrderInfo(String customer) { //利用customer来找对应的订单，不知道对不对
	    	Session s = factory.getCurrentSession();
	    	String hql = "From Order order where 1=1";                             //foodNum为传进的参数
	    	if(!customer.equals("")) hql = hql + " and order.customer like '%" + customer + "%'";//第一个food为上一行的food，是Food的代称
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





