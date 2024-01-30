package fa.training.utils;

import fa.training.entities.Student;
import jakarta.transaction.Transactional;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * @author longnguyen on 27/01/2024
 * @product IntelliJ IDEA
 * @project orm_demo
 */
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
