package dao;

import entry.Student;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

public class StudentDao extends BaseDao {

    public List<Student> queryStudentMessage() {
        String sql = "select * from student";
        return queryForList(Student.class, sql);
    }

    public List<Student> queryStuMsgByName(String name) {
        String sql = "select * from student where name = ?";
        return queryForList(Student.class, sql, name);
    }

    public List<Student> queryStuMsgById(String studentId) {
        String sql = "select * from student where studentId = ?";
        return queryForList(Student.class, sql, studentId);
    }

    public List<Student> queryStuMsgByapartmentId(String apartmentId) {
        String sql = "select * from student where apartmentName = ?";
        return queryForList(Student.class, sql, apartmentId);
    }

    public int addStudent(String studentId, String name, String sex, String age, String phone, String apartmentId) {
        String sql = "insert into student values(null,?,?,?,?,?,?)";
        return update(sql, studentId, name, sex, age, phone, apartmentId);
    }

    public int delStudent(Integer studentNumber) {
        String sql = "delete from student where studentNumber = ?";
        return update(sql, studentNumber);
    }

    public Object queryStudentCount(int count) {
        String sql = "select count(?) from student";
        return queryForSingleValue(sql, count);
    }

    public int updateStudent(String studentId, String name, String sex, String age, String phone, String apartmentId, String studentNumber) {
        String sql = "update student set studentId = ?, name = ?, sex = ?, age = ?, phone = ?, apartmentName = ? where studentNumber = ?";
        return update(sql, studentId, name, sex, age, phone, apartmentId, studentNumber);
    }

    /*public List<Student> queryStudentById(String studentId) {
        String sql = "select * from student where studentId = ?";
        return queryForList(Student.class, sql, studentId);
    }*/
}
