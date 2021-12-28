package com.eshopping.dao;

import com.eshopping.domain.Good;

public interface GoodDao
{
    int updateGood(Good good);
    Good selectGood(Integer id);
}
