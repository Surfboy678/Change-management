package com.brodacki.janusz.changemanagement.controller;

import com.brodacki.janusz.changemanagement.model.Document;
import com.brodacki.janusz.changemanagement.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping
public class DocumentController {

    private DocumentRepository documentRepository;

    @Autowired
    public DocumentController(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @GetMapping("/getDocumentById/{idDocument}")
    public Optional<Document> getDocumentById(@PathVariable Integer idDocument){
        return documentRepository.findById(idDocument);
    }
}
