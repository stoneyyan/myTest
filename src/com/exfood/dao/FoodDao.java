package com.exfood.dao;

import java.util.ArrayList;
import java.util.List;
import com.exfood.model.Food;
import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service @Transactional
public class FoodDao {
	@Resource SessionFactory factory;//factory获取数据源打开数据库
	 public void addFood(Food food) throws Exception {//对象food中所有的内容
	    	Session s = factory.getCurrentSession();
	    	s.save(food);
	    }
	 public void deleteFood (int foodid) throws Exception {
	        Session s = factory.getCurrentSession(); 
	        Object food = s.load(Food.class, foodid);
	        s.delete(food);
	    }
	 /*更新Book信息*/
	    public void updateFood(Food food) throws Exception {
	        Session s = factory.getCurrentSession();
	        s.update(food);
	    }
	    public Food getFoodByfoodid(int foodid) {
	        Session s = factory.getCurrentSession();
	        Food food = (Food)s.get(Food.class, foodid);
	        return food;
	    }
	   
	    public ArrayList<Food> getAllFoods() {
	        Session s = factory.getCurrentSession();
	        String hql = "From Food";//=select*from food
	        Query q = s.createQuery(hql);
	        List foodList = q.list();
	        return (ArrayList<Food>) foodList;
	    }
	  
	    public ArrayList<Food> QueryFoodInfo(String foodName) { 
	    	Session s = factory.getCurrentSession();
	    	String hql = "From Food food where 1=1";                             //foodNum为传进的参数
	    	if(!foodName.equals("")) hql = hql + " and food.foodname like '%" + foodName + "%'";//第一个food为上一行的food，是Food的代称
	    	Query q = s.createQuery(hql);
	    	List foodList = q.list();
	    	return (ArrayList<Food>) foodList;
	    }
}





