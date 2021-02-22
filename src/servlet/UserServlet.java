package servlet;

import entry.User;
import service.ApartmentService;
import service.StudentService;
import service.UserService;
import service.impl.ApartmentServiceImpl;
import service.impl.StudnetServiceImpl;
import service.impl.UserServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    StudentService studentService = new StudnetServiceImpl();

    ApartmentService apartmentService = new ApartmentServiceImpl();

    User user = new User();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("userName");
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        User loginUser = userService.login(user);
        if (loginUser != null) {
            System.out.println("登录成功");
            HttpSession session = req.getSession();
            session.setAttribute("user", loginUser);
//            req.setAttribute("username", user.getUserName());
            req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
        } else {
            System.out.println("登录失败");
            req.setAttribute("msg", "用户名或密码错误！");
            req.setAttribute("username", username);
            req.setAttribute("user", loginUser);
            req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        String code = req.getParameter("vercode");
        String username = req.getParameter("userName");
        String password = req.getParameter("userPassword");
        System.out.println(username + "+++" + password);
        if (token != null && token.equalsIgnoreCase(code)) {
            //检查用户名是否可用
            if (userService.existsUserName(username)) {
                //用户已存在,返回注册页面
                req.setAttribute("msg", "用户名已存在！");
                req.getRequestDispatcher("/views/user/regist.jsp").forward(req, resp);
            } else {
                //用户名可用,注册成功
                userService.registUser(new User(null, username, password));
                //返回登录页面
                System.out.println("注册成功");
                req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("msg", "验证码错误！");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/views/user/regist.jsp").forward(req, resp);
        }


    }

    protected void console(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object studentCount = studentService.queryStudentCount(1);
        Object apartmentCount = apartmentService.queryApartmentCount(1);
        req.setAttribute("studentCount", studentCount);
        req.setAttribute("apartmentCount", apartmentCount);
        req.getRequestDispatcher("/views/home/homepage2.jsp").forward(req, resp);
    }

    protected void studentMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/StudentServlet/studentMessage");
    }

    protected void queryPassowrdByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/user/password.jsp").forward(req, resp);
    }

    protected void modifyPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        System.out.println(password);

        String username = req.getParameter("username");
        System.out.println(username);

        String password1 = req.getParameter("oldPassword");
        System.out.println(password1);

        String password2 = req.getParameter("newpassword");
        System.out.println(password2);

        String password3 = req.getParameter("repassword");
        System.out.println(password3);

        if (!password.equals(password1)) {
            req.setAttribute("msg", "旧密码错误！");
            req.getRequestDispatcher("/views/user/password.jsp").forward(req, resp);
        } else {
            int state = userService.modifyPassword(password3, username);
            System.out.println(state);
//            req.getRequestDispatcher("/UserServlet/login").forward(req, resp);
            req.getRequestDispatcher("/views/home/homepage2.jsp").forward(req, resp);
        }

    }
}


