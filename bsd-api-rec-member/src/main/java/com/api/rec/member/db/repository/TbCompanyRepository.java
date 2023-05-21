package com.api.rec.member.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rec.member.db.entity.TbCompany;

public interface TbCompanyRepository extends JpaRepository<TbCompany, Integer> {
}