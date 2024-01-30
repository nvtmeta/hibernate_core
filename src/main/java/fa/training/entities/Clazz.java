package fa.training.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
@Table(name = "class")
@Builder
@ToString
public class Clazz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "clazz", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Student> students;

    @OneToOne(mappedBy = "clazz")
    private ClazzDetail clazzDetail;

    private String description;


}
