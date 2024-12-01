package com.moha.cruddemo.dao;

import com.moha.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
