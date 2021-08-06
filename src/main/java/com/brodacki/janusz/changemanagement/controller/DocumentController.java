package com.brodacki.janusz.changemanagement.controller;

import com.brodacki.janusz.changemanagement.model.Document;
import com.brodacki.janusz.changemanagement.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class DocumentController {

    private DocumentRepository documentRepository;

    @Autowired
    public DocumentController(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }
    @PostMapping("/addDocument")
    public Document addDocument(@RequestBody Document document){
        return documentRepository.save(document);
    }

    @GetMapping("/getDocument/{idDocument}")
    public Document getDocumentById(@PathVariable Integer idDocument){
        return documentRepository.getById(idDocument);
    }
}
