package com.keelient.spring.data.jpa.tutorial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long teacherId;
    private String firstName;
    private String lastName;


    @OneToMany(
            mappedBy = "teacher",
            fetch = FetchType.EAGER
    )
    //Use if you want to save Teacher together with courses
    /*@OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )*/
    private List<Course> courses;

    @Override
    public String toString() {
        return String.format("Teacher [firstName=%s, lastName=%s, totalCourses=%d]", firstName, lastName, courses.size());
    }

}
