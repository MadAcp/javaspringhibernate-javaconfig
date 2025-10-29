package org.javahibernate.service;

import org.javahibernate.dao.EmployeeDAO;
import org.javahibernate.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDAO dao;

    public void save(Employee emp) { dao.save(emp); }
    public Employee getById(int id) { return dao.getById(id); }
    public List<Employee> getAll() { return dao.getAll(); }
    public void delete(int id) { dao.delete(id); }
}
