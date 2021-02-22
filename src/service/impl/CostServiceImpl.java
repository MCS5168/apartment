package service.impl;

import dao.CostDao;
import entry.Cost;
import service.CostService;

import java.util.List;

public class CostServiceImpl implements CostService {

    CostDao costDao = new CostDao();

    @Override
    public List<Cost> queryxAxis() {
        return costDao.queryxAxis();
    }

    @Override
    public List<Cost> queryWaterRate() {
        return costDao.queryWaterRate();
    }

    @Override
    public List<Cost> queryElectricCharge() {
        return costDao.queryElectricCharge();
    }

    @Override
    public List<Cost> costMessage(int startNum, int pageSize) {
        return costDao.costMessage(startNum, pageSize);
    }

    @Override
    public Object queryCostCount() {
        return costDao.queryCostCount();
    }
}
