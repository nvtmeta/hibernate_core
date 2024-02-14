package practice.dao.impl;

import org.hibernate.Session;
import practice.dao.UserDao;
import practice.entity.User;
import practice.utils.HibernateUtils;

import java.util.List;

public class UserDaoImpl implements UserDao {


    @Override
    public void save(User user) {
        Session session = HibernateUtils.getCurrentSession();

        session.beginTransaction();

        session.persist(user);

        session.getTransaction().commit();

        session.close();

    }

    @Override
    public User getById(Integer id) {
        Session session = HibernateUtils.getCurrentSession();

        session.beginTransaction();

        User user = session.get(User.class, id);

        session.getTransaction().commit();

        return user;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void removeById(Integer id) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
