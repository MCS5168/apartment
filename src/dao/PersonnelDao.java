package dao;

import entry.Personnel;

import java.util.List;

public class PersonnelDao extends BaseDao {

    public List<Personnel> queryAllPersonnel() {
        String sql = "select * from apartmentPersonnel";
        return queryForList(Personnel.class, sql);
    }

    public List<Personnel> queryPersonnelMessage(int startNum, int pageSize) {
        String sql = "select * from apartmentPersonnel limit ?,?";
        return queryForList(Personnel.class, sql, startNum, pageSize);
    }

    public Object queryPersonnelCount(int count) {
        String sql = "select count(?) from apartmentPersonnel";
        return queryForSingleValue(sql, count);
    }

    public List<Personnel> queryPersonnelById(String apartmentName) {
        String sql = "select * from apartmentPersonnel where personnelName = ?";
        return queryForList(Personnel.class, sql, apartmentName);
    }

    public int addPersonnel(String personnelName, String personnelAge, String personnelPhone,
                            String personnelIdCard, String personnelAddress, String personnelArea) {
        String sql = "insert into apartmentPersonnel values(null,?,?,?,?,?,?)";
        return update(sql, personnelName, personnelAge, personnelPhone, personnelIdCard, personnelAddress, personnelArea);
    }

    public int delPersonnel(Integer personnelId) {
        String sql = "delete from apartmentPersonnel where personnelId = ?";
        return update(sql, personnelId);
    }

    public int updatePersonnel(String personnelName, String personnelAge, String personnelPhone,
                               String personnelIdCard, String personnelAddress, String personnelArea, Integer personnelId) {
        String sql = "update apartmentPersonnel set personnelName = ?, personnelAge = ?, personnelPhone = ?, personnelIdCard = ?, personnelAddress = ?, personnelArea = ? where personnelId = ?";
        return update(sql, personnelName, personnelAge, personnelPhone, personnelIdCard, personnelAddress, personnelArea, personnelId);
    }
}
