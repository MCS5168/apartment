package servlet;

import entry.Student;
import service.StudentService;
import service.impl.StudnetServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentServlet extends BaseServlet {

    StudentService studentService = new StudnetServiceImpl();

    private static final long serialVersionUID = 1L;

    protected void studentMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> student = studentService.queryStudentMessage();
        req.setAttribute("student", student);
        req.getRequestDispatcher("/views/student/message.jsp").forward(req, resp);
    }

    protected void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = WebUtils.copyParamToBean(req.getParameterMap(), new Student());
        int state = studentService.addStudent(student.getStudentId(), student.getName(), student.getSex(),
                String.valueOf(student.getAge()), student.getPhone(), student.getApartmentId());
        if (state == -1) {
            System.out.println("添加失败");
        } else {
            System.out.println("添加成功");
        }
    }

    protected void delStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("ID"));
        int state = studentService.delStudent(id);
        if (state == -1) {
            System.out.println("删除失败");
        } else {
            System.out.println("删除成功");
        }
    }

    protected void editStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = WebUtils.copyParamToBean(req.getParameterMap(), new Student());
        String studentNumber = req.getParameter("studentNumber");
        int state = studentService.updateStudent(student.getStudentId(), student.getName(), student.getSex(),
                String.valueOf(student.getAge()), student.getPhone(), student.getApartmentId(),studentNumber);
        if (state == -1) {
            System.out.println("修改失败");
        } else {
            System.out.println("修改成功");
        }
    }

    protected void queryStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = WebUtils.copyParamToBean(req.getParameterMap(), new Student());
    }
}
