package service;

import entry.Cost;

import java.util.List;

public interface CostService {

    List<Cost> costMessage(int startNum, int pageSize);

    List<Cost> queryxAxis();

    List<Cost> queryWaterRate();

    List<Cost> queryElectricCharge();

    Object queryCostCount();
}
