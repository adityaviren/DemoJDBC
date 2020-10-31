package com.cg.jdbcdemo;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
}
