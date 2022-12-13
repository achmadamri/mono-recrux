package com.api.rec.departments.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rec.departments.db.entity.TbJobCandidate;

public interface TbJobCandidateRepository extends JpaRepository<TbJobCandidate, Integer> {
}