package com.iago.springapp.domain.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
public class ItemXML {
	private String userNick;
	private String itemName;
	private String pathImage;
	
	public String getUserNick() {
		return userNick;
	}
	
	@XmlElement
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	@XmlElement
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getPathImage() {
		return pathImage;
	}
	
	@XmlElement
	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}
	
	
}
