package com.eshopping.service.impl;

import com.eshopping.dao.GoodDao;
import com.eshopping.dao.SaleDao;
import com.eshopping.domain.Good;
import com.eshopping.domain.Sale;
import com.eshopping.exception.NotEnoughException;
import com.eshopping.service.BuyGoodService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BuyGoodServiceImpl implements BuyGoodService
{
    private SaleDao saleDao;
    private GoodDao goodDao;
    /**
     * @param goodID
     * @param nums
     */
    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            rollbackFor = {NullPointerException.class, NotEnoughException.class}
    )
    @Override
    public void buy(Integer goodID, Integer nums) {
        System.out.println("===buy-begin==");
        //更新销售信息
        Sale sale = new Sale();
        sale.setGoodID(goodID);
        sale.setNums(nums);
        saleDao.insertSale(sale);
        //更新库存信息
        Good good=goodDao.selectGood(goodID);
        if(good==null)
        {
            throw new NullPointerException(String.format("编号为%d的商品不存在",goodID));
        }
        else if(good.getAmount()<nums)
        {
            throw new NullPointerException(String.format("编号为%d的商品库存不足",goodID));
        }
        Good buyInfo=new Good();
        buyInfo.setId(goodID);
        buyInfo.setAmount(nums);
        goodDao.updateGood(buyInfo);
        System.out.println("===buy-end==");
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodDao(GoodDao goodDao) {
        this.goodDao = goodDao;
    }
}
