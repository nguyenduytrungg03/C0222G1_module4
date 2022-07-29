package com.demo.controller;

import com.demo.model.QuestionContent;
import com.demo.model.QuestionType;
import com.demo.service.IQuestionContentService;
import com.demo.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuestionContentController {
    @Autowired
    private IQuestionContentService iQuestionContentService;

    @Autowired
    private IQuestionTypeService iQuestionTypeService;


    @ModelAttribute("questionTypeList")
    public List<QuestionType> questionTypeList() {
        return this.iQuestionTypeService.findAll();
    }
    @GetMapping("/")
    public String getAllStudent(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<QuestionContent> list = iQuestionContentService.getAll(PageRequest.of(page,2));
        model.addAttribute("listQuestionContent", list);
        model.addAttribute("questionContent",new QuestionContent());
        return "list";
    }

}
