package com.iago.springapp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iago.springapp.domain.dao.UserDao;
import com.iago.springapp.domain.pojo.Users;
import com.iago.springapp.form.UserForm;

@Controller
public class UserController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
		}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	private UserDao getUserDao() {
		return this.userDao;
	}

	@RequestMapping(value="/user/{id}")
	public ModelAndView getUserInfo(@PathVariable("id") Integer id)
			throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();

		System.out.println("ID: " + id);
		
		Users user = (Users) getUserDao().find(new Long(id));		

		myModel.put("user", user);

		return new ModelAndView("user", "model", myModel);
	}
	
	@RequestMapping(value="/signUp", method=RequestMethod.GET)
	public String signUp(Model model) {
		model.addAttribute(new UserForm());
		
		return "signup";
	}
	
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	public String signUpConfirm(UserForm user, BindingResult result) {

		Map<String, Object> myModel = new HashMap<String, Object>();
		
		logger.error("Estoy en post: " + user.getNickname());

		return "redirect:index";
	}

}