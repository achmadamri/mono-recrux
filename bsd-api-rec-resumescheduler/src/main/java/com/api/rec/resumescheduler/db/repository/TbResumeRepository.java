package com.api.rec.resumescheduler.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.rec.resumescheduler.db.entity.TbResume;

public interface TbResumeRepository extends JpaRepository<TbResume, Integer> {
	public final static String ParsePending = "parse pending";
	public final static String Parsing = "parsing";
	public final static String Active = "active";
	public final static String NonActive = "non active";
	public final static String Assigned = "assigned";
	public final static String NotAssigned = "not assigned";

	@Query(value = "SELECT * FROM tb_resume WHERE tbr_status = 'parse pending' order by tbr_id asc", nativeQuery = true)
	List<TbResume> findParsePending();

	@Query(value = "SELECT * FROM tb_resume WHERE tbr_status = 'parsing' order by tbr_id asc", nativeQuery = true)
	List<TbResume> findParsing();
}