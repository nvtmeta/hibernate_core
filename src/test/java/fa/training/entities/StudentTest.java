package fa.training.entities;

import fa.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author longnguyen on 27/01/2024
 * @product IntelliJ IDEA
 * @project orm_demo
 */
public class StudentTest {

    @Test
    public void testSave(){
        Student student = new Student();
        student.setName("Hoang");
        student.setGpa(BigDecimal.valueOf(5.0));
        student.setRemark("Goood");

        Student student2 = new Student();
        student2.setName("Thai");
        student2.setGpa(BigDecimal.valueOf(5.0));
        student2.setRemark("Goood");


        //== Hibernate data process

        //Step 1: Create Session
        Session session = HibernateUtils.getCurrentSession();
        //Step 2: Create transaction
        session.beginTransaction();

        //Step 3: Perform session method -> various (CRUD)
        //Method need active transaction to perform

        //ORM: Object-relational-mapping => Record linked Object
        //ORM: Manage entity states -> session method -> change entity states

        //STUDENT STATE IS TRANSITENT: chưa từng được map (link) tới database
        System.out.println("Before save student: " + student);

        //persist: Set entity state is persistent (chuyển trạng của student từ transient sang persistent)
        session.persist(student); //STUDENT STATE IS PERSISTENT: object linked with record, any change on object will afftected to record

        System.out.println("After save student: " + student); //also have generated id
//        session.evict(student);   //STUDENT STATE IS DETACHED: object no longer linked with record
//        session.update(student); //Translate detached to persistent
//
//        student.setName("Tututu"); //dirty checking, also update name of record in db

        //Step 4.1: Commit transaction
        session.getTransaction().commit();
        //Step 5: Close session (maybe close automatically)
        session.close();

        //STUDENT STATE IS DETACHED: object no longer linked with record
        student.setName("Hehe");

        //=============================
    }

    @Test
    public void testMerge(){
        Session session = HibernateUtils.getCurrentSession();
        session.beginTransaction();

        //inline construct
        Student student = Student.builder()
                                .name("Long")
                                .gpa(BigDecimal.TEN)
                                .remark("Gooddd")
                                .build();
        session.merge(student);

        session.getTransaction().commit();
    }

    @Test
    public void testGet(){
        Session session = HibernateUtils.getCurrentSession();
        session.beginTransaction();

        //Get persistent object by class and id
        Student student = session.get(Student.class, 18);

        session.getTransaction().commit();
    }
}
