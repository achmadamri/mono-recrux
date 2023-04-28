package com.api.rec.resumescheduler.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rec.resumescheduler.db.entity.TbCandidate;

public interface TbCandidateRepository extends JpaRepository<TbCandidate, Integer> {
}