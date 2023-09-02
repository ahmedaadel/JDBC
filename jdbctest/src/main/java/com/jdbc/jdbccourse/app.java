package com.jdbc.jdbccourse;


import com.jdbc.jdbccourse.dao.Employee;
import com.jdbc.jdbccourse.dao.EmployeeImp;
import com.jdbc.jdbccourse.dao.employeeInterface;

public class app {
    public static void main(String[] args) {
      employeeInterface emp = new EmployeeImp();
      //Employee employee = new Employee("ahmed adel", true, 1100, new Date(0),1);
      //emp.saveEmployee(employee);
      //emp.finEmployees().forEach(e -> System.out.println(e.getSalary()));
      Employee employee = emp.getEmployeeById(1);
      System.out.println(employee.getSalary());

    }
}
