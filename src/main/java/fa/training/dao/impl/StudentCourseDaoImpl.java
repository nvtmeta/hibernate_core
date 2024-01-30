package fa.training.dao.impl;

import fa.training.dao.StudentCourseDao;
import fa.training.entities.StudentCourse;
import fa.training.entities.StudentCourseKey;
import fa.training.utils.HibernateUtils;
import org.hibernate.Session;

public class StudentCourseDaoImpl implements StudentCourseDao {
    @Override
    public void save(StudentCourse studentCourse) {
        Session session = HibernateUtils.getCurrentSession();

        session.beginTransaction();
        session.persist(studentCourse);
        session.getTransaction().commit();

    }



    @Override
    public StudentCourse getById(StudentCourseKey id) {
        Session session = HibernateUtils.getCurrentSession();
        session.beginTransaction();
        StudentCourse studentCourse = session.get(StudentCourse.class, id);
        session.getTransaction().commit();
        return studentCourse;
    }
}
