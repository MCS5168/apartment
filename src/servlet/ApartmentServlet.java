package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entry.Apartment;
import service.ApartmentService;
import service.impl.ApartmentServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApartmentServlet extends BaseServlet {

    ApartmentService apartmentService = new ApartmentServiceImpl();

    protected void apartmentMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        String id = req.getParameter("apartmentId");
        int pageNum = Integer.valueOf(page);
        int pageSize = Integer.valueOf(limit);
        //起始页
        int startNum = (pageNum - 1) * pageSize;

        if (id != null) {
            //获取分页数据
            List<Apartment> userList = apartmentService.queryAptmentById(id);
            //获取总记录数
            Object count = apartmentService.queryApartmentCount(1);
            //封装返回数据
            Map<String, Object> result = new HashMap<>();
            result.put("code", "200");
            result.put("msg", "none");
            result.put("data", userList);
            result.put("count", count);
            //使用JackSon将数据转换成JSON字符串 响应回去
            ObjectMapper om = new ObjectMapper();
            String rs = om.writeValueAsString(result);
            //处理响应乱码
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println(rs);
        } else {
            //获取分页数据
            List<Apartment> userList = apartmentService.queryApartmentMessage(startNum, pageSize);
            //获取总记录数
            Object count = apartmentService.queryApartmentCount(1);
            //封装返回数据
            Map<String, Object> result = new HashMap<>();
            result.put("code", "200");
            result.put("msg", "none");
            result.put("data", userList);
            result.put("count", count);
            //使用JackSon将数据转换成JSON字符串 响应回去
            ObjectMapper om = new ObjectMapper();
            String rs = om.writeValueAsString(result);
            //处理响应乱码
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println(rs);
        }
    }

    protected void allApartment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Apartment> apartment = apartmentService.queryAllApartment();
        req.setAttribute("apartment", apartment);
        req.getRequestDispatcher("/views/apartment/message.jsp").forward(req, resp);
    }

    protected void addApartment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Apartment apt = WebUtils.copyParamToBean(req.getParameterMap(), new Apartment());
        int state = apartmentService.addApartment(apt.getApartmentName(),apt.getApartmentSize(),
                apt.getApartmentManager(),apt.getApartmentCharge(),apt.getApartmentNote());
        if (state == -1) {
            System.out.println("添加失败");
        } else {
            System.out.println("添加成功");
        }
    }

    protected void delApartment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("ID"));
        int state = apartmentService.delApartment(id);
        if (state == -1) {
            System.out.println("删除失败");
        } else {
            System.out.println("删除成功");
        }
    }

    protected void editApartment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Apartment apt = WebUtils.copyParamToBean(req.getParameterMap(), new Apartment());
        int apartmentId = Integer.parseInt(req.getParameter("apartmentId"));
        int state = apartmentService.updateApartment(apt.getApartmentName(),apt.getApartmentSize(),
                apt.getApartmentManager(), apt.getApartmentCharge(),apt.getApartmentNote(),apartmentId);
        if (state == -1) {
            System.out.println("修改失败");
        } else {
            System.out.println("修改成功");
        }
    }
}
