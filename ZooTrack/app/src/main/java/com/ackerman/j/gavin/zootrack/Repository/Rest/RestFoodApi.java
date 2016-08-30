package com.ackerman.j.gavin.zootrack.Repository.Rest;

import com.ackerman.j.gavin.zootrack.Domain.Animal;
import com.ackerman.j.gavin.zootrack.Domain.Food;
import com.ackerman.j.gavin.zootrack.Repository.RestApi;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gavin.ackerman on 2016-08-21.
 */
public class RestFoodApi implements RestApi<Food,Long> {
    final String BASE_URL="http://zootrack-gavinsoccerapp.rhcloud.com/foods/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();

    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Food get(Long id) {
        final String url = BASE_URL+"food/"+id.toString();
        HttpEntity<Food> requestEntity = new HttpEntity<Food>(requestHeaders);
        ResponseEntity<Food> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Food.class);
        Food Food = responseEntity.getBody();
        return Food;
    }

    @Override
    public String post(Food entity) {
        final String url = BASE_URL+"create/";
        HttpEntity<Food> requestEntity = new HttpEntity<Food>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Food entity) {
        final String url = BASE_URL+"update/"+entity.getId().toString();
        HttpEntity<Food> requestEntity = new HttpEntity<Food>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Food entity) {
        final String url = BASE_URL+"food/delete/"+entity.getId().toString();
        HttpEntity<Food> requestEntity = new HttpEntity<Food>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Food> getAll() {
        List<Food> foodsList = new ArrayList<>();
        final String url = BASE_URL+"all/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Food[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Food[].class);
        Food[] results = responseEntity.getBody();

        for (Food food : results) {
            foodsList.add(food);
        }
        return foodsList;
    }
}
