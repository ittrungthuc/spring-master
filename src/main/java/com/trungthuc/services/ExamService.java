package com.trungthuc.services;

import com.trungthuc.domains.Exam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface ExamService {
    public   Optional<Exam> findByName(String name);
    public   Optional<Exam> findById(int id);
    public   Page<Exam> findAll(Specification<Exam> specification , Pageable pageable);
    public   Exam save(Exam exam);
}
