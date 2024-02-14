package practice.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column
    private String name;


    @Column
    private String email;


    @Column
    @OneToMany(mappedBy = "user")
    private List<Laptop> laptop;

}
