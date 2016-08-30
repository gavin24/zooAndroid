package com.ackerman.j.gavin.zootrack.Repository.Rest;

import com.ackerman.j.gavin.zootrack.Domain.Animal;
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
public class RestAnimalApi implements RestApi<Animal,Long> {
    final String BASE_URL="http://zootrack-gavinsoccerapp.rhcloud.com/animals/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();

    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Animal get(Long id) {
        final String url = BASE_URL+"animal/"+id.toString();
        HttpEntity<Animal> requestEntity = new HttpEntity<Animal>(requestHeaders);
        ResponseEntity<Animal> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Animal.class);
        Animal Animal = responseEntity.getBody();
        return Animal;
    }

    @Override
    public String post(Animal entity) {
        final String url = BASE_URL+"create/";
        HttpEntity<Animal> requestEntity = new HttpEntity<Animal>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Animal entity) {
        final String url = BASE_URL+"update/"+entity.getId().toString();
        HttpEntity<Animal> requestEntity = new HttpEntity<Animal>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Animal entity) {
        final String url = BASE_URL+"animal/delete/"+entity.getId().toString();
        HttpEntity<Animal> requestEntity = new HttpEntity<Animal>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Animal> getAll() {
        List<Animal> animalsList = new ArrayList<>();
        final String url = BASE_URL+"all/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Animal[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Animal[].class);
        Animal[] results = responseEntity.getBody();

        for (Animal animal : results) {
            animalsList.add(animal);
        }
        return animalsList;
    }
}
