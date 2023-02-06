package com.api.rec.departments.db.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.rec.departments.db.entity.ViewResumeJob;

public interface ViewResumeJobRepository extends JpaRepository<ViewResumeJob, Integer> {
	@Query(value = "SELECT * FROM view_resume_job WHERE tbj_id = ?1 or tbj_id is null", nativeQuery = true)
	List<ViewResumeJob> find(Integer tbjId, Pageable pageable);

	@Query(value = "SELECT count(0) FROM view_resume_job WHERE tbj_id = ?1 or tbj_id is null", nativeQuery = true)
	Long count(Integer tbjId);

	@Query(value = "SELECT * FROM view_resume_job WHERE tbj_id = ?1 and tbr_uuid like %?2%  and tbr_data_name_raw like %?3% and tbr_status like %?4% and tbr_assigned like %?5%", nativeQuery = true)
	List<ViewResumeJob> findAssigned(Integer tbjId, String tbrUuid, String tbrDataNameRaw, String tbrStatus, String tbrAssigned, Pageable pageable);

	@Query(value = "SELECT count(0) FROM view_resume_job WHERE tbj_id = ?1 and tbr_uuid like %?2%  and tbr_data_name_raw like %?3% and tbr_status like %?4% and tbr_assigned like %?5%", nativeQuery = true)
	Long countAssigned(Integer tbjId, String tbrUuid, String tbrDataNameRaw, String tbrStatus, String tbrAssigned);

	@Query(value = "SELECT * FROM view_resume_job WHERE tbj_id is null and tbr_uuid like %?1%  and tbr_data_name_raw like %?2% and tbr_status like %?3% and tbr_assigned like %?4%", nativeQuery = true)
	List<ViewResumeJob> findNotAssigned(String tbrUuid, String tbrDataNameRaw, String tbrStatus, String tbrAssigned, Pageable pageable);

	@Query(value = "SELECT count(0) FROM view_resume_job WHERE tbj_id is null and tbr_uuid like %?1%  and tbr_data_name_raw like %?2% and tbr_status like %?3% and tbr_assigned like %?4%", nativeQuery = true)
	Long countNotAssigned(String tbrUuid, String tbrDataNameRaw, String tbrStatus, String tbrAssigned);
}