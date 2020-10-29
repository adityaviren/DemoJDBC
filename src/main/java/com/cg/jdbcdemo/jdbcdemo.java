package com.cg.jdbcdemo;

import java.sql.*;
import java.util.Enumeration;

public class jdbcdemo {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost/testdb?useSSL=false";
        String userName = "root";
        String password = "aditya@123";
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }

        listDrivers();

        try {
            System.out.println("Connecting to database:" + jdbcURL);
            con = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("Connection is successful!!!!" + con);
            String sql = "SELECT * from employee_payroll;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(stmt.executeQuery(sql));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = driverList.nextElement();
            System.out.println(driverClass.getClass().getName());
        }
    }
}
