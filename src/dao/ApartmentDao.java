package dao;

import entry.Apartment;

import java.util.List;

public class ApartmentDao extends BaseDao {

    public List<Apartment> queryAllApartment() {
        String sql = "select * from apartment";
        return queryForList(Apartment.class, sql);
    }

    public List<Apartment> queryApartmentMessage(int startNum, int pageSize) {
        String sql = "select * from apartment limit ?,?";
        return queryForList(Apartment.class, sql, startNum, pageSize);
    }

    public Object queryApartmentCount(int count) {
        String sql = "select count(?) from apartment";
        return queryForSingleValue(sql, count);
    }

    public List<Apartment> queryAptmentById(String apartmentName) {
        String sql = "select * from apartment where apartmentName = ?";
        return queryForList(Apartment.class, sql, apartmentName);
    }

    public int addApartment(String apartmentName, Integer apartmentSize, String apartmentManager, String apartmentCharge, String apartmentNote) {
        String sql = "insert into apartment values(null,?,?,?,?,?)";
        return update(sql, apartmentName, apartmentSize, apartmentManager, apartmentCharge, apartmentNote);
    }

    public int delApartment(Integer apartmentId) {
        String sql = "delete from apartment where apartmentId = ?";
        return update(sql, apartmentId);
    }

    public int updateApartment(String apartmentName, Integer apartmentSize, String apartmentManager, String apartmentCharge, String apartmentNote, Integer apartmentId) {
        String sql = "update apartment set apartmentName = ?, apartmentSize = ?, apartmentManager = ?, apartmentCharge = ?, apartmentNote = ? where studentNumber = ?";
        return update(sql, apartmentName, apartmentSize, apartmentManager, apartmentCharge, apartmentNote, apartmentId);
    }
}
