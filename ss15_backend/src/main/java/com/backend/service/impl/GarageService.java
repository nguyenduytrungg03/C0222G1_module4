package com.backend.service.impl;

import com.backend.model.Garage;
import com.backend.repository.IGarageRepo;
import com.backend.service.IGarageService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class GarageService implements IGarageService {
    @Autowired
    private IGarageRepo iGarageRepo;


    @Override
    public List<Garage> findAll() {
        return iGarageRepo.findAll();
    }
}
