package com.trungthuc.services;

import com.trungthuc.domains.Exam;
import com.trungthuc.repositories.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    ExamRepository examRepository;

    @Override
    public Optional<Exam> findByName(String name) {
        Optional<Exam> exam =examRepository.findByName(name);
        return  exam;
    }

    @Override
    public Optional<Exam> findById(int id) {
        Optional<Exam> exam =examRepository.findById(id);
        return  exam;
    }

    @Override
    public Page<Exam> findAll(Specification<Exam> specification, Pageable pageable) {
        Page<Exam> exams= examRepository.findAll(specification,pageable);
        return exams;
    }


    @Override
    public Exam save(Exam exam) {
        return examRepository.save(exam);
    }
}
