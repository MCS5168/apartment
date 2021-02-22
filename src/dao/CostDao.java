package dao;

import entry.Cost;

import java.util.List;

public class CostDao extends BaseDao {

    public List<Cost> costMessage(int startNum, int pageSize) {
        String sql = "select * from apartmentcost limit ?,?";
        return queryForList(Cost.class, sql, startNum, pageSize);
    }

    public List<Cost> queryxAxis() {
        String sql = "select apartmentName from apartmentcost";
        return queryForList(Cost.class, sql);
    }

    public List<Cost> queryWaterRate() {
        String sql = "select waterRate from apartmentcost";
        return queryForList(Cost.class, sql);
    }

    public List<Cost> queryElectricCharge() {
        String sql = "select electricCharge from apartmentcost";
        return queryForList(Cost.class, sql);
    }

    public Object queryCostCount() {
        String sql = "select count(*) from apartment";
        return queryForSingleValue(sql);
    }
}
