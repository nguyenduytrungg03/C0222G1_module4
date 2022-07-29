package com.demo.service;

import com.demo.model.QuestionType;
import com.demo.repository.IQuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeService implements IQuestionTypeService {

    @Autowired
    private IQuestionTypeRepository iCustomerTypeRepository;

    @Override
    public List<QuestionType> findAll() {
        return iCustomerTypeRepository.findAll();
    }
}
