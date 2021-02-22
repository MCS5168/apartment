package service;

import entry.Student;

import java.util.List;

public interface StudentService {

    List<Student> queryStudentMessage();

    List<Student> queryStuMsgByName(String name);

    List<Student> queryStuMsgById(String studentId);

    List<Student> queryStuMsgByapartmentId(String apartmentId);

    int addStudent(String studentId, String name, String sex, String age, String phone, String apartmentId);

    int delStudent(Integer studentNumber);

    Object queryStudentCount(int count);

    int updateStudent(String studentId, String name, String sex, String age, String phone, String apartmentId, String studentNumber);
}
