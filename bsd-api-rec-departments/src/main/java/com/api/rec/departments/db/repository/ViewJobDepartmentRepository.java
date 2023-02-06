package com.api.rec.departments.db.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.rec.departments.db.entity.ViewJobDepartment;

public interface ViewJobDepartmentRepository extends JpaRepository<ViewJobDepartment, Integer> {	
	@Query(value = "SELECT * FROM view_job_department WHERE tbd_id = ?1 or tbd_id is null", nativeQuery = true)
	List<ViewJobDepartment> find(Integer tbdId, Pageable pageable);

	@Query(value = "SELECT count(0) FROM view_job_department WHERE tbd_id = ?1 or tbd_id is null", nativeQuery = true)
	Long count(Integer tbdId);

	@Query(value = "SELECT * FROM view_job_department WHERE tbd_id = ?1 and tbj_uuid like %?2%  and tbj_name like %?3% and tbj_status like %?4% and tbj_assigned like %?5%", nativeQuery = true)
	List<ViewJobDepartment> findAssigned(Integer tbdId, String tbjUuid, String tbjName, String tbjStatus, String tbjAssigned, Pageable pageable);

	@Query(value = "SELECT count(0) FROM view_job_department WHERE tbd_id = ?1 and tbj_uuid like %?2%  and tbj_name like %?3% and tbj_status like %?4% and tbj_assigned like %?5%", nativeQuery = true)
	Long countAssigned(Integer tbdId, String tbjUuid, String tbjName, String tbjStatus, String tbjAssigned);

	@Query(value = "SELECT * FROM view_job_department WHERE tbd_id is null and tbj_uuid like %?1%  and tbj_name like %?2% and tbj_status like %?3% and tbj_assigned like %?4%", nativeQuery = true)
	List<ViewJobDepartment> findNotAssigned(String tbjUuid, String tbjName, String tbjStatus, String tbjAssigned, Pageable pageable);

	@Query(value = "SELECT count(0) FROM view_job_department WHERE tbd_id is null and tbj_uuid like %?1%  and tbj_name like %?2% and tbj_status like %?3% and tbj_assigned like %?4%", nativeQuery = true)
	Long countNotAssigned(String tbjUuid, String tbjName, String tbjStatus, String tbjAssigned);
}