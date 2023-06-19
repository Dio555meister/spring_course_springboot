package com.zaurtregulov.spring.springboot.spring_course_springboot.service;


import com.zaurtregulov.spring.springboot.spring_course_springboot.dao.EmployeeDAO;
import com.zaurtregulov.spring.springboot.spring_course_springboot.entity.Employee;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service // Service содержит бизнес логику. Соединяет Контроллер и ДАО
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    //@PersistenceContext
    private EmployeeDAO employeeDAO;
    @Override
    @Transactional
    public List<Employee> getAllEmployees() { // метод   вызывает метод getAllEmployees из ДАО
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }
    @Transactional
    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);

    }
}
