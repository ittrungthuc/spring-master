package com.trungthuc.repositories;

import com.trungthuc.domains.Exam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamRepository extends JpaRepository<Exam,Integer> {

    Optional<Exam> findByName(String name);
    Page<Exam> findAll(Specification<Exam> specification, Pageable pageable);
}
