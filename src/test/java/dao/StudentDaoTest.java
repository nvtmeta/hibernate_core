package dao;

import fa.training.dao.ClazzDao;
import fa.training.dao.StudentDao;
import fa.training.dao.impl.ClazzDaoImpl;
import fa.training.dao.impl.StudentDaoImpl;
import fa.training.entities.Clazz;
import fa.training.entities.Student;
import org.junit.jupiter.api.*;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentDaoTest {

    private static StudentDao studentDao;
    private static ClazzDao clazzDao;

    @BeforeAll
    public static void setUp() {
        studentDao = new StudentDaoImpl();
        clazzDao = new ClazzDaoImpl();
        Integer studentIdTest = 2;
    }


    @Test
    @Order(1)
    public void testSaveStudentSuccess() {

        Student student = Student.builder().name("Long Nguyen")
                .gpa(new BigDecimal("9.5")).remark("Good")
                .dob(LocalDate.of(2000, 1, 1)).build();

        System.out.println(student.toString());
        studentDao.save(student);
        Assertions.assertNotNull(student);
        System.out.println(student.getId());
    }


    @Test
    @Order(2)
    public void testSaveStudentByIdSuccess() {
        Student student = studentDao.getById(12);
        System.out.println(student.toString());
        assertAll(() -> Assertions.assertNotNull(student),
                () -> Assertions.assertEquals("Long Nguyen", student.getName()),
                () -> Assertions.assertEquals(new BigDecimal("9.50"), student.getGpa()));
    }


    @Test
    @Order(3)
    public void testUpdateStudentSuccess() {
        Student student = studentDao.getById(12);
        student.setName("java Nguyen");
        student.setRemark("java");
        System.out.println(student.toString());

        studentDao.update(student);

        assertEquals("java Nguyen", student.getName());
        assertEquals("java", student.getRemark());
    }

    @Test
    @Order(4)
    @Disabled
    public void testRemoveStudentSuccess() {
        Student student = studentDao.getById(12);
        System.out.println(student.toString());
        studentDao.removeById(student.getId());
    }

    @Test
    @Order(5)
    public void testUpdateClassIdOfStudentSuccess() {
        Student student = studentDao.getById(2);

        System.out.println(student.toString());


        Clazz clazz = clazzDao.getById(1);

        System.out.println(clazz.toString());
        student.setClazz(clazz);
        student.setRemark("java");
        studentDao.update(student);

//        assertEquals(1, student.getClazz().getId());
    }

    @Test
    @Order(6)
    public void testGetClassByStudentSuccess() {
        Clazz clazz = studentDao.getById(9).getClazz();
        assertEquals(9, clazz.getId());
    }


    @Test
    @Order(7)
    public void testSaveClassAlsoSaveStudentSuccess() {
        Clazz clazz = Clazz.builder().name("python").build();

        Student student1 = Student.builder().name("Long Nguyen")
                .gpa(new BigDecimal("9.5")).remark("Good")
                .dob(LocalDate.of(2000, 1, 1)
                )
                .build();
        student1.setClazz(clazz);

        Student student2 = Student.builder().name("Dung Nguyen").gpa(new BigDecimal("9.5")).remark("Good").dob(LocalDate.of(2000, 1, 1)).build();
        student2.setClazz(clazz);

        Student student3 = Student.builder().name(" Hai Nguyen").gpa(new BigDecimal("9.5")).remark("Good").dob(LocalDate.of(2000, 1, 1)).build();
        student3.setClazz(clazz);

        List<Student> students = List.of(student1, student2, student3);

        clazz.setStudents(students);
        clazzDao.save(clazz);

    }

    @Test
    @Order(8)
    public void testUpdateClassAlsoSaveStudentSuccess() {
        Clazz clazz = clazzDao.getById(9);
        List<Student> students = clazz.getStudents();

        clazz.setName("java");
        students.forEach(student -> student.setName(student.getName().toUpperCase()));

        clazz.setStudents(students);

        clazzDao.update(clazz);
    }

    @Test
    @Order(9)
    public void testRemoveClassAlsoSaveStudentSuccess() {
        Clazz clazz = clazzDao.getById(9);
        clazzDao.removeById(clazz.getId());
    }

}


