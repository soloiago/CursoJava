package com.iago.springapp.form;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.iago.springapp.domain.pojo.Shops;

public class ItemUploadForm {
	private String name;
	private List<Shops> shopList;
	private MultipartFile imageFile;
	private double precio;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Shops> getShopList() {
		return shopList;
	}
	
	public void setShopList(List<Shops> shopList) {
		this.shopList = shopList;
	}
	
	public MultipartFile getImageFile() {
		return imageFile;
	}
	
	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
}
