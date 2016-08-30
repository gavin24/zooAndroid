package com.ackerman.j.gavin.zootrack.services.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.ackerman.j.gavin.zootrack.Config.Util.App;
import com.ackerman.j.gavin.zootrack.Domain.Animal;

import com.ackerman.j.gavin.zootrack.Repository.Rest.RestAnimalApi;
import com.ackerman.j.gavin.zootrack.Repository.RestApi;
import com.ackerman.j.gavin.zootrack.services.AnimalService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gavin.ackerman on 2016-05-08.
 */
public class AnimalServiceImpl implements AnimalService {
    final RestApi<Animal,Long> rest = new RestAnimalApi();

    @Override
    public Animal findById(Long id){return rest.get(id);}

    @Override
    public String save(Animal entity){ return rest.post(entity);}

    @Override
    public String update(Animal entity){return rest.put(entity);}

    @Override
    public String delete(Animal entity){ return rest.delete(entity);}

    @Override
    public List<Animal> findAll(){return rest.getAll();}

   /* @Override
    public Animal addAnimal(Animal animal) {
        try{
            return rest.save(animal);
        }
        catch(Exception x)

       {
            x.printStackTrace();
        }
        return null;
    }
    @Override
    public Animal deleteAnimal(Animal animal) {
        return rest.delete(animal);
    }

    @Override
    public ArrayList<Animal> getAllAnimals() {
        try {
            ArrayList<Animal> result = new ArrayList<>();
            if (result.addAll(rest.getAll()))
                return result;
            else
                return new ArrayList<Animal>();
        } catch (Exception x) {
            x.printStackTrace();
        }
        return null;
    }

    @Override
    public void removeAllAnimals() {
        rest.deleteAll();
    }
    @Override
    public Animal updateAnimal(Animal animal) {
        return rest.update(animal);
    }

    @Override
    public Animal getAnimal(Long Id) {
        return rest.findById(Id);
    }*/
}
