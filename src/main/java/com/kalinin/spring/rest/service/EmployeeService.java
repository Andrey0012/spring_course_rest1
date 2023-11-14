package com.kalinin.spring.rest.service;


import com.kalinin.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee ();
    void saveEmployee (Employee employee);
    Employee getEmployee (int id);
    void deleteEmployee (int id);

}
