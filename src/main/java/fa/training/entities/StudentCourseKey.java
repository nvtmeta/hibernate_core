package fa.training.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * @author longnguyen on 25/01/2024
 * @product IntelliJ IDEA
 * @project ORM Demo
 */
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentCourseKey implements Serializable {

    private Integer studentId;

    private Integer courseId;
}
