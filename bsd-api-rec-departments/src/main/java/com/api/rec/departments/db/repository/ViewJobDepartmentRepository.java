package com.api.rec.departments.db.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rec.departments.db.entity.ViewJobDepartment;

public interface ViewJobDepartmentRepository extends JpaRepository<ViewJobDepartment, Integer> {

	Page<ViewJobDepartment> findByTbjCreateIdcAndTbdIdOrTbdIdIsNull(Integer tbjCreateIdc, Integer tbdId, Pageable pageable);

	Long countByTbjCreateIdcAndTbdIdOrTbdIdIsNull(Integer tbjCreateIdc, Integer tbdId);
}