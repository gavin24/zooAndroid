package com.ackerman.j.gavin.zootrack.services.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.ackerman.j.gavin.zootrack.Config.Util.App;
import com.ackerman.j.gavin.zootrack.Domain.Food;
import com.ackerman.j.gavin.zootrack.Domain.Food;

import com.ackerman.j.gavin.zootrack.Repository.Rest.RestFoodApi;
import com.ackerman.j.gavin.zootrack.Repository.RestApi;
import com.ackerman.j.gavin.zootrack.services.FoodService;

import java.util.List;

/**
 * Created by gavin.ackerman on 2016-05-08.
 */
public class FoodServiceImpl  implements FoodService {
    final RestApi<Food,Long> rest = new RestFoodApi();

    @Override
    public Food findById(Long id){return rest.get(id);}

    @Override
    public String save(Food entity){ return rest.post(entity);}

    @Override
    public String update(Food entity){return rest.put(entity);}

    @Override
    public String delete(Food entity){ return rest.delete(entity);}

    @Override
    public List<Food> findAll(){return rest.getAll();}

    @Override
    public int addStock(int stock,Food food) {

            //Food found = repository.findById(food.getId());
            Food updatedFood = new Food.Builder()
                    .copy(food)
                   /* .id(found.getId())
                    .price(found.getprice())
                    .name(found.getname())*/
                   // .stock(found.getStock()+stock)
                    .stock(food.getStock()+stock)
                  //  .type(found.getType())
                    .build();
             rest.put(updatedFood);
            return updatedFood.getStock();

    }

    @Override
    public int removeStock(int stock,Food food) {

           // Food found = repository.findById(food.getId());
            Food updatedFood = new Food.Builder()
                    .copy(food)
                  /*  .id(found.getId())
                    .price(found.getprice())
                    .name(found.getname())*/
                    .stock(food.getStock()-stock)
                   // .type(found.getType())
                    .build();
            rest.put(updatedFood);
            return updatedFood.getStock();

    }

}
