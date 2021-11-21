package com.fillswim.spring.springboot.zt82_springboot_rest_jpa.dao;




import com.fillswim.spring.springboot.zt82_springboot_rest_jpa.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);


}
