package com.zaurtregulov.spring.springboot.spring_course_springboot.dao;


import com.zaurtregulov.spring.springboot.spring_course_springboot.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
// Это наш репозиторий
@Repository
public class EmployeeDAOImpl implements EmployeeDAO { //класс ответственный за работу с БД
    @PersistenceContext
    private EntityManager entityManager;

    @Override

    public List<Employee> getAllEmployees() { // получаем работников

        //entityManager обертка сессии. unwrap-разворачиваем обертку
//        Session session = entityManager.unwrap(Session.class);
//
//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//        List<Employee> allEmployees =  query.getResultList();

        //        List<Employee> allEmployees = session.createQuery("from Employee",
//                Employee.class).getResultList();
        Query query = entityManager.createQuery("from  Employee ");
        List<Employee> allEmployees =  query.getResultList();



        return allEmployees;
    }
    @Override
    public void saveEmployee(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);
//saveOrUpdate=merge
       Employee newEmployee =  entityManager.merge(employee);
       employee.setId(newEmployee.getId()); // что бы в респонсе  id был не 0

    }

    @Override
    public Employee getEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, id);

        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("delete from Employee " +
//                "where id=:empolyeeId");
//        query.setParameter("employeeId", id);
//        query.executeUpdate();

        Query query = entityManager.createQuery("delete from Employee " +
                "where id=:empolyeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
