package com.brodacki.janusz.changemanagement.controller;

import com.brodacki.janusz.changemanagement.model.Question;
import com.brodacki.janusz.changemanagement.repository.DocumentRepository;
import com.brodacki.janusz.changemanagement.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class QuestionController {


    private QuestionRepository questionRepository;

    private DocumentRepository documentRepository;

    @Autowired
    public QuestionController(QuestionRepository questionRepository, DocumentRepository documentRepository) {
        this.questionRepository = questionRepository;
        this.documentRepository = documentRepository;
    }


    @PostMapping("/addQuestion")
    public Question addQuestion(@RequestBody Question question) {
        return questionRepository.save(question);
    }

    @PostMapping("/addQuestionToDocument/{idDocument}")
    public Question addQuestionToDocument(@RequestBody Question question, @PathVariable Integer idDocument) {
        List<Question> questionList = documentRepository.findById(idDocument).get().getQuestionList();
        questionList.add(question);
        return questionRepository.save(question);
        
    }

    @GetMapping("/getQuestion/{idQuestion}")
    public Question getQuestionById(@PathVariable Integer idQuestion) {
        return questionRepository.getById(idQuestion);
    }
}
