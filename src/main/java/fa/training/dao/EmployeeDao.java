package fa.training.dao;

import fa.training.dto.DepartmentSummaryDTO;
import fa.training.entities.Department;
import fa.training.entities.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getAllDepartmentId(Integer departmentId);

    Long getTotalEmployeeById(Integer departmentId);

    List<DepartmentSummaryDTO> getDepartmentSummary();


    List<Employee> getAllByDepartmentIdByHQL(Integer departmentId);


    Long getTotalEmployeeByIdByHQL(Integer departmentId);


    //     lay thong tin phong ban  department theo employeeEmail
    Department getDepartmentByEmployeeEmail(String employeeEmail);

    List<DepartmentSummaryDTO> getDepartmentSummaryByHQL();

}
