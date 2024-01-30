package fa.training;

import fa.training.dao.StudentDao;

/**
 * @author longnguyen on 27/01/2024
 * @product IntelliJ IDEA
 * @project Default (Template) Project
 */
public class Main {

    private final StudentDao studentDao;

    public Main(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void process(){
        studentDao.save(null);
    }

    public static void main(String[] args) {
    }
}