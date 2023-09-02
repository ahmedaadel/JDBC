package com.jdbc.jdbccourse.dao;

import java.util.List;

public interface employeeInterface {
    List<Employee> finEmployees();
    Employee getEmployeeById(int id);
    void    saveEmployee(Employee employee);
    void deleteByID(int id);
    
}
