package com.keelient.spring.data.jpa.tutorial.repository;

import com.keelient.spring.data.jpa.tutorial.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByLastName(String khan);
}
