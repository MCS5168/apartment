package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entry.Cost;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import service.CostService;
import service.impl.CostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CostServlet extends BaseServlet {

    CostService costService = new CostServiceImpl();

    protected void costMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取请求参数
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        int pageNum = Integer.valueOf(page);
        int pageSize = Integer.valueOf(limit);
        //起始页
        int startNum = (pageNum - 1) * pageSize;

        //获取分页数据
        List<Cost> userList = costService.costMessage(startNum, pageSize);
        //获取总记录数
        Object count = costService.queryCostCount();
        System.out.println(count);
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

    protected void disciplineMessage2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Cost> xAxis = costService.queryxAxis();
        List<Cost> waterRate = costService.queryWaterRate();
        List<Cost> electricCharge = costService.queryElectricCharge();

        String[] xAxisArr = new String[xAxis.size()];
        for (int i = 0; i < xAxis.size(); i++) {
            xAxisArr[i] = xAxis.get(i).getApartmentName();
        }

        int[] waterRateArr = new int[waterRate.size()];
        for (int i = 0; i < waterRate.size(); i++) {
            waterRateArr[i] = Integer.parseInt(waterRate.get(i).getWaterRate());
        }

        int[] electricChargeArr = new int[electricCharge.size()];
        for (int i = 0; i < electricCharge.size(); i++) {
            electricChargeArr[i] = Integer.parseInt(electricCharge.get(i).getElectricCharge());
        }

        JSONObject json = new JSONObject();
        try {
            json.put("xAxisArr", xAxisArr);
            json.put("waterRateArr", waterRateArr);
            json.put("electricChargeArr", electricChargeArr);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (json != null) {
            PrintWriter writer = resp.getWriter();
            writer.write(json.toString());
            writer.flush();
            writer.close();
        } else {
            resp.getWriter().print(1);
        }
    }
}
