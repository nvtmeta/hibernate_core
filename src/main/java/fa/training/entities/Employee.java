package fa.training.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "employee")
@Table(name = "employees")
@Builder
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Nationalized
    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Enumerated(EnumType.STRING)
    private EmployeeLevel level;

    @Column(name = "email", unique = true, nullable = false)
    private String email;


    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


}
