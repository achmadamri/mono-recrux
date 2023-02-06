package com.api.rec.departments.db.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.rec.departments.db.entity.ViewResumeJob;

public interface ViewResumeJobRepository extends JpaRepository<ViewResumeJob, Integer> {
	@Query(value = "SELECT * FROM view_resume_job WHERE tbr_create_idc = ?1 and tbj_id = ?2 or tbj_id is null", nativeQuery = true)
	List<ViewResumeJob> find(Integer tbrCreateIdc, Integer tbjId, Pageable pageable);

	@Query(value = "SELECT count(0) FROM view_resume_job WHERE tbr_create_idc = ?1 and (tbj_id = ?2 or tbj_id is null)", nativeQuery = true)
	Long count(Integer tbrCreateIdc, Integer tbjId);

	@Query(value = "SELECT * FROM view_resume_job WHERE tbr_create_idc = ?1 and tbj_id = ?2 and tbr_uuid like %?3% and tbr_data_name_raw like %?4% and tbr_status like %?5% and tbr_assigned like %?6%", nativeQuery = true)
	List<ViewResumeJob> findAssigned(Integer tbrCreateIdc, Integer tbjId, String tbrUuid, String tbrDataNameRaw, String tbrStatus, String tbrAssigned, Pageable pageable);

	@Query(value = "SELECT count(0) FROM view_resume_job WHERE tbr_create_idc = ?1 and tbj_id = ?2 and tbr_uuid like %?3% and tbr_data_name_raw like %?4% and tbr_status like %?5% and tbr_assigned like %?6%", nativeQuery = true)
	Long countAssigned(Integer tbrCreateIdc, Integer tbjId, String tbrUuid, String tbrDataNameRaw, String tbrStatus, String tbrAssigned);

	@Query(value = "SELECT * FROM view_resume_job WHERE tbr_create_idc = ?1 and tbj_id is null and tbr_uuid like %?2% and tbr_data_name_raw like %?3% and tbr_status like %?4% and tbr_assigned like %?5%", nativeQuery = true)
	List<ViewResumeJob> findNotAssigned(Integer tbrCreateIdc, String tbrUuid, String tbrDataNameRaw, String tbrStatus, String tbrAssigned, Pageable pageable);

	@Query(value = "SELECT count(0) FROM view_resume_job WHERE tbr_create_idc = ?1 and tbj_id is null and tbr_uuid like %?2% and tbr_data_name_raw like %?3% and tbr_status like %?4% and tbr_assigned like %?4%", nativeQuery = true)
	Long countNotAssigned(Integer tbrCreateIdc, String tbrUuid, String tbrDataNameRaw, String tbrStatus, String tbrAssigned);

	@Query(value = "SELECT * FROM view_resume_job WHERE tbr_create_idc = ?1", nativeQuery = true)
	List<ViewResumeJob> findList(Integer tbrCreateIdc, Pageable pageable);

	@Query(value = "SELECT count(0) FROM view_resume_job WHERE tbr_create_idc = ?1", nativeQuery = true)
	Long countList(Integer tbrCreateIdc);
}