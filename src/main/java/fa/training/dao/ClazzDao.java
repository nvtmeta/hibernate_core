package fa.training.dao;

import fa.training.entities.Clazz;
import fa.training.entities.Student;

public interface ClazzDao {

    void save(Clazz clazz);

    Clazz getById(Integer id);

    void update(Clazz student);

    void removeById(Integer id);
}
