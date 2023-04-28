package com.api.rec.resumescheduler.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rec.resumescheduler.db.entity.TbDepartmentTeam;

public interface TbDepartmentTeamRepository extends JpaRepository<TbDepartmentTeam, Integer> {
}