package service;

import entry.Apartment;

import java.util.List;

public interface ApartmentService {

    List<Apartment> queryApartmentMessage(int startNum, int pageSize);

    Object queryApartmentCount(int count);

    List<Apartment> queryAllApartment();

    List<Apartment> queryAptmentById(String apartmentName);

    int addApartment(String apartmentName, Integer apartmentSize, String apartmentManager, String apartmentCharge, String apartmentNote);

    int delApartment(Integer apartmentId);

    int updateApartment(String apartmentName, Integer apartmentSize, String apartmentManager, String apartmentCharge, String apartmentNote, Integer apartmentId);
}
