package com.moha.cruddemo.dao;

import com.moha.cruddemo.entity.Course;
import com.moha.cruddemo.entity.Instructor;
import com.moha.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCourseByInstructorId(int id);
}