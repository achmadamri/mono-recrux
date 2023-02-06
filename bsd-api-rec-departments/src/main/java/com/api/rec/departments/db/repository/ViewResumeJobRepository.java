package com.api.rec.departments.db.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.rec.departments.db.entity.ViewResumeJob;

public interface ViewResumeJobRepository extends JpaRepository<ViewResumeJob, Integer> {
	public final static String Active = "active";
	public final static String NonActive = "non active";

	@Query(value = "SELECT * FROM view_resume_job WHERE tbj_id = ?1 or tbj_id is null and tbr_uuid like %?2%  and tbr_data_name_raw like %?3% and tbr_status like %?4%", nativeQuery = true)
	List<ViewResumeJob> find(Integer tbjId, String tbrUuid, String tbrDataNameRaw, String tbrStatus, Pageable pageable);

	@Query(value = "SELECT count(0) FROM view_resume_job WHERE tbj_id = ?1 or tbj_id is null and tbr_uuid like %?2%  and tbr_data_name_raw like %?3% and tbr_status like %?4%", nativeQuery = true)
	Long count(Integer tbjId, String tbjName, String tbrDataNameRaw, String tbrStatus);
}