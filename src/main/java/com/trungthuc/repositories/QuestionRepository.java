package com.trungthuc.repositories;

import com.trungthuc.domains.Exam;
import com.trungthuc.domains.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository  extends JpaRepository<Question,Integer> {
    Page<Question> findByExam(Exam exam,Pageable pageable);
    Page<Question> findAll(Specification<Question> specification, Pageable pageable);
}
