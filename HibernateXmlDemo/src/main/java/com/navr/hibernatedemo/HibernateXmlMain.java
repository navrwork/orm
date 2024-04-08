package com.navr.hibernatedemo;

import com.navr.hibernatedemo.entity.Employee;
import com.navr.hibernatedemo.entity.EmployeeAddress;

import java.util.List;

public class HibernateXmlMain {

    public static void main(String[] args) {
        createAndPersistEmployeeRecord();
    }

    private static void createAndPersistEmployeeRecord() {
        List<Employee> empList = EmployeeUtil.createEmployeeRecord();
        List<EmployeeAddress> empAddrList = EmployeeUtil.createEmployeeAddressRecord(empList);
        HibernateUtil.persist(empList, empAddrList);
    }


}  