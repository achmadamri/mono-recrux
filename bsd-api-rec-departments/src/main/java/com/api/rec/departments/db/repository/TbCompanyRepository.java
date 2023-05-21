package com.api.rec.departments.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rec.departments.db.entity.TbCompany;

public interface TbCompanyRepository extends JpaRepository<TbCompany, Integer> {
}