package service;

import entry.Personnel;

import java.util.List;

public interface PersonnelService {

    List<Personnel> queryAllPersonnel();

    List<Personnel> queryPersonnelMessage(int startNum, int pageSize);

    Object queryPersonnelCount(int count);

    List<Personnel> queryPersonnelById(String apartmentName);

    int addPersonnel(String personnelName, String personnelAge, String personnelPhone,
                     String personnelIdCard, String personnelAddress, String personnelArea);

    int delPersonnel(Integer personnelId);

    int updatePersonnel(String personnelName, String personnelAge, String personnelPhone,
                        String personnelIdCard, String personnelAddress, String personnelArea, Integer personnelId);
}
