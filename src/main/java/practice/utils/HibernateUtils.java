package practice.utils;

import lombok.Getter;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    @Getter
    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public static Session openSession(){
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        getSessionFactory();
    }
}
