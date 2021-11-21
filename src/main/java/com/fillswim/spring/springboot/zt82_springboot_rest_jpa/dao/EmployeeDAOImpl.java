package com.fillswim.spring.springboot.zt82_springboot_rest_jpa.dao;

import com.fillswim.spring.springboot.zt82_springboot_rest_jpa.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployees() {

        // Для Hibernate
//        Session session = entityManager.unwrap(Session.class);
//        List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();

        List<Employee> employees = entityManager.createQuery("from Employee").getResultList();

        return employees;
    }

    @Override
    public void saveEmployee(Employee employee) {

        // Для Hibernate
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);

        // Для JPA
        // Метод merge возвращает нового работника с id
        Employee newEmployee = entityManager.merge(employee);
        // Добавляем старому работнику id возращенного работника
        employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployee(int id) {

        // Для Hibernate
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, id);

        // Для JPA
        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public void deleteEmployee(int id) {

        // Для Hibernate
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeId");
//        query.setParameter("employeeId", id);
//        query.executeUpdate();

        // Для JPA
        Query query = entityManager.createQuery("delete from Employee where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
        query.executeUpdate();
    }
}
