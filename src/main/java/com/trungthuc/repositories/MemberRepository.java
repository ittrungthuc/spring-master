package com.trungthuc.repositories;

import com.trungthuc.domains.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> , JpaSpecificationExecutor<Member> {
}
