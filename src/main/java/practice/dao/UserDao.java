package practice.dao;

import org.hibernate.Session;
import practice.entity.User;

import java.util.List;

public interface UserDao {

    void save(User user);

    User getById(Integer id);

    void update(User user);

    void removeById(Integer id);


    List<User> getAll();


}
