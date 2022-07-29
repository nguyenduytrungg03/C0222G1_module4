package com.backend.service;

import com.backend.model.Garage;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IGarageService {
    List<Garage> findAll();
}
