package practice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "laptop")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column
    private String name;

    @Column
    private String brand;

    @Column
    private String cpu;

    @Column
    private String ram;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
