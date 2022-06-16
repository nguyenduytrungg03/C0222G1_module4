package com.declaration.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeclarationService implements IDeclarationService {
    @Override
    public List<String> nationality() {
        List<String> listNationality = new ArrayList<>();
        listNationality.add("English");
        listNationality.add("Vietnamese");
        listNationality.add("Japanese");
        listNationality.add("Chinese");
        return listNationality;
    }

    @Override
    public List<String> dayOfBirth() {
        List<String> listDayOfBirth = new ArrayList<>();
        listDayOfBirth.add("2003");
        listDayOfBirth.add("2002");
        listDayOfBirth.add("2001");
        listDayOfBirth.add("2000");
        return listDayOfBirth;
    }

    @Override
    public List<String> vehicle() {
        List<String> listVehicle = new ArrayList<>();
        listVehicle.add("Tàu bay");
        listVehicle.add("Tàu thuyền");
        listVehicle.add("Ô tô");
        listVehicle.add("Khác");
        return listVehicle;
    }
}