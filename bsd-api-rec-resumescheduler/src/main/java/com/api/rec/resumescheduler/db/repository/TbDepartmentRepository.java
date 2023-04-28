package com.api.rec.resumescheduler.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rec.resumescheduler.db.entity.TbDepartment;

public interface TbDepartmentRepository extends JpaRepository<TbDepartment, Integer> {
	public final static String Active = "active";
	public final static String NonActive = "non active";
}