package com.ackerman.j.gavin.zootrack.services.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.ackerman.j.gavin.zootrack.Config.Util.App;
import com.ackerman.j.gavin.zootrack.Domain.Animal;
import com.ackerman.j.gavin.zootrack.Domain.Employee;

import com.ackerman.j.gavin.zootrack.Repository.Rest.RestAnimalApi;
import com.ackerman.j.gavin.zootrack.Repository.Rest.RestEmployeeApi;
import com.ackerman.j.gavin.zootrack.Repository.RestApi;
import com.ackerman.j.gavin.zootrack.services.EmployeeService;

import java.util.List;
import java.util.Set;

/**
 * Created by gavin.ackerman on 2016-05-08.
 */
public class EmployeeServiceImpl implements EmployeeService {
    final RestApi<Employee,Long> rest = new RestEmployeeApi();

    @Override
    public Employee findById(Long id){return rest.get(id);}

    @Override
    public String save(Employee entity){ return rest.post(entity);}

    @Override
    public String update(Employee entity){return rest.put(entity);}

    @Override
    public String delete(Employee entity){ return rest.delete(entity);}

    @Override
    public List<Employee> findAll(){return rest.getAll();}
/*    final private EmployeeRepository repository;

    private final IBinder localBinder = new ActivateServiceLocalBinder();

    private static EmployeeServiceImpl service = null;

    public static EmployeeServiceImpl getInstance()
    {
        if(service == null)
            service = new EmployeeServiceImpl();
        return service;
    }

    public EmployeeServiceImpl()
    {
        repository = new EmployeeRepositoryImpl(App.getAppContext());
    }

    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }

    public class ActivateServiceLocalBinder extends Binder {
        public EmployeeServiceImpl getService() {
            return EmployeeServiceImpl.this;
        }
    }*/
    public boolean isAuthentic(String username,String password)
    {
        List<Employee> employees;
        employees = rest.getAll();

        for (Employee employee : employees)

        {
            if (employee.getEmail().equalsIgnoreCase(username) && employee.getPassword().equals(password)) {
                return true;
            }

        }
        return false;
    }
/*    @Override
    public Employee addEmployee(Employee employee) {
        try{
            return rest.put(employee);
        }
        catch(Exception x)

        {
            x.printStackTrace();
        }
        return null;
    }*/
}
