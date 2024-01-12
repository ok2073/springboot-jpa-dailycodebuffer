package com.keelient.spring.data.jpa.tutorial.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            //When CascadeType.ALL is used, any change happened on the parent entity
            //will cascade to the associated child entity
            cascade = CascadeType.ALL,
            //specifies that the Course entity should be loaded lazily,
            //i.e., it will not be loaded from the database until it is explicitly accessed in the code.
            fetch = FetchType.LAZY,
            //Specifies that the Course entity is mandatory
            optional = false
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"  //The Course table PK
    )
    private Course course;
}
