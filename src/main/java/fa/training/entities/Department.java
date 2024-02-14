package fa.training.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "department")
@Table(name = "departments")
@Builder
@ToString
public class Department {

    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentId;

    @Column(name = "department_name", nullable = false)
    private String departmentName;


    @ToString.Exclude
    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;

}
