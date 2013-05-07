package com.iago;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.iago.springapp.domain.Stock;

public class StockTest {

    private Stock stock;

    @Before
    public void setUp() throws Exception {
    	stock = new Stock();
    }

    @Test
    public void testSetAndGetSTOCK_NAME() {
        String testName = "Name";
        assertNull(stock.getSTOCK_NAME());
        stock.setSTOCK_NAME(testName);
        assertEquals(testName, stock.getSTOCK_NAME());
    }

    @Test
    public void testSetAndGetSTOCK_CODE() {
        int testCode = 100;
        assertEquals(0, stock.getSTOCK_CODE(), 0);
        stock.setSTOCK_CODE(testCode);
        assertEquals(testCode, stock.getSTOCK_CODE());
    }

}
