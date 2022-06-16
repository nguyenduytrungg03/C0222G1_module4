package com.electronic_mail.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
@Service
public class ElectronicMailService implements IElectronicMailService {
    @Override
    public List<String> language() {
        List<String> listLanguage = new ArrayList<>();
        listLanguage.add("English");
        listLanguage.add("Vietnamese");
        listLanguage.add("Japanese");
        listLanguage.add("Chinese");
        return listLanguage;
    }

    @Override
    public List<Integer> pageSize() {
        List<Integer> listPageSize = new ArrayList<>();
        listPageSize.add(5);
        listPageSize.add(10);
        listPageSize.add(15);
        listPageSize.add(20);
        listPageSize.add(25);
        listPageSize.add(30);
        return listPageSize;
    }
}
