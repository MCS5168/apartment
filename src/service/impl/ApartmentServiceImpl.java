package service.impl;

import dao.ApartmentDao;
import entry.Apartment;
import service.ApartmentService;

import java.util.List;

public class ApartmentServiceImpl implements ApartmentService {

    ApartmentDao apartmentDao = new ApartmentDao();

    @Override
    public List<Apartment> queryApartmentMessage(int startNum, int pageSize) {
        return apartmentDao.queryApartmentMessage(startNum, pageSize);
    }

    @Override
    public Object queryApartmentCount(int count) {
        return apartmentDao.queryApartmentCount(count);
    }

    @Override
    public List<Apartment> queryAllApartment() {
        return apartmentDao.queryAllApartment();
    }

    @Override
    public List<Apartment> queryAptmentById(String apartmentName) {
        return apartmentDao.queryAptmentById(apartmentName);
    }

    @Override
    public int addApartment(String apartmentName, Integer apartmentSize, String apartmentManager, String apartmentCharge, String apartmentNote) {
        return apartmentDao.addApartment(apartmentName, apartmentSize, apartmentManager, apartmentCharge, apartmentNote);
    }

    @Override
    public int delApartment(Integer apartmentId) {
        return apartmentDao.delApartment(apartmentId);
    }

    @Override
    public int updateApartment(String apartmentName, Integer apartmentSize, String apartmentManager, String apartmentCharge, String apartmentNote, Integer apartmentId) {
        return apartmentDao.updateApartment(apartmentName, apartmentSize, apartmentManager, apartmentCharge, apartmentNote, apartmentId);
    }
}
