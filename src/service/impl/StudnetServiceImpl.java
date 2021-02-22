package service.impl;

import dao.StudentDao;
import entry.Student;
import service.StudentService;

import java.util.List;

public class StudnetServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDao();

    @Override
    public List<Student> queryStudentMessage() {
        return studentDao.queryStudentMessage();
    }

    @Override
    public List<Student> queryStuMsgByName(String name) {
        return studentDao.queryStuMsgByName(name);
    }

    @Override
    public List<Student> queryStuMsgById(String studentId) {
        return studentDao.queryStuMsgById(studentId);
    }

    @Override
    public List<Student> queryStuMsgByapartmentId(String apartmentId) {
        return studentDao.queryStuMsgByapartmentId(apartmentId);
    }

    @Override
    public int addStudent(String studentId, String name, String sex, String age, String phone, String apartmentId) {
        return studentDao.addStudent(studentId, name, sex, age, phone, apartmentId);
    }

    @Override
    public int delStudent(Integer studentNumber) {
        return studentDao.delStudent(studentNumber);
    }

    @Override
    public Object queryStudentCount(int count) {
        return studentDao.queryStudentCount(count);
    }

    @Override
    public int updateStudent(String studentId, String name, String sex, String age, String phone, String apartmentId, String studentNumber) {
        return studentDao.updateStudent(studentId, name, sex, age, phone, apartmentId, studentNumber);
    }
}
