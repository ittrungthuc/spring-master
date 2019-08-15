package com.trungthuc.spec;

import com.trungthuc.domains.Exam;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ExamSpec {
    public static Specification<Exam> defaultWhere(){
        return  new Specification<Exam>() {
            @Override
            public Predicate toPredicate(Root<Exam> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.notEqual(root.get("id"), 0);
            }
        };
    }
    public static Specification<Exam> findByName(String name){
        return  new Specification<Exam>() {
            @Override
            public Predicate toPredicate(Root<Exam> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("name"), name + "%");
            }
        };
    }

}
