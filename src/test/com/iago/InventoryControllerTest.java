package com.iago;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.iago.springapp.controller.InventoryController;
import com.iago.springapp.service.StockManagerImp;

public class InventoryControllerTest {

    @Test
    public void testHandleRequestView() throws Exception{		
    	InventoryController controller = new InventoryController();
    	controller.setStockManager(new StockManagerImp());
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        @SuppressWarnings("unchecked")
        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);
    }


}
