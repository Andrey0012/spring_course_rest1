package com.kalinin.spring.rest.DAO;


import com.kalinin.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployee() {
        Session currentSession = sessionFactory.getCurrentSession();
        // List<Employee> from_emploee = currentSession.createQuery("from Emploee", Employee.class).getResultList();
        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
        List<Employee> allEmployee = query.getResultList();
        return allEmployee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery(" delete from Employee  where id=:employeeId");
        query.setParameter("employeeId",id);
        query.executeUpdate();
    }


}
