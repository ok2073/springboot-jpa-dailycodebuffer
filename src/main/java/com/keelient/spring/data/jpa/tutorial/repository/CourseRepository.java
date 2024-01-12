package com.keelient.spring.data.jpa.tutorial.repository;

import com.keelient.spring.data.jpa.tutorial.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
