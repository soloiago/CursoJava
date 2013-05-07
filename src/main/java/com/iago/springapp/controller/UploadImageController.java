package com.iago.springapp.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iago.springapp.domain.dao.ImageDao;
import com.iago.springapp.domain.dao.ItemDao;
import com.iago.springapp.domain.dao.ShopDao;
import com.iago.springapp.domain.pojo.Images;
import com.iago.springapp.domain.pojo.Items;
import com.iago.springapp.domain.pojo.Shops;
import com.iago.springapp.form.ItemUploadForm;
import com.iago.springapp.service.LoginService;

@Controller
@RequestMapping("/uploadImage")
public class UploadImageController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private ShopDao shopDao;
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private ImageDao imageDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView uploadImage() {
		ItemUploadForm itemUploadForm = new ItemUploadForm();
		List<Shops> shopList = (List<Shops>) shopDao.findDistinctShops();
		itemUploadForm.setShopList(shopList);
		return new ModelAndView("uploadImage", "uploadForm", itemUploadForm);
		
		/*
		 * if (getLoginService().isLogged()) {
			System.out.println("Logged");
		} else {
			System.out.println("Not logged");
		}
		 * 
		 */
	}
	
	@RequestMapping(method = RequestMethod.POST) 
	public ModelAndView submit(@ModelAttribute("uploadForm") ItemUploadForm uploadForm, BindingResult result) throws IOException {
		MultipartFile multipartFile = uploadForm.getImageFile();
		
		String orgName = multipartFile.getOriginalFilename();

		InputStream inputStream = multipartFile.getInputStream();
		String fileName = "/home/iago/workspaceWebApp/CursoJava2/web/images/" + multipartFile.getOriginalFilename().toLowerCase();
		
		OutputStream outputStream = new FileOutputStream(fileName);
		
		// write the file to disk
		int readBytes = 0;
		byte[] buffer = new byte[500000];
		while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1)
		{
			outputStream.write(buffer, 0, readBytes);
		}
		outputStream.close();
		inputStream.close();
        
		Items item = new Items();
		item.setFecha(new Date());
		item.setId((long)5001);
		item.setName(uploadForm.getName());
		item.setPrice(uploadForm.getPrecio());
		
		item.setUsers(loginService.getUser());
		
		Shops shop = new Shops();
		shop.setId((long)12);
		item.setShops(shop);
		
		Images image = new Images();
		image.setPath(multipartFile.getOriginalFilename().toLowerCase());
		image.setId(34);
		image.setItems(item);
		
		getItemDao().create(item);
		
		getImageDao().create(image);
		
		
		//item.setShops(shops);
		
		return null;
	}
	
	public LoginService getLoginService() {
		return loginService;
	}
	
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	public ShopDao getShopDao() {
		return shopDao;
	}
	
	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}
	
	public ItemDao getItemDao() {
		return itemDao;
	}
	
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	public ImageDao getImageDao() {
		return imageDao;
	}

	public void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}
}
