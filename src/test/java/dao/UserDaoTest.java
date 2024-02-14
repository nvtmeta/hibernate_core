package dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import practice.dao.UserDao;
import practice.dao.impl.UserDaoImpl;
import practice.entity.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDaoTest {


    public static UserDao userDao;

    @BeforeAll
    public static void setUp() {
        userDao = new UserDaoImpl();
    }


    @Test
    public void testSaveUserSuccess() {
        User user = User.builder()
                .name("User 1")
                .build();
        System.out.println(user.toString());
        userDao.save(user);
    }

    @Test
    public void testGetUserSuccess() {
        User user = userDao.getById(1);
//        assertEquals("User 1", user.getName());
        System.out.println(user);
    }
}
