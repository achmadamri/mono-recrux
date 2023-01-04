package com.api.rec.departments.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rec.departments.db.entity.TbDepartmentJob;

public interface TbDepartmentJobRepository extends JpaRepository<TbDepartmentJob, Integer> {
	public final static String Active = "active";
	public final static String NonActive = "non active";
}