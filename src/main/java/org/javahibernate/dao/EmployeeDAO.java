package org.javahibernate.dao;

import org.hibernate.SessionFactory;
import org.javahibernate.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(Employee emp) {
        sessionFactory.getCurrentSession().saveOrUpdate(emp);
    }

    @Transactional
    public Employee getById(int id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    @Transactional
    public List<Employee> getAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Employee", Employee.class)
                .list();
    }

    @Transactional
    public void delete(int id) {
        Employee emp = getById(id);
        if (emp != null)
            sessionFactory.getCurrentSession().delete(emp);
    }
}
