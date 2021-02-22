package service.impl;

import dao.PersonnelDao;
import entry.Personnel;
import service.PersonnelService;

import java.util.List;

public class PersonnelServiceImpl implements PersonnelService {

    PersonnelDao personnelDao = new PersonnelDao();

    @Override
    public List<Personnel> queryAllPersonnel() {
        return personnelDao.queryAllPersonnel();
    }

    @Override
    public List<Personnel> queryPersonnelMessage(int startNum, int pageSize) {
        return personnelDao.queryPersonnelMessage(startNum, pageSize);
    }

    @Override
    public Object queryPersonnelCount(int count) {
        return personnelDao.queryPersonnelCount(count);
    }

    @Override
    public List<Personnel> queryPersonnelById(String apartmentName) {
        return personnelDao.queryPersonnelById(apartmentName);
    }

    @Override
    public int addPersonnel(String personnelName, String personnelAge, String personnelPhone,
                            String personnelIdCard, String personnelAddress, String personnelArea) {
        return personnelDao.addPersonnel(personnelName, personnelAge, personnelPhone, personnelIdCard, personnelAddress, personnelArea);
    }

    @Override
    public int delPersonnel(Integer personnelId) {
        return personnelDao.delPersonnel(personnelId);
    }

    @Override
    public int updatePersonnel(String personnelName, String personnelAge, String personnelPhone,
                               String personnelIdCard, String personnelAddress, String personnelArea, Integer personnelId) {
        return personnelDao.updatePersonnel(personnelName, personnelAge, personnelPhone, personnelIdCard, personnelAddress, personnelArea, personnelId);
    }
}
