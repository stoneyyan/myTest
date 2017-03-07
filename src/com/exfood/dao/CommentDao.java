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
	@Resource SessionFactory factory;//factory��ȡ����Դ�����ݿ�
	 public void addComment(Comment comment) throws Exception {//����food�����е�����
	    	Session s = factory.getCurrentSession();
	    	s.save(comment);
	    }
	 public void deleteComment (int commentid) throws Exception {
	        Session s = factory.getCurrentSession(); 
	        Object comment = s.load(Comment.class, commentid);
	        s.delete(comment);
	    }
	 /*����Book��Ϣ*/
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
	   
	    public ArrayList<Comment> QueryCommentInfo(String customer) { //����customer���Ҷ�Ӧ�Ķ�������֪���Բ���
	    	Session s = factory.getCurrentSession();
	    	String hql = "From Comment comment where 1=1";                             //foodNumΪ�����Ĳ���
	    	if(!customer.equals("")) hql = hql + " and order.customer like '%" + customer + "%'";//��һ��foodΪ��һ�е�food����Food�Ĵ���
	    	Query q = s.createQuery(hql);
	    	List commentList = q.list();
	    	return (ArrayList<Comment>) commentList;
	    }
	    public ArrayList<Comment> QueryCommentInfo2(String food) { //����customer���Ҷ�Ӧ�Ķ�������֪���Բ���
	    	Session s = factory.getCurrentSession();
	    	String hql = "From Comment comment where 1=1";                             //foodNumΪ�����Ĳ���
	    	if(!food.equals("")) hql = hql + " and order.food like '%" + food + "%'";//��һ��foodΪ��һ�е�food����Food�Ĵ���
	    	Query q = s.createQuery(hql);
	    	List commentList = q.list();
	    	return (ArrayList<Comment>) commentList;
	    }
}






