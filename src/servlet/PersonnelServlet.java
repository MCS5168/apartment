package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entry.Personnel;
import service.PersonnelService;
import service.impl.PersonnelServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonnelServlet extends BaseServlet {

    PersonnelService personnelService = new PersonnelServiceImpl();

    protected void personnelMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        String id = req.getParameter("personnelId");
        int pageNum = Integer.valueOf(page);
        int pageSize = Integer.valueOf(limit);
        //起始页
        int startNum = (pageNum - 1) * pageSize;

        if (id != null) {
            //获取分页数据
            List<Personnel> userList = personnelService.queryPersonnelById(id);
            //获取总记录数
            Object count = personnelService.queryPersonnelCount(1);
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
            List<Personnel> userList = personnelService.queryPersonnelMessage(startNum, pageSize);
            //获取总记录数
            Object count = personnelService.queryPersonnelCount(1);
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

    protected void allPersonnel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Personnel> personnel = personnelService.queryAllPersonnel();
        req.setAttribute("personnel", personnel);
        req.getRequestDispatcher("/views/personnel/message.jsp").forward(req, resp);
    }

    protected void addPersonnel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Personnel per = WebUtils.copyParamToBean(req.getParameterMap(), new Personnel());
        int state = personnelService.addPersonnel(per.getPersonnelName(), per.getPersonnelAge(), per.getPersonnelPhone(),
                per.getPersonnelIdCard(), per.getPersonnelAddress(), per.getPersonnelArea());
    }

    protected void delPersonnel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("ID"));
        int state = personnelService.delPersonnel(id);
    }

    protected void editPersonnel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Personnel per = WebUtils.copyParamToBean(req.getParameterMap(), new Personnel());
        int personnelId = Integer.parseInt(req.getParameter("personnelId"));
        int state = personnelService.updatePersonnel(per.getPersonnelName(), per.getPersonnelAge(), per.getPersonnelPhone(),
                per.getPersonnelIdCard(), per.getPersonnelAddress(), per.getPersonnelArea(), personnelId);
    }
}
