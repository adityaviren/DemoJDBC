package com.cg.jdbcdemo;

import java.util.Date;

public class Employee {
    Integer emp_id;
    String name;
    Integer phone;
    String address;
    String department;
    char gender;
    Double basic_pay;
    Integer deductions;
    Integer taxable_pay;
    Integer tax;
    Integer net_pay;
    Date date;

    Employee(){

    }

    Employee(Integer emp_id,
            String name,
            Integer phone,
            String address,
            String department,
            char gender,
            Double basic_pay,
            Integer deductions,
            Integer taxable_pay,
            Integer tax,
            Integer net_pay,
             Date date){
        this.emp_id=emp_id;
        this.address=address;
        this.basic_pay=basic_pay;
        this.deductions=deductions;
        this.department=department;
        this.gender=gender;
        this.name=name;
        this.net_pay=net_pay;
        this.phone=phone;
        this.tax=tax;
        this.taxable_pay=taxable_pay;
        this.date=date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", emp_id=" + emp_id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                ", basic_pay=" + basic_pay +
                ", deductions=" + deductions +
                ", taxable_pay=" + taxable_pay +
                ", tax=" + tax +
                ", net_pay=" + net_pay +
                '}';
    }
}
