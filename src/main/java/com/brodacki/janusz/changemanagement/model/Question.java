package com.brodacki.janusz.changemanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String content;

    @JsonIgnore
    @ManyToMany(mappedBy = "questions")
    private List<Document> documents;

    ////@OneToMany
    //@JoinColumn(name = "id_question")
    //private List<Answer> answers;
    @OneToOne(fetch = FetchType.LAZY)
    private Answer answer;

    public Question() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
// public List<Answer> getAnswers() {
   //     return answers;
    //}

   // public void setAnswers(List<Answer> answers) {
   //     this.answers = answers;
   // }
}
