package com.brodacki.janusz.changemanagement.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String answerForQuestion;

    @ManyToOne(fetch = FetchType.LAZY)
    private Document document;

    @OneToMany
    private List<Question> questionList = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswerForQuestion() {
        return answerForQuestion;
    }

    public void setAnswerForQuestion(String answerForQuestion) {
        this.answerForQuestion = answerForQuestion;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
