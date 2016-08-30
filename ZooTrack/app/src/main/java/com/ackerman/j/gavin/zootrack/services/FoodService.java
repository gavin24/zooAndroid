package com.ackerman.j.gavin.zootrack.services;

import com.ackerman.j.gavin.zootrack.Domain.Animal;
import com.ackerman.j.gavin.zootrack.Domain.Employee;
import com.ackerman.j.gavin.zootrack.Domain.Food;

/**
 * Created by gavin.ackerman on 2016-05-08.
 */
public interface FoodService extends Services<Food,Long>{
 /*   Food addFood(Food food);*/
    int addStock(int stock, Food food);
   int removeStock(int stock, Food food);
}
