package com.iago;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.junit.Test;

import com.iago.springapp.domain.HibernateUtil;
import com.iago.springapp.domain.Stock;

public class TestHibernate {

	@Test
	public void test() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Long totalReal = ((BigDecimal) session.createSQLQuery("select count(*) from Stock").uniqueResult()).longValue();
		
		Stock stock = new Stock();
		stock.setSTOCK_ID(99);
		stock.setSTOCK_CODE(2553);
		stock.setSTOCK_NAME("Ja");
		
		session.save(stock);
		session.getTransaction().commit();
		
		Long totalExpected = ((BigDecimal) session.createSQLQuery("select count(*) from Stock").uniqueResult()).longValue();
				
		assertEquals(totalExpected, ++totalReal);
		
		//session.close();
	}

}
