package com.iago.springapp.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iago.springapp.service.LoginService;

@Controller
public class LoginController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String handleLogin(HttpServletResponse response, String nickname, String password, boolean rememberMe) {
		boolean logged = loginService.login(nickname, password);
		
		if(logged && rememberMe) {
			response.addCookie(new Cookie("USER", nickname));
			response.addCookie(new Cookie("PASSWORD", password));
		}
		
		logger.error("Login: " + logged);
		getLoginService().setLogged(logged);

		return "redirect:index.jsp";
	}
	
	@RequestMapping(value="/logout")
	public String handleLogout(HttpServletResponse response) {
		Cookie userCookie =  new Cookie("USER", null);
		userCookie.setMaxAge(0);
		response.addCookie(userCookie);
		
		Cookie passwordCookie =  new Cookie("PASSWORD", null);
		passwordCookie.setMaxAge(0);
		response.addCookie(passwordCookie);
		
		getLoginService().setLogged(false);
		
		return "redirect:index.jsp";
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public LoginService getLoginService() {
		return loginService;
	}
	
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

}