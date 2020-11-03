package com.cg.jdbcdemo;

import java.sql.*;
import java.util.Date;

public class Query implements CRUD{
    Statement statement=null;
    public static void main(String[] args) {
        jdbcdemo connection = new jdbcdemo();
        Connection con = connection.makeConnection();

        try {

            String sql = "SELECT * from employee_payroll;";
            Statement stmt = con.createStatement();
            int i = stmt.executeUpdate("insert into employee_payroll (id,name,phone,address,department,gender,basic_pay,deductions,taxable_pay,income_tax,net_pay,start)" +
                    "values (1,'Bill',789789789,'KhauGali','Sales','M',15000.0,1000,14000,1000,13000,'2018-03-01')," +
                    "(2,'Tom',789789799,'KhapPanchayat','Sales','M',18000.0,1000,17000,2000,15000,'2018-01-01')," +
                    "(3,'Eric',789789999,'RJ','Sales','M',15000.0,1000,14000,1000,13000,'2018-03-01');");
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
                String department = rs.getString("department");
                Date start = rs.getDate("start");
                Character gender = (Character) rs.getObject("gender");
                double basic_pay = rs.getDouble("basic_pay");
                System.out.println(id + "," + name + "," + phone + "," + address + "," + "," +
                        department + "," + basic_pay + "," + deductions + "," + net_pay + "," + start);
            }
            con.commit();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void cascadingDelete(String name) {
        try {
            jdbcdemo connection = new jdbcdemo();
            Connection con = connection.makeConnection();
            int id = 0;
            PreparedStatement p = con.prepareStatement("select emp_id from employee where name=?");
            p.setString(1, name);
            ResultSet result1 = p.executeQuery();
            while (result1.next()) {
                id = result1.getInt(1);
                break;
            }
            //Clear Payroll table
            p = con.prepareStatement("delete from payroll where emp_id=?");
            p.setInt(1, id);
            p.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

        @Override
    public void create(String s) {

    }

    @Override
    public void update(String s) {

    }

    @Override
    public void delete(String s) {

    }

    @Override
    public void select(String s) {

    }
}

