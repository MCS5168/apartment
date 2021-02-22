package test;

import dao.CostDao;
import entry.Cost;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CostDaoTest extends CostDao {

    CostDao costDao = new CostDao();

    @Test
    public void test1(){
        List<Cost> costs = costDao.queryxAxis();
        List<Cost> costs2 = costDao.queryWaterRate();
        List<Cost> costs3 = costDao.queryElectricCharge();

        String[] xAxisArr = new String[costs.size()];

        for (int i = 0; i < costs.size(); i++) {
            xAxisArr[i] = (String)costs.get(i).getApartmentName();
        }
        for (String str : xAxisArr){
            System.out.println(str);
        }














    }

}