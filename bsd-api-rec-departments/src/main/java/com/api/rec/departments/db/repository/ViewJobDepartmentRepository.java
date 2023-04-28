package com.api.rec.departments.db.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.rec.departments.db.entity.ViewJobDepartment;

public interface ViewJobDepartmentRepository extends JpaRepository<ViewJobDepartment, Integer> {

	@Query(value = "SELECT * FROM view_job_department WHERE tbj_create_idc = ?1 and (tbd_id = ?2 or tbd_id is null) and tbj_uuid like %?3% and tbj_name like %?4% and tbj_status like %?5%", nativeQuery = true)
	List<ViewJobDepartment> find(Integer tbjCreateIdc, Integer tbdId, String tbjUuid, String tbjName, String tbjStatus, Pageable pageable);

	@Query(value = "SELECT count(0) FROM view_job_department WHERE tbj_create_idc = ?1 and (tbd_id = ?2 or tbd_id is null) and tbj_uuid like %?3% and tbj_name like %?4% and tbj_status like %?5%", nativeQuery = true)
	Long count(Integer tbjCreateIdc, Integer tbdId, String tbjUuid, String tbjName, String tbjStatus);

	@Query(value = "SELECT * FROM view_job_department WHERE tbj_create_idc = ?1 and (tbd_id = ?2 or tbd_id is null) and tbj_uuid like %?3% and tbj_name like %?4% and tbj_status like %?5% and tbj_assigned = ?6", nativeQuery = true)
	List<ViewJobDepartment> findAssigned(Integer tbjCreateIdc, Integer tbdId, String tbjUuid, String tbjName, String tbjStatus, String tbjAssigned, Pageable pageable);

	@Query(value = "SELECT count(0) FROM view_job_department WHERE tbj_create_idc = ?1 and (tbd_id = ?2 or tbd_id is null) and tbj_uuid like %?3% and tbj_name like %?4% and tbj_status like %?5% and tbj_assigned = ?6", nativeQuery = true)
	Long countAssigned(Integer tbjCreateIdc, Integer tbdId, String tbjUuid, String tbjName, String tbjStatus, String tbjAssigned);
}