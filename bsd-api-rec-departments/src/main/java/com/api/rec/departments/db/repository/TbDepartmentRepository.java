package com.api.rec.departments.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rec.departments.db.entity.TbDepartment;

public interface TbDepartmentRepository extends JpaRepository<TbDepartment, Integer> {
}