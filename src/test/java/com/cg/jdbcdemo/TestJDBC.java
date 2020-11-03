package com.cg.jdbcdemo;

import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class TestJDBC {

    @Test
    public void givenConnection_whenInserted_shouldInsertInSQL() throws SQLException {
        jdbcdemo connection = new jdbcdemo();
        Connection con = connection.makeConnection();
        Statement stmt = con.createStatement();
        int i = stmt.executeUpdate("insert into employee_payroll (id,name,phone,address,department,gender,basic_pay,deductions,taxable_pay,income_tax,net_pay,start)" +
                "values (5,'Bill5',789789789,'KhauGali','Sales','M',15000.0,1000,14000,1000,13000,'2018-03-01');");
        Assert.assertEquals(0,i);
    }

    @Test
    public void givenConnection_whenInserted_shouldCommit() throws SQLException {
        jdbcdemo connection = new jdbcdemo();
        Connection con = connection.makeConnection();
        con.setAutoCommit(false);
        Statement stmt = con.createStatement();
        int i = stmt.executeUpdate("insert into employee_payroll (id,name,phone,address,department,gender,basic_pay,deductions,taxable_pay,income_tax,net_pay,start)" +
                "values (12,'Bill10',789789789,'KhauGali','Sales','M',15000.0,1000,14000,1000,13000,'2018-03-01');");
        con.commit();
        Assert.assertEquals(1,i);

    }

    @Test
    public void givenPreparedStatement_shouldExecute() throws SQLException {
        jdbcdemo connection = new jdbcdemo();
        Connection con = connection.makeConnection();
        PreparedStatement stmt=con.prepareStatement("insert into employee_payroll (id,name,phone,address,department,gender,basic_pay,income_tax,net_pay,start) " +
                                                    "values(?,?,?,?,?,?,?,?,?,?)");
        stmt.setInt(1,15);
        stmt.setInt(3,97897890);
        stmt.setInt(7,15000);
        stmt.setInt(8,1500);
        stmt.setInt(9,13500);
        stmt.setDate(10, new Date(8000000));
        stmt.setString(2,"Laddi");
        stmt.setString(4,"HP");
        stmt.setString(5,"NA");
        stmt.setString(6,"F");
        int i = stmt.executeUpdate();

        Assert.assertEquals(1,i);
    }


    @Test
    public void givenDates_shouldReturnEmployees() throws SQLException {
        jdbcdemo connection = new jdbcdemo();
        Connection con = connection.makeConnection();
        Statement stmt = con.createStatement();
        String sql = "Select name from employee_payroll where start>2018-01-01 & start<2019-01-01";
        ResultSet rs = stmt.executeQuery(sql);
        int employees=0;
        while (rs.next()){
            System.out.println(rs.getString(1));
            employees++;
        }
        Assert.assertEquals(10,employees);
    }

    @Test
    public void givenTable_shouldReturnSumOfSalary() throws SQLException {
        jdbcdemo connection = new jdbcdemo();
        Connection con = connection.makeConnection();
        Statement stmt = con.createStatement();
        String sql = "select sum(basic_pay) as sumofsalary , gender from employee_payroll group by gender";
        ResultSet rs = stmt.executeQuery(sql);
        int count = 0;
        while (rs.next()){
            System.out.println(rs.getInt(1)+" "+ rs.getString(2).charAt(0));
            count++;
        }
        Assert.assertEquals(2,count);
    }
}
