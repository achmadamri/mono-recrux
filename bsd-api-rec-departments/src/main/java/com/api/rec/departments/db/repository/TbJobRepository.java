package com.api.rec.departments.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rec.departments.db.entity.TbJob;

public interface TbJobRepository extends JpaRepository<TbJob, Integer> {
}