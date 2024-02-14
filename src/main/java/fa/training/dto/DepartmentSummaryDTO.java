package fa.training.dto;

import fa.training.entities.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DepartmentSummaryDTO {

    private String departmentName;

    private Long totalEmployee;
}
