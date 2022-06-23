package com.springboot.restapi.controller;

import com.springboot.restapi.model.Employee;
import com.springboot.restapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("/version")
    public String getAppDetails(){
        return appName + "-" + appVersion;
    }

    //localhost:8080/employees

    @GetMapping("/employees")
    public List<Employee> getEmployees () {
        return employeeService.getEmloyees();
    }

    //localhost:8080/employees/12
    @GetMapping("/employees/{id}")
    public String getEmployee (@PathVariable("id") Long id) {
        return "Fetching the employee details for the id " + id;
    }

    @PostMapping("/employees")
    public String saveEmployee (@RequestBody Employee employee) {
        return "saving the employee details to the database" + employee;
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        System.out.println("updating the employee data for the id " + id);
        return employee;
    }

    //localhost:8080/employees?id=34
    @DeleteMapping("/employees")
    public String deleteEmployee(@RequestParam Long id) {
        return "Deleteing the employee details for the id " + id;
    }

}
