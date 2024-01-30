package fa.training.dao;

import fa.training.entities.Student;


public interface StudentDao {
    void save(Student student);

    Student getById(Integer id);

    void update(Student student);

    void removeById(Integer id);
}
