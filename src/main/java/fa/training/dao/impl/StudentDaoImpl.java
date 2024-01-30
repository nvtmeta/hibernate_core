package fa.training.dao.impl;

import fa.training.dao.StudentDao;
import fa.training.entities.Student;
import fa.training.utils.HibernateUtils;
import org.hibernate.Session;

public class StudentDaoImpl implements StudentDao {

    @Override
    public void save(Student student) {
        Session session = HibernateUtils.getCurrentSession();

        session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();

    }

    @Override
    public Student getById(Integer id) {
        Session session = HibernateUtils.getCurrentSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.getTransaction().commit();
        return student;
    }

    @Override
    public void update(Student student) {
        Session session = HibernateUtils.getCurrentSession();
        session.beginTransaction();
        session.merge(student);
        session.getTransaction().commit();
    }

    @Override
    public void removeById(Integer id) {
        Student student = getById(id);
        Session session = HibernateUtils.getCurrentSession();
        session.beginTransaction();
        session.remove(student);
        session.getTransaction().commit();
    }
}
