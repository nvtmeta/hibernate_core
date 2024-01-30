package fa.training.entities;

import lombok.*;

import jakarta.persistence.*;

/**
 * @author longnguyen on 25/01/2024
 * @product IntelliJ IDEA
 * @project ORM Demo
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "student_course")
@Builder
public class StudentCourse{

    @EmbeddedId
    private StudentCourseKey studentCourseKey;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @MapsId("courseId")
    private Course course;

    private Float score;

    private Integer level;

    //ddl -> done -> create table, columns, constraints
    //dml -> CRUD -> (create, select, update, delete) ->
}
