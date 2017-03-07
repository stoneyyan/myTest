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
	@Resource SessionFactory factory;//factory��ȡ����Դ�����ݿ�
	 public void addFood(Food food) throws Exception {//����food�����е�����
	    	Session s = factory.getCurrentSession();
	    	s.save(food);
	    }
	 public void deleteFood (int foodid) throws Exception {
	        Session s = factory.getCurrentSession(); 
	        Object food = s.load(Food.class, foodid);
	        s.delete(food);
	    }
	 /*����Book��Ϣ*/
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
	    	String hql = "From Food food where 1=1";                             //foodNumΪ�����Ĳ���
	    	if(!foodName.equals("")) hql = hql + " and food.foodname like '%" + foodName + "%'";//��һ��foodΪ��һ�е�food����Food�Ĵ���
	    	Query q = s.createQuery(hql);
	    	List foodList = q.list();
	    	return (ArrayList<Food>) foodList;
	    }
}





