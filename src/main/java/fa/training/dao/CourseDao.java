package fa.training.dao;

import fa.training.entities.Clazz;
import fa.training.entities.Course;

public interface CourseDao {

    void save(Course clazz);

    Course getById(Integer id);
}
