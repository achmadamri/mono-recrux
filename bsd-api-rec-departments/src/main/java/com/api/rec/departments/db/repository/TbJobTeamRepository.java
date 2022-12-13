package com.api.rec.departments.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rec.departments.db.entity.TbJobTeam;

public interface TbJobTeamRepository extends JpaRepository<TbJobTeam, Integer> {
}