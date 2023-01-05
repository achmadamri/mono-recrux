package com.api.rec.departments.db.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.rec.departments.db.entity.ViewJobDepartment;

public interface ViewJobDepartmentRepository extends JpaRepository<ViewJobDepartment, Integer> {
	public final static String Active = "active";
	public final static String NonActive = "non active";

	@Query(
		value = 
		"select" +
		"    cast(uuid() as char(36) charset utf8mb4) as uuid, " +
		"    tbj.tbj_id as tbj_id, " +
		"    tbj.tbj_create_date as tbj_create_date, " +
		"    tbj.tbj_create_id as tbj_create_id, " +
		"    tbj.tbj_create_idc as tbj_create_idc, " +
		"    tbj.tbj_update_date as tbj_update_date, " +
		"    tbj.tbj_update_id as tbj_update_id, " +
		"    tbj.tbj_name as tbj_name, " +
		"    tbj.tbj_status as tbj_status, " +
		"    tbj.tbj_uuid as tbj_uuid, " +
		"    tbd.tbd_id as tbd_id, " +
		"    tbd.tbd_create_date as tbd_create_date, " +
		"    tbd.tbd_create_id as tbd_create_id, " +
		"    tbd.tbd_create_idc as tbd_create_idc, " +
		"    tbd.tbd_update_date as tbd_update_date, " +
		"    tbd.tbd_update_id as tbd_update_id, " +
		"    tbd.tbd_name as tbd_name, " +
		"    tbd.tbd_status as tbd_status, " +
		"    tbd.tbd_uuid as tbd_uuid " +
		"from (select * from tb_job where tbj_create_idc = :tbjCreateIdc and tbj_status = 'active' and tbj_name like %:tbjName%) tbj " +
		"left join tb_department_job tbdj on tbdj.tbdj_create_idc = tbj.tbj_create_idc and tbdj.tbj_id = tbj.tbj_id and tbdj.tbd_id = :tbdId " +
		"left join tb_department tbd on tbd.tbd_id = tbdj.tbd_id"
		, nativeQuery = true)
	List<ViewJobDepartment> findByTbdId(Integer tbjCreateIdc, Integer tbdId, String tbjName, Pageable pageable);

	// @Query("SELECT t FROM ViewJobDepartment t WHERE t.tbjCreateIdc = :tbjCreateIdc and (t.tbdId = :tbdId or t.tbdId is null) and t.tbjName like %:tbjName% and t.tbjStatus = 'active'")	
	// List<ViewJobDepartment> findByTbdId(Integer tbjCreateIdc, Integer tbdId, String tbjName, Pageable pageable);

	@Query(
		value = 
		"select count(0) " +
		"from (select * from tb_job where tbj_create_idc = :tbjCreateIdc and tbj_status = 'active' and tbj_name like %:tbjName%) tbj " +
		"left join tb_department_job tbdj on tbdj.tbdj_create_idc = tbj.tbj_create_idc and tbdj.tbj_id = tbj.tbj_id and tbdj.tbd_id = :tbdId " +
		"left join tb_department tbd on tbd.tbd_id = tbdj.tbd_id"
		, nativeQuery = true)
	Long countByTbdId(Integer tbjCreateIdc, String tbjName, Integer tbdId);
}