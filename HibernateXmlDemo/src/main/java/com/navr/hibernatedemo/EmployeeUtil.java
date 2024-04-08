package com.navr.hibernatedemo;

import com.navr.hibernatedemo.entity.Employee;
import com.navr.hibernatedemo.entity.EmployeeAddress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EmployeeUtil {

    public static List<Employee> createEmployeeRecord() {
        Employee e1 = new Employee("Virat", "Kohli");
        Employee e2 = new Employee("Rohit", "Sharma");
        Employee e3 = new Employee("David", "Warner");
        Employee e4 = new Employee("Dhoni", "MS");
        Employee e5 = new Employee("Tejasvi", "Jaiswal");

        Employee[] employees = {e1,e2,e3,e4,e5};

        return Arrays.asList(e1, e2, e3, e4, e5);
    }

    public static List<EmployeeAddress> createEmployeeAddressRecord(List<Employee> empList) {
        List<EmployeeAddress> employeeAddressList = new ArrayList<>();
        List<String> cityList = Arrays.asList(new String[]{"Mumbai", "Bengaluru", "Chennai", "New Delhi", "Kolkata"});
        for (Employee emp : empList) {
            EmployeeAddress empAddr = null;
            if (emp != null) {
                Random rand = new Random();
                empAddr = new EmployeeAddress();
                empAddr.setEmpId(emp.getEmpId());
                empAddr.setAddress("First street, 4th Main road");
                empAddr.setCity(cityList.get(rand.nextInt(cityList.size())));
                empAddr.setState("Maharastra");
                int randInt = rand.nextInt(100);
                String randStr = String.format("%03d", randInt);
                empAddr.setZip("400"+randStr);
            }
            employeeAddressList.add(empAddr);
        }
        return employeeAddressList;
    }
}
