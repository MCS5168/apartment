package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.StudentService;
import service.impl.StudnetServiceImpl;


public class TestServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        try {
            StudentService studentService = new StudnetServiceImpl();
            Object count = studentService.queryStudentCount(1);
//            Object count1 = studentService.queryStudentCount();

            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/apartment?useSSL=false", "root", "root");
            Statement stmt = connect.createStatement(); //创建Statement对象
            String sql;
            JSONObject jsonmain = new JSONObject();
            jsonmain.put("code", "200");
            jsonmain.put("msg", "none");
            JSONArray jsonarray = new JSONArray();
            JSONObject jsonobj = new JSONObject();

            String id = request.getParameter("studentId");

            String page = request.getParameter("page");
            String limit = request.getParameter("limit");
            int pageNum = Integer.valueOf(page);
            int pageSize = Integer.valueOf(limit);
            int startNum = (pageNum - 1) * pageSize;

            System.out.println(startNum + "分页数据" + pageSize);

//            String id = "17330120617";
            System.out.println(id);
            if (id == null) {
                sql = "SELECT * FROM student limit " + startNum + "," + pageSize + "";
                ResultSet rs = stmt.executeQuery(sql);
                // 展开结果集数据库
                while (rs.next()) {
                    // 通过字段检索
                    jsonmain.put("count", count);
                    jsonobj.put("number", rs.getString("studentNumber"));
                    jsonobj.put("id", rs.getString("studentId"));
                    jsonobj.put("name", rs.getString("name"));
                    jsonobj.put("sex", rs.getString("sex"));
                    jsonobj.put("age", rs.getString("age"));
                    jsonobj.put("phone", rs.getString("phone"));
                    jsonobj.put("apartmentId", rs.getString("apartmentName"));

                    jsonarray.add(jsonobj);
                }
                // 输出数据
                jsonmain.put("data", jsonarray);
                out.println(jsonmain);
                // 完成后关闭
                rs.close();
                stmt.close();
                connect.close();
            } else {
                System.out.println(id);
                sql = "SELECT * FROM student where studentId = '" + id + "'";
                ResultSet rs = stmt.executeQuery(sql);
                // 展开结果集数据库
                while (rs.next()) {
                    // 通过字段检索
                    jsonmain.put("count", 1);
                    jsonobj.put("number", rs.getString("studentNumber"));
                    jsonobj.put("id", rs.getString("studentId"));
                    jsonobj.put("name", rs.getString("name"));
                    jsonobj.put("sex", rs.getString("sex"));
                    jsonobj.put("age", rs.getString("age"));
                    jsonobj.put("phone", rs.getString("phone"));
                    jsonobj.put("apartmentId", rs.getString("apartmentName"));

                    jsonarray.add(jsonobj);
                }
                // 输出数据
                jsonmain.put("data", jsonarray);
                out.println(jsonmain);
                // 完成后关闭
                rs.close();
                stmt.close();
                connect.close();
            }
        } catch (Exception e) {
            out.print("get data error!");
            e.printStackTrace();
        }

    }

}