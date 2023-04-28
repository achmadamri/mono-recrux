package com.api.rec.resumescheduler.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rec.resumescheduler.db.entity.TbJobCandidate;

public interface TbJobCandidateRepository extends JpaRepository<TbJobCandidate, Integer> {
}