package com.jdbc.jdbccourse.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {
    private static final String Host = "127.0.0.1";
    private static final int PORT = 3306;
    private static final String DB_NAME = "jdbc_db";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "";

    static private Connection connection;

    public static Connection gConnection() {
        try {connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", Host, PORT, DB_NAME), USER_NAME,PASSWORD);
    } catch(SQLException se){
        se.printStackTrace();
    }
        return connection; 
    }

}
