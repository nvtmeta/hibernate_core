package fa.training.dao.impl;

import fa.training.dao.ClazzDao;
import fa.training.entities.Clazz;
import fa.training.entities.Student;
import fa.training.utils.HibernateUtils;
import org.hibernate.Session;

public class ClazzDaoImpl implements ClazzDao {

    @Override
    public void save(Clazz clazz) {
        Session session = HibernateUtils.getCurrentSession();

        session.beginTransaction();
        session.persist(clazz);
        session.getTransaction().commit();
    }

    @Override
    public Clazz getById(Integer id) {
        Session session = HibernateUtils.getCurrentSession();
        session.beginTransaction();
        Clazz clazz = session.get(Clazz.class, id);
        clazz.getStudents().size();
        session.getTransaction().commit();
        return clazz;
    }

    @Override
    public void update(Clazz clazz) {
        Session session = HibernateUtils.getCurrentSession();
        session.beginTransaction();
        session.merge(clazz);
        session.getTransaction().commit();
    }

    @Override
    public void removeById(Integer id) {
        Clazz clazz = getById(id);
        Session session = HibernateUtils.getCurrentSession();
        session.beginTransaction();
        session.remove(clazz);
        session.getTransaction().commit();
    }

}
