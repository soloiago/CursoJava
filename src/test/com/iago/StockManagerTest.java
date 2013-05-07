package com.iago;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.iago.springapp.domain.Stock;
import com.iago.springapp.service.StockManagerImp;

public class StockManagerTest {
	
	private StockManagerImp stockManager;
	
	private static int STOCK_COUNT = 2;

	private static int CHAIR_ID = 1;
	private static String CHAIR_NAME = "Chair";
	private static int CHAIR_CODE = 23;
	
	private static int TABLE_ID = 2;
	private static String TABLE_NAME = "Table";
	private static int TABLE_CODE = 33;
	
    private static int POSITIVE_CODE_INCREASE = 10; 
	
	@Before
	public void setUp() throws Exception {
		stockManager = new StockManagerImp();
		List<Stock> stockList = new ArrayList<Stock>();
		Stock stock = new Stock();
		stock.setSTOCK_ID(CHAIR_ID);
		stock.setSTOCK_NAME(CHAIR_NAME);
		stock.setSTOCK_CODE(CHAIR_CODE);
		stockList.add(stock);
		
		stock = new Stock();
		stock.setSTOCK_ID(TABLE_ID);
		stock.setSTOCK_NAME(TABLE_NAME);
		stock.setSTOCK_CODE(TABLE_CODE);
		stockList.add(stock);
		
		stockManager.setStockList(stockList);
	}

	@Test
	public void testGetStockWithNoProducts() {
        stockManager = new StockManagerImp();
        assertNull(stockManager.getList());
    }
	
	@Test
	public void testGetList() {
		List<Stock> stockList = stockManager.getList();
		assertNotNull(stockList);
		assertEquals(STOCK_COUNT, stockList.size());
		
		Stock stock = stockList.get(0);
		assertEquals(CHAIR_ID, stock.getSTOCK_ID());
		assertEquals(CHAIR_CODE, stock.getSTOCK_CODE());
		assertEquals(CHAIR_NAME, stock.getSTOCK_NAME());
		
		stock = stockList.get(1);
		assertEquals(TABLE_ID, stock.getSTOCK_ID());
		assertEquals(TABLE_CODE, stock.getSTOCK_CODE());
		assertEquals(TABLE_NAME, stock.getSTOCK_NAME());
	}
	
	@Test
    public void testIncreaseCodeWithNullListOfProducts() {
        try {
        	stockManager = new StockManagerImp();
        	stockManager.increaseCode(POSITIVE_CODE_INCREASE);
        }
        catch(NullPointerException ex) {
            fail("Products list is null.");
        }
    }

    @Test
    public void testIncreaseCodeWithEmptyListOfProducts() {
        try {
        	stockManager = new StockManagerImp();
        	stockManager.setStockList(new ArrayList<Stock>());
        	stockManager.increaseCode(POSITIVE_CODE_INCREASE);
        }
        catch(Exception ex) {
            fail("Products list is empty.");
        }           
    }
    
    @Test
    public void testIncreaseCodeWithPositivePercentage() {
    	stockManager.increaseCode(POSITIVE_CODE_INCREASE);
        int expectedChairCodeWithIncrease = 33;
        int expectedTableCodeWithIncrease = 43;
        
        List<Stock> stockList = stockManager.getList();      
        Stock stock = stockList.get(0);
        assertEquals(expectedChairCodeWithIncrease, stock.getSTOCK_CODE(), 0);
        
        stock = stockList.get(1);      
        assertEquals(expectedTableCodeWithIncrease, stock.getSTOCK_CODE(), 0);       
    }
	
	
}
