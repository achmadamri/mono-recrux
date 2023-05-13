package com.api.rec.departments.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rec.departments.db.entity.TbResumeSkill;

public interface TbResumeSkillRepository extends JpaRepository<TbResumeSkill, Integer> {
	public final static String Active = "active";
	public final static String NonActive = "non active";
	public final static String HardSkill = "hard_skill";
	public final static String SoftSkill = "soft_skill";

	public void deleteByTbrId(int tbrId);
}