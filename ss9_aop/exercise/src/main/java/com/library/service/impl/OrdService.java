package com.library.service.impl;

import com.library.model.OrdBook;
import com.library.repository.IOrdRepository;
import com.library.service.IOrdBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdService implements IOrdBookService {
    @Autowired
    private IOrdRepository iOrdRepository;

    @Override
    public List<OrdBook> findAll() {
        return iOrdRepository.findAll();
    }

    @Override
    public void save(OrdBook ordBook) {
        iOrdRepository.save(ordBook);
    }

    @Override
    public OrdBook findById(Integer codeRandom) {
        return iOrdRepository.findByCodeRandom(codeRandom);
    }

    @Override
    public void remove(OrdBook ordBook) {
        iOrdRepository.delete(ordBook);
    }
}
