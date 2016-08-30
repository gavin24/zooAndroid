package com.ackerman.j.gavin.zootrack.Repository.Rest;

import com.ackerman.j.gavin.zootrack.Domain.Animal;
import com.ackerman.j.gavin.zootrack.Domain.Employee;
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
public class RestEmployeeApi implements RestApi<Employee,Long> {
    final String BASE_URL="http://zootrack-gavinsoccerapp.rhcloud.com/employees/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();

    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Employee get(Long id) {
        final String url = BASE_URL+"employee/"+id.toString();
        HttpEntity<Employee> requestEntity = new HttpEntity<Employee>(requestHeaders);
        ResponseEntity<Employee> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Employee.class);
        Employee Employee = responseEntity.getBody();
        return Employee;
    }

    @Override
    public String post(Employee entity) {
        final String url = BASE_URL+"create/";
        HttpEntity<Employee> requestEntity = new HttpEntity<Employee>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Employee entity) {
        final String url = BASE_URL+"update/"+entity.getId().toString();
        HttpEntity<Employee> requestEntity = new HttpEntity<Employee>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Employee entity) {
        final String url = BASE_URL+"employee/delete/"+entity.getId().toString();
        HttpEntity<Employee> requestEntity = new HttpEntity<Employee>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeesList = new ArrayList<>();
        final String url = BASE_URL+"all/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Employee[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Employee[].class);
        Employee[] results = responseEntity.getBody();

        for (Employee employee : results) {
            employeesList.add(employee);
        }
        return employeesList;
    }
}
