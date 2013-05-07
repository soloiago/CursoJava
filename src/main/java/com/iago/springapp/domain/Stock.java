package com.iago.springapp.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "STOCK")
public class Stock {

	@Id
	private int STOCK_ID;
	private int STOCK_CODE;
	private String STOCK_NAME;
	
	public int getSTOCK_ID() {
		return STOCK_ID;
	}
	public void setSTOCK_ID(int sTOCK_ID) {
		STOCK_ID = sTOCK_ID;
	}
	public int getSTOCK_CODE() {
		return STOCK_CODE;
	}
	public void setSTOCK_CODE(int sTOCK_CODE) {
		STOCK_CODE = sTOCK_CODE;
	}
	public String getSTOCK_NAME() {
		return STOCK_NAME;
	}
	public void setSTOCK_NAME(String sTOCK_NAME) {
		STOCK_NAME = sTOCK_NAME;
	}
	

}
