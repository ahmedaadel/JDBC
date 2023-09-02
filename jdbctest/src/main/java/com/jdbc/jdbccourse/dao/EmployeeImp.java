package com.jdbc.jdbccourse.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class EmployeeImp implements employeeInterface {

    @Override
    public List<Employee> finEmployees() {
        Connection con = dbconnection.gConnection();

        List<Employee> employees = new LinkedList<>();

        String query = "SELECT * FROM employee;";
        try (PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getString("name"), resultSet.getBoolean("gender"),
                        resultSet.getDouble("salary"), resultSet.getDate("birthdate"), resultSet.getInt("id"));
                employees.add(employee);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Connection con = dbconnection.gConnection();
        if (con == null)
            return null;

        String query = "SELECT * FROM employee WHERE id = ? ;";

        try (PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

                

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
               {
              return new Employee(resultSet.getString("name"), resultSet.getBoolean("gender"),
                        resultSet.getDouble("salary"), resultSet.getDate("birthdate"), resultSet.getInt("id"));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null ;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Connection con = dbconnection.gConnection();
        if (con == null) {
            System.out.println("we fucked up ");
            return;
        }
        if (employee.getId() > 0) {
            String query = "UPDATE employee SET name=?, gender= ?  , birthdate =? , salary = ? WHERE id = ? ";
            try (PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);) {
                preparedStatement.setString(1, employee.getName());
                preparedStatement.setBoolean(2, employee.getGender());
                preparedStatement.setDate(3, employee.getDate());
                preparedStatement.setDouble(4, employee.getSalary());
                preparedStatement.setInt(5, employee.getId());

                preparedStatement.executeUpdate();

            } catch (SQLException se) {
                se.printStackTrace();
            }

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String query = "INSERT INTO employee (name, gender , birthdate , salary) VALUES(?,?,?,?)";
            try (PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);) {
                preparedStatement.setString(1, employee.getName());
                preparedStatement.setBoolean(2, employee.getGender());
                preparedStatement.setDate(3, employee.getDate());
                preparedStatement.setDouble(4, employee.getSalary());

                preparedStatement.executeUpdate();

            } catch (SQLException se) {
                se.printStackTrace();
            }

            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void deleteByID(int id) {
    }

}
