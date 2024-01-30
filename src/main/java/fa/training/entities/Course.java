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
@Table(name = "course")
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

//    @ManyToMany(mappedBy = "courses")
//    private List<Student> students;
}
