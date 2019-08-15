package com.trungthuc.services;

import com.trungthuc.domains.Exam;
import com.trungthuc.domains.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;

public interface QuestionService {
    public Question save(Question question);
    public Page<Question> findAll(Specification<Question> specification, Pageable pageable);
    public Optional<Question> findById(int id);
    public Page<Question> findByExam(Exam exam, Pageable pageable);
    public void delete(int id);
}
