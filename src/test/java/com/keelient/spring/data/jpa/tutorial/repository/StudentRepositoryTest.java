package com.keelient.spring.data.jpa.tutorial.repository;

import com.keelient.spring.data.jpa.tutorial.entity.Guardian;
import com.keelient.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("oliver.queen@starcity.com")
                .firstName("Oliver")
                .lastName("Queen")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("roy.harper@protonme.com")
                .name("Roy Harper")
                .mobileNumber("5556988565")
                .build();

        Student student = Student.builder()
                .emailId("quentin.lance@starcity.com")
                .firstName("Quentin")
                .lastName("Lance")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Oliver");
        System.out.println("students ByFirstName = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("liv");
        System.out.println("students ByFirstNameContaining = " + students);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList: " + studentList);
    }

    @Test
    public void findByLastNameNotNull() {
        List<Student> studentList = studentRepository.findByLastNameNotNull();
        System.out.println("studentList ByLastNameNotNull: " + studentList);
    }

    @Test
    public void findByGuardianName() {
        Student student = studentRepository.findByGuardianName("Roy Harper");
        System.out.println("student ByGuardianName: " + student);
    }

    @Test
    public void findByFirstNameAndLastName() {
        Student student = studentRepository.findByFirstNameAndLastName("Oliver", "Queen");
        System.out.println("student ByFirstNameAndLastName: " + student);
    }

    @Test
    public void getStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("quentin.lance@starcity.com");
        System.out.println("student ByEmailAddress: " + student);
    }

    @Test
    public void getStudentFirstNameByEmailAddress() {
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("quentin.lance@starcity.com");
        System.out.println("student firstName ByEmailAddress: " + firstName);
    }

    @Test
    public void getStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("quentin.lance@starcity.com");
        System.out.println("student ByEmailAddressNative: " + student);
    }

    @Test
    public void getStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("quentin.lance@starcity.com");
        System.out.println("student ByEmailAddressNativeNamedParam: " + student);
    }

    @Test
    public void updateStudentNameByEmailId() {
        studentRepository.updateStudentNameByEmailId("Cap. Quentin","quentin.lance@starcity.com");
    }
}