package com.iago.springapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iago.springapp.domain.dao.ItemDao;
import com.iago.springapp.domain.pojo.Items;
import com.iago.springapp.service.LoginService;

@Controller
public class MainController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private LoginService loginService;

	@Autowired
	private ItemDao itemDao;

	@RequestMapping(value="/lista")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> myModel = new HashMap<String, Object>();

		try {
			String user = "";
			String password = "";
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getValue());
				if (cookie.getName().equals("USER")) {
					user = cookie.getValue();
				} else if (cookie.getName().equals("PASSWORD")) {
					password = cookie.getValue();
				}
			}	

			if(!user.isEmpty() && !password.isEmpty()) {
				loginService.login(user, password);
			}

		} catch (Exception e) {
			myModel.put("logged", false);
			logger.error(e);
		}

		if(getLoginService().isLogged()) {
			myModel.put("logged", true);
		} else {
			myModel.put("logged", false);
		}

		List<Items> itemList = new ArrayList<Items>();

		itemList = (List<Items>) getItemDao().findAll();
		myModel.put("itemList", itemList);
		myModel.put("total", itemList.size());
		return new ModelAndView("lista", "model", myModel);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public ItemDao getItemDao() {
		return this.itemDao;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

}