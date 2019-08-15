package com.trungthuc.controllers;

import com.trungthuc.domains.Exam;
import com.trungthuc.domains.Question;
import com.trungthuc.services.ExamService;
import com.trungthuc.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @Autowired
    ExamService examService;

    @PostMapping(value ="/api/v1/{examId}/question" )
    public Question save(@PathVariable("examId") Integer examId, @RequestBody Question question) throws ChangeSetPersister.NotFoundException {

     return examService.findById(examId).map(exam -> {
     question.setExam(exam);
     return questionService.save(question);
    }).orElseThrow( () -> new ChangeSetPersister.NotFoundException());
}
}
