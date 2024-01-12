package com.keelient.spring.data.jpa.tutorial.repository;

import com.keelient.spring.data.jpa.tutorial.entity.Course;
import com.keelient.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course courseDBA = Course.builder()
                .title("DBA IV")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .title("Java IV")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Qutub")
                .lastName("Khan")
                .courses(List.of(courseDBA, courseJava))
                .build();

        // Check if the teacher already exists in the database
        Optional<Teacher> existingTeacher = teacherRepository.findByLastName("Khan");

        if (existingTeacher.isPresent()) {
            // The teacher exists, update their courses
            existingTeacher.get().getCourses().addAll(teacher.getCourses());
            teacherRepository.save(existingTeacher.get());
        } else {
            // The teacher doesn't exist, create a new one and save it
            teacherRepository.save(teacher);
        }
    }

    @Test
    public void printTeachersAndCourses() {
        List<Teacher> teachers = teacherRepository.findAll();
        for (Teacher teacher : teachers) {
            System.out.println("teacher: " + teacher.getLastName());
            // Print the title of each course
            teacher.getCourses().forEach(course -> System.out.println("course: " + course.getTitle()));
        }
    }


}