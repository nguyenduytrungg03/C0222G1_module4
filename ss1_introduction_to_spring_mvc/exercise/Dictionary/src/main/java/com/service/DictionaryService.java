package com.service;

import java.util.LinkedHashMap;
import java.util.Map;

public class DictionaryService implements IDictionaryService{

   private static Map<String, String> listDictionary = new LinkedHashMap<>();
    static {
        listDictionary.put("Dog","Con Chó");
        listDictionary.put("Cat","Mèo");
        listDictionary.put("Tree","Cây");
        listDictionary.put("Pus","Mũ");
        listDictionary.put("Handsome","Đẹp trai");
    }
@Override
public String change(String change) {
    if (listDictionary.containsKey(change)){
        return listDictionary.get(change);
    }else {
        return "NotFound";
    }
}
}
