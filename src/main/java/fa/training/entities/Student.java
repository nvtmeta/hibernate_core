package fa.training.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "student")
@Builder
public class Student {

    /**
     * id INT PRIMARY KEY IDENTITY,
     *     [name] NVARCHAR(255) NOT NULL,
     *     gpa DECIMAL NOT NULL,
     *     dob DATE,
     *     score float,
     *     remark NVARCHAR(1000)
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    @Nationalized
    private String name;

    @Column(name = "gpa", nullable = false)
    private BigDecimal gpa;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "remark", nullable = false, length = 1000)
    @Nationalized
    private String remark;

//    @Column(name = "class_id", columnDefinition = "INT FOREIGN KEY REFERENCES class(id)")
//    private Integer classId;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Clazz clazz;
    //Student -> Class: onedirectional mapping => Done
    //Student -> Class -> Students: bidirectional mapping

//    @ManyToMany
//    @JoinTable(name = "student_courses")
//    private List<Course> courses;
}
