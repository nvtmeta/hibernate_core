package fa.training.dao.impl;

import fa.training.dao.EmployeeDao;
import fa.training.dto.DepartmentSummaryDTO;
import fa.training.entities.Department;
import fa.training.entities.Employee;
import fa.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public List<Employee> getAllDepartmentId(Integer departmentId) {
        try (Session session = HibernateUtils.openSession()) {
            String sql = "select * from employees where id = :departmentId";
            Query<Employee> query = session.createNativeQuery(sql, Employee.class);

            query.setParameter("departmentId", departmentId);

            return query.list();
        }
    }

    @Override
    public Long getTotalEmployeeById(Integer departmentId) {
        try (Session session = HibernateUtils.openSession()) {
            String sql = "select count(*) from employees where department_id = :departmentId";
            Query<Long> query = session.createNativeQuery(sql, Long.class);

            query.setParameter("departmentId", departmentId);

            return query.getSingleResult();
        }
    }

    @Override
    public List<DepartmentSummaryDTO> getDepartmentSummary() {
        try (Session session = HibernateUtils.openSession()) {
            String sql = """
                    select d.department_name, count(*) as total_employee from employees e\s
                    left join departments d on e.department_id = d.department_id\s
                    group by d.department_name\s""";
            Query<DepartmentSummaryDTO> query = session
                    .createNativeQuery(sql, DepartmentSummaryDTO.class)
                    .setTupleTransformer((t, a) -> {
                        return new DepartmentSummaryDTO(
                                (String) t[0],
                                Long.valueOf((t[1].toString()))
                        );
                    });
            return query.list();
        }
    }

    @Override
    public List<Employee> getAllByDepartmentIdByHQL(Integer departmentId) {
        try (Session session = HibernateUtils.openSession()) {
            String sql = "select e from employee e where e.department.id = :departmentId";
            Query<Employee> query = session.createQuery(sql, Employee.class);

            query.setParameter("departmentId", departmentId);

            return query.list();
        }
    }

    @Override
    public Long getTotalEmployeeByIdByHQL(Integer departmentId) {
        try (Session session = HibernateUtils.openSession()) {
            String sql = "select count(1) from employee e where e.department.id = :departmentId";
            Query<Long> query = session.createQuery(sql, Long.class);

            query.setParameter("departmentId", departmentId);

            return query.getSingleResult();

        }
    }

    @Override
    public Department getDepartmentByEmployeeEmail(String employeeEmail) {
        try (Session session = HibernateUtils.openSession()) {
            String sql = "select d from employee e " +
                    "inner join e.department d where e.email = :employeeEmail";
            Query<Department> query = session.createQuery(sql, Department.class);

            query.setParameter("employeeEmail", employeeEmail);

            return query.getSingleResult();
        }
    }

    @Override
    public List<DepartmentSummaryDTO> getDepartmentSummaryByHQL() {
        try (Session session = HibernateUtils.openSession()) {
            String sql = """
                    select new fa.training.dto.DepartmentSummaryDTO(d.departmentName, count(*)) from department d\s
                    left join d.employees e group by d.departmentName
                    """;
            Query<DepartmentSummaryDTO> query = session
                    .createQuery(sql, DepartmentSummaryDTO.class);
            return query.list();
        }
    }
}
