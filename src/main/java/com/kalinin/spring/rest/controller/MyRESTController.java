package com.kalinin.spring.rest.controller;

import com.kalinin.spring.rest.entity.Employee;
import com.kalinin.spring.rest.exception_handler.NoSuchEmployeeException;
import com.kalinin.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployee() {
        List<Employee> allEmployee = employeeService.getAllEmployee();
        return allEmployee;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployees(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException ("There is no employee with ID = " + id + "  in Database");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployees(@PathVariable int id) {
        Employee employee=employeeService.getEmployee(id);
        if (employee==null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + "  in Database");
        }
        employeeService.deleteEmployee(id);
        return "Employee where ID = " + id + " delete";
    }
}
