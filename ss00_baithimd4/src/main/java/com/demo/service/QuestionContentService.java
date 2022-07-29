package com.demo.service;

import com.demo.model.QuestionContent;
import com.demo.repository.IQuestionContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionContentService implements IQuestionContentService {
    @Autowired
    private IQuestionContentRepository iCustomerRepository;

    @Override
    public Page<QuestionContent> getAll(Pageable pageable) {
        return iCustomerRepository.findAllCustomer(pageable) ;
    }
}
