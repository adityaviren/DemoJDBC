package com.cg.jdbcdemo;

import java.sql.*;
import java.util.Date;
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

        //id  name  phone     address  departmentid  department  gender  basic_pay  deductions taxable_pay  income_tax  net_pay start

        try {
            System.out.println("Connecting to database:" + jdbcURL);
            con = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("Connection is successful!!!!" + con);
            String sql = "SELECT * from employee_payroll;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int phone = rs.getInt("phone");
                int deductions = rs.getInt("deductions");
                int tax_pay = rs.getInt("taxable_pay");
                int income_tax = rs.getInt("income_tax");
                int net_pay = rs.getInt("net_pay");
                String address = rs.getString("address");
                String departmentid = rs.getString("departmentid");
                String department = rs.getString("department");
                Date start = rs.getDate("start");
                char gender = rs.getString("gender").charAt(0);
                double basic_pay = rs.getDouble("basic_pay");
                System.out.println(id + "," + name + "," + phone + "," + address + "," + departmentid + "," +
                        department + "," + basic_pay + "," + deductions + "," + net_pay + "," + start);
            }
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
