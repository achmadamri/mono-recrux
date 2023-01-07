package com.api.rec.departments.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rec.departments.db.entity.TbResume;

public interface TbResumeRepository extends JpaRepository<TbResume, Integer> {
}