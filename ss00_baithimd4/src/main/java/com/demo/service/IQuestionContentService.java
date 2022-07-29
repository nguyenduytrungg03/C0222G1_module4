package com.demo.service;

import com.demo.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuestionContentService {
    Page<QuestionContent> getAll(Pageable pageable);
}
