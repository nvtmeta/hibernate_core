package fa.training;

import fa.training.dao.EmployeeDao;
import fa.training.dao.StudentDao;
import fa.training.dao.impl.EmployeeDaoImpl;
import fa.training.dto.DepartmentSummaryDTO;
import fa.training.entities.Department;
import fa.training.entities.Employee;

import java.util.List;

/**
 * @author longnguyen on 27/01/2024
 * @product IntelliJ IDEA
 * @project Default (Template) Project
 */
public class Main {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoImpl();

//        List<Employee> employeeList = employeeDao.getAllDepartmentId(1);

//        List<DepartmentSummaryDTO> departmentSummary = employeeDao.getDepartmentSummary();
//        departmentSummary.forEach(System.out::println);
//
//        List<Employee> employeeList = employeeDao.getAllByDepartmentIdByHQL(1);
//        employeeList.forEach(System.out::println);
//
//
//        Long totalEmployee = employeeDao.getTotalEmployeeByIdByHQL(1);
//        System.out.println(totalEmployee);

//        Department department = employeeDao.getDepartmentByEmployeeEmail("nguyenvana@gmail.com");
//        System.out.println(department);


        List<DepartmentSummaryDTO> departmentSummary = employeeDao.getDepartmentSummaryByHQL();
        departmentSummary.forEach(System.out::println);
    }
}