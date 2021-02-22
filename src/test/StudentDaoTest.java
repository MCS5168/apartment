package test;

import dao.StudentDao;
import entry.Student;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoTest extends StudentDao {
    StudentDao studentDao = new StudentDao();

    @Test
    public void testQueryStudentMessage() {
        List<Student> students = studentDao.queryStudentMessage();
        for (Student s : students) {
            System.out.println(s);
        }
    }

    @Test
    public void testAddStudent() {
        int state = studentDao.addStudent("17310128577", "李四", "男", "22", "17716471173", "D9-1075");
        System.out.println(state);
        if (state == -1) {
            System.out.println("添加失败");
        } else {
            System.out.println("添加成功");
        }
    }

    @Test
    public void testdelStudent() {
        int state = studentDao.delStudent(11);
        System.out.println(state);
        if (state == -1) {
            System.out.println("添加失败");
        } else {
            System.out.println("添加成功");
        }
    }

    @Test
    public void testQueryStudentCount() {
        Object o = studentDao.queryStudentCount(1);
        System.out.println(o);
    }
}