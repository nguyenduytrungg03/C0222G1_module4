package com.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "question_content")
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question_type")
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "questionType")
    @JsonBackReference("questionType")
    private Set<QuestionContent> questionContents;

    public QuestionType() {
    }

    public QuestionType(Integer id, String name, Set<QuestionContent> questionContents) {
        this.id = id;
        this.name = name;
        this.questionContents = questionContents;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<QuestionContent> getQuestionContents() {
        return questionContents;
    }

    public void setQuestionContents(Set<QuestionContent> questionContents) {
        this.questionContents = questionContents;
    }
}
