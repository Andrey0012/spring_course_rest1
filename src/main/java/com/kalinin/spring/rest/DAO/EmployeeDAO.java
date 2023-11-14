package com.kalinin.spring.rest.DAO;


import com.kalinin.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployee ();
    void saveEmployee (Employee employee);
    Employee getEmployee(int id);
    void  deleteEmployee (int id);
}
