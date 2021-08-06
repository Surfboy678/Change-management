package com.brodacki.janusz.changemanagement.controller;

import com.brodacki.janusz.changemanagement.model.Answer;
import com.brodacki.janusz.changemanagement.model.Document;
import com.brodacki.janusz.changemanagement.repository.AnswerRepository;
import com.brodacki.janusz.changemanagement.repository.DocumentRepository;
import com.brodacki.janusz.changemanagement.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class AnswerController {


    private AnswerRepository answerRepository;

    private DocumentRepository documentRepository;

    private QuestionRepository questionRepository;

    @Autowired
    public AnswerController(AnswerRepository answerRepository, DocumentRepository documentRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.documentRepository = documentRepository;
        this.questionRepository = questionRepository;
    }

    @GetMapping("/getAnswerById/{idAnswer}")
    public Optional<Answer> getAnswerById(@PathVariable Integer idAnswer){
      return   answerRepository.findById(idAnswer);
    }

    @PostMapping("/addAnswer/{idDocument}")
    public Answer addAnswer(@RequestBody Answer answer, @PathVariable Integer idDocument){
       List<Answer> getListAnswer = documentRepository.findById(idDocument).get().getAnswerList();
       getListAnswer.add(answer);
       return answerRepository.save(answer);
    }


}
