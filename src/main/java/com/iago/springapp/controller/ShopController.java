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

import com.iago.springapp.domain.dao.ShopDao;
import com.iago.springapp.domain.pojo.Shops;

@Controller
public class ShopController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ShopDao shopDao;


	@RequestMapping(value="/shop/{id}")
	public ModelAndView handleRequest(@PathVariable("id") Long id)
			throws ServletException, IOException {

		Map<String, Object> myModel = new HashMap<String, Object>();

			Shops shop = (Shops) getShopDao().find(id);

			myModel.put("shop", shop);
			myModel.put("logged", true);

		return new ModelAndView("shop", "model", myModel);
	}


	/*@RequestMapping(value="/shopXML/{id}")
	public @ResponseBody ShopXML getShopXML(@PathVariable("id") Long id) {
		ShopXML ShopXML = new ShopXML();

		try {
			Shops shop= (Shops) getShopDao().find(id);

			ShopXML.setShopName(Shop.getName());
			ShopXML.setPathImage("estoyaqui.jpg");
			ShopXML.setUserNick(Shop.getUsers().getNick());

		} catch (Exception e) {
			logger.error(e);
		}

		return ShopXML;
	}*/

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private ShopDao getShopDao() {
		return this.shopDao;
	}

	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}

}