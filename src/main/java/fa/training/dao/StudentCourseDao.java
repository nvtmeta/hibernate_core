package fa.training.dao;

import fa.training.entities.Course;
import fa.training.entities.StudentCourse;
import fa.training.entities.StudentCourseKey;

public interface StudentCourseDao {

    void save(StudentCourse clazz);

    StudentCourse getById(StudentCourseKey id);
}
