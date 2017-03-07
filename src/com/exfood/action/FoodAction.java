package com.exfood.action;

import java.util.List;
import javax.annotation.Resource;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.exfood.dao.FoodDao;
import com.exfood.model.Food;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class FoodAction extends ActionSupport{
	 @Resource FoodDao foodDao;
	 private Food food;
	 private List<Food> foodList;
	 private String keyWords;

	 
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	public List<Food> getFoodList() {
		return foodList;
	}
	public void setFoodlist(List<Food> foodList) {
		this.foodList = foodList;
	}
	public String addFood() throws Exception{
	       foodDao.addFood(food);
	       return "message";
	    }
	 public Food getFood() {
			return food;
		}
		public void setFood(Food food) {
			this.food = food;
		}
		 public String showFood() throws Exception{
			 foodList=foodDao.getAllFoods();
			 return "show_view";//通过action来实现跳转  所以在地址栏里面不用直接打jsp
		 }
		
		
		 
		 public String showDetails() throws Exception{
			 food=foodDao.getFoodByfoodid(food.getFoodid());//只通过foodid传，显示出来就是food的所有内容
			 return "detail_view";
		 }

		 public String showEdit() throws Exception{
			 food=foodDao.getFoodByfoodid(food.getFoodid());
			 return "edit_view";
		 }
		 public String editFood() throws Exception{
			foodDao.updateFood(food);
			 return "edit_message";
		 }
		 public String deleteFood() throws Exception{
			foodDao.deleteFood(food.getFoodid());
			 return "detail_message";
		 }
		 public String queryFoods() throws Exception{
			foodList=foodDao.QueryFoodInfo(keyWords);
				 return "show_view";
			 }
		 
		 
}
