package com.exfood.dao;

import java.util.ArrayList;
import java.util.List;
import com.exfood.model.Comment;
import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service @Transactional
public class CommentDao {
	@Resource SessionFactory factory;//factory获取数据源打开数据库
	 public void addComment(Comment comment) throws Exception {//对象food中所有的内容
	    	Session s = factory.getCurrentSession();
	    	s.save(comment);
	    }
	 public void deleteComment (int commentid) throws Exception {
	        Session s = factory.getCurrentSession(); 
	        Object comment = s.load(Comment.class, commentid);
	        s.delete(comment);
	    }
	 /*更新Book信息*/
	    public void updateComment(Comment comment) throws Exception {
	        Session s = factory.getCurrentSession();
	        s.update(comment);
	    }
	    public Comment getCommentBycommentid(int commentid) {
	        Session s = factory.getCurrentSession();
	        Comment comment = (Comment)s.get(Comment.class, commentid);
	        return comment;
	    }
	   
	    public ArrayList<Comment> getAllComments() {
	        Session s = factory.getCurrentSession();
	        String hql = "From Comment";//=select*from food
	        Query q = s.createQuery(hql);
	        List commentList = q.list();
	        return (ArrayList<Comment>) commentList;
	    }
	   
	    public ArrayList<Comment> QueryCommentInfo(String customer) { //利用customer来找对应的订单，不知道对不对
	    	Session s = factory.getCurrentSession();
	    	String hql = "From Comment comment where 1=1";                             //foodNum为传进的参数
	    	if(!customer.equals("")) hql = hql + " and order.customer like '%" + customer + "%'";//第一个food为上一行的food，是Food的代称
	    	Query q = s.createQuery(hql);
	    	List commentList = q.list();
	    	return (ArrayList<Comment>) commentList;
	    }
	    public ArrayList<Comment> QueryCommentInfo2(String food) { //利用customer来找对应的订单，不知道对不对
	    	Session s = factory.getCurrentSession();
	    	String hql = "From Comment comment where 1=1";                             //foodNum为传进的参数
	    	if(!food.equals("")) hql = hql + " and order.food like '%" + food + "%'";//第一个food为上一行的food，是Food的代称
	    	Query q = s.createQuery(hql);
	    	List commentList = q.list();
	    	return (ArrayList<Comment>) commentList;
	    }
}






