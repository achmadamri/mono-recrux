package com.api.rec.departments.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rec.departments.db.entity.TbJobResume;

public interface TbJobResumeRepository extends JpaRepository<TbJobResume, Integer> {
	public final static String Assigned = "assigned";
	public final static String NotAssigned = "not assigned";
}