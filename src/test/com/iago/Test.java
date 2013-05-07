package com.iago;

import org.hibernate.Session;

import com.iago.springapp.domain.HibernateUtil;
import com.iago.springapp.domain.Stock;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Stock stock = new Stock();
		stock.setSTOCK_ID(12);
		stock.setSTOCK_CODE(2553);
		stock.setSTOCK_NAME("Ja");
		
		session.save(stock);
		session.getTransaction().commit();
		session.close();
	}

}
