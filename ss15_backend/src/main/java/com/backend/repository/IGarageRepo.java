package com.backend.repository;

import com.backend.model.Garage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGarageRepo extends JpaRepository<Garage,Integer> {

}
