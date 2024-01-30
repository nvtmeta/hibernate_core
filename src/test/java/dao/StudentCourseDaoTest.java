package dao;

import fa.training.dao.StudentCourseDao;
import fa.training.dao.impl.StudentCourseDaoImpl;
import fa.training.entities.Course;
import fa.training.entities.Student;
import fa.training.entities.StudentCourse;
import fa.training.entities.StudentCourseKey;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StudentCourseDaoTest {

    public static StudentCourseDao studentCourseDao;

    @BeforeAll
    public static void setUp() {
        studentCourseDao = new StudentCourseDaoImpl();
    }

    @Test
    public void testSaveStudentCourseSuccess() {

        Student student = Student.builder()
                .id(1).build();

        Course course = Course.builder()
                .id(1).build();

        StudentCourse studentCourse = StudentCourse.builder()
                .studentCourseKey(new StudentCourseKey(student.getId(), course.getId()))
                .score(10f)
                .level(1)
                .course(course)
                .student(student)
                .build();

        studentCourseDao.save(studentCourse);
    }
}
