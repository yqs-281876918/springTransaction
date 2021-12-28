package org.example;

import static org.junit.Assert.assertTrue;

import com.eshopping.dao.GoodDao;
import com.eshopping.domain.Good;
import com.eshopping.service.BuyGoodService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test()
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        BuyGoodService buyGoodService=(BuyGoodService) context.getBean("buyGoodService");
        buyGoodService.buy(1001,1);
    }
}
