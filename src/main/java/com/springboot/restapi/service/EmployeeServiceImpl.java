package com.springboot.restapi.service;

import com.springboot.restapi.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    private static List<Employee> employees = new ArrayList<>();
    static {
        Employee employee = new Employee();
        employee.setName("Ayşe");
        employee.setAge(25L);
        employee.setDepartment("IT");
        employee.setEmail("ayse@hotmail.com");
        employee.setLocation("İstanbul");
        employees.add(employee);

        employee = new Employee();
        employee.setName("Ali");
        employee.setAge(25L);
        employee.setDepartment("IT");
        employee.setEmail("ali@hotmail.com");
        employee.setLocation("İstanbul");
        employees.add(employee);
    }

    @Override
    public List<Employee> getEmloyees() {
        return employees;
    }
}
