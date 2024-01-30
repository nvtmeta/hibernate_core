package fa.training.dao.impl;

import fa.training.dao.CourseDao;
import fa.training.entities.Course;
import fa.training.entities.Student;
import fa.training.utils.HibernateUtils;
import org.hibernate.Session;

public class CourseDaoImpl implements CourseDao {

    @Override
    public void save(Course course) {
        Session session = HibernateUtils.getCurrentSession();

        session.beginTransaction();
        session.persist(course);
        session.getTransaction().commit();

    }

    @Override
    public Course getById(Integer id) {
        Session session = HibernateUtils.getCurrentSession();
        session.beginTransaction();
        Course course = session.get(Course.class, id);
        session.getTransaction().commit();
        return course;
    }
}
