package dao;

import fa.training.dao.ClazzDao;
import fa.training.dao.impl.ClazzDaoImpl;
import fa.training.entities.Clazz;
import fa.training.entities.Student;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClazzDaoTest {


    public static ClazzDao clazzDao;


    @BeforeAll
    public static void setUp() {
        clazzDao = new ClazzDaoImpl();
    }

    @Test
    @Order(1)
    public void testSaveClazzSuccess() {
        Clazz clazz = Clazz.builder()
                .name("Class 1")
                .build();
        System.out.println(clazz.toString());
        clazzDao.save(clazz);
        System.out.println(clazz.getId());

    }

    @Test
    @Order(2)
    public void testGetClazzSuccess() {
        Clazz clazz = clazzDao.getById(1);
        assertEquals("Class 1", clazz.getName());
        System.out.println(clazz);
    }

    @Test
    @Order(3)
    public void testGetStudentsByClassSuccess() {
        Clazz clazz = clazzDao.getById(1);
        List<Student> students = clazz.getStudents();
        System.out.println(clazz.toString());
        System.out.println(students);
        assertEquals(0, clazz.getStudents().size());
    }

}
