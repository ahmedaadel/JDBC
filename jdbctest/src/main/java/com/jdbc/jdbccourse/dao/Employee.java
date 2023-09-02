package com.jdbc.jdbccourse.dao;

import java.sql.Date;

public class Employee {
    private int id;
    private String name;
    private boolean gender;
    private double salary;
    private Date date;
    public char[] getSalary;

    public Employee() {
    }

    public Employee(String name, boolean gender, double salary, Date date , int id) {
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.date = date;
        this.id = id; 
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }
     public boolean getGender() {
        return gender;
    }

}
