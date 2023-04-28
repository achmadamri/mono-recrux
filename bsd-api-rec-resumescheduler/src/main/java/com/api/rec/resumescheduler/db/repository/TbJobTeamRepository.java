package com.api.rec.resumescheduler.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rec.resumescheduler.db.entity.TbJobTeam;

public interface TbJobTeamRepository extends JpaRepository<TbJobTeam, Integer> {
}