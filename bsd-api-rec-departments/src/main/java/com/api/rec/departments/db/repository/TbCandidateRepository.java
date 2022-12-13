package com.api.rec.departments.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rec.departments.db.entity.TbCandidate;

public interface TbCandidateRepository extends JpaRepository<TbCandidate, Integer> {
}