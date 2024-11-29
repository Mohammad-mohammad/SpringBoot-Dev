package com.Moha.cruddemo.DAO;

import com.Moha.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();
}
