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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iago.springapp.domain.dao.ProfileDao;
import com.iago.springapp.domain.pojo.Profile;

@Controller
public class ProfileController {

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
	private ProfileDao profileDao;
	
	public void setProfileDao(ProfileDao ProfileDao) {
		this.profileDao = ProfileDao;
	}
	
	private ProfileDao getProfileDao() {
		return this.profileDao;
	}

	@RequestMapping(value="/profile/{id}.htm")
	public ModelAndView handleRequest(@PathVariable("id") Long id)
			throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();

		System.out.println("ID: " + id);
		
		Profile user = (Profile) getProfileDao().find(id);		

		myModel.put("profile", user);

		return new ModelAndView("profile", "model", myModel);
	}

}