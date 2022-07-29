package com.codegym.furama.repository.employee;

import com.codegym.furama.model.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationDegree extends JpaRepository<EducationDegree, Integer> {
}
