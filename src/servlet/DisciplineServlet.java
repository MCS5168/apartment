package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entry.Discipline;
import service.DisciplineService;
import service.impl.DisciplineServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisciplineServlet extends BaseServlet {

    DisciplineService disciplineService = new DisciplineServiceImpl();

    protected void disciplineMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        String id = req.getParameter("disciplineId");
        int pageNum = Integer.valueOf(page);
        int pageSize = Integer.valueOf(limit);
        //起始页
        int startNum = (pageNum - 1) * pageSize;

        if (id != null) {
            //获取分页数据
            List<Discipline> userList = disciplineService.queryDisciplineById(id);
            //获取总记录数
            Object count = disciplineService.queryDisciplineCount(1);
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
            List<Discipline> userList = disciplineService.queryDisciplineMessage(startNum, pageSize);
            //获取总记录数
            Object count = disciplineService.queryDisciplineCount(1);
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

    protected void allDiscipline(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Discipline> discipline = disciplineService.queryAllDiscipline();
        req.setAttribute("discipline", discipline);
        req.getRequestDispatcher("/views/discipline/message.jsp").forward(req, resp);
    }

    protected void addDiscipline(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Discipline dis = WebUtils.copyParamToBean(req.getParameterMap(), new Discipline());
        int state = disciplineService.addDiscipline(dis.getStudentId(), dis.getStudentName(), dis.getDisciplineDate(),
                dis.getDisciplineDetail(), dis.getDisciplineAgent());
    }

    protected void delDiscipline(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("ID"));
        int state = disciplineService.delDiscipline(id);
    }

    protected void editDiscipline(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Discipline dis = WebUtils.copyParamToBean(req.getParameterMap(), new Discipline());
        int personnelId = Integer.parseInt(req.getParameter("disciplineId"));
        int state = disciplineService.updateDiscipline(dis.getStudentId(), dis.getStudentName(),
                dis.getDisciplineDate(), dis.getDisciplineDetail(), dis.getDisciplineAgent(), personnelId);
    }
}
