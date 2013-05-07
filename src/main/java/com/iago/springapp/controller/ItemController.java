package com.iago.springapp.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iago.springapp.domain.dao.CommentDao;
import com.iago.springapp.domain.dao.ItemDao;
import com.iago.springapp.domain.pojo.Comments;
import com.iago.springapp.domain.pojo.ItemXML;
import com.iago.springapp.domain.pojo.Items;
import com.iago.springapp.service.LoginService;

@Controller
public class ItemController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private LoginService loginService;

	@Autowired
	private ItemDao itemDao;

	@Autowired 
	private CommentDao commentDao;


	@RequestMapping(value="/item/{id}")
	public ModelAndView handleRequest(@PathVariable("id") Long id)
			throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();


		Items item = (Items) getItemDao().find(id);

		List<Comments> commentRootList = getCommentDao().findByItemIdRoot(id);

		List<Comments> orderCommentList = new ArrayList<Comments>();

		for(Comments currentComment: commentRootList) {
			currentComment.setReplyId(new BigDecimal(0));
			orderCommentList.add(currentComment);
			getComments(orderCommentList, currentComment.getId(), id, 1);
		}

		myModel.put("item", item);
		myModel.put("commentList", orderCommentList);
		
		if(getLoginService().isLogged()) {
			myModel.put("logged", true);
		} else {
			myModel.put("logged", false);
		}

		return new ModelAndView("item", "model", myModel);
	}

	private void getComments(List<Comments> orderCommentList, BigDecimal replyId, Long itemId, int level) {
		List<Comments> commentList = getCommentDao().findByItemIdReplies(itemId, replyId.longValue());

		for(Comments currentComment: commentList) {
			currentComment.setMarginReply(level);
			orderCommentList.add(currentComment);
			getComments(orderCommentList, currentComment.getId(), itemId, level + 1);
		}
	}

	@RequestMapping(value="/itemXML/{id}")
	public @ResponseBody ItemXML getItemXML(@PathVariable("id") Long id) {
		ItemXML itemXML = new ItemXML();

		try {
			Items item = (Items) getItemDao().find(id);

			itemXML.setItemName(item.getName());
			itemXML.setPathImage("estoyaqui.jpg");
			itemXML.setUserNick(item.getUsers().getNickname());

		} catch (Exception e) {
			logger.error(e);
		}

		return itemXML;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private ItemDao getItemDao() {
		return this.itemDao;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public CommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
}