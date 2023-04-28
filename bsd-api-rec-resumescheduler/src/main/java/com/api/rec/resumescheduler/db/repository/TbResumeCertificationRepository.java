package com.api.rec.resumescheduler.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rec.resumescheduler.db.entity.TbResumeCertification;

public interface TbResumeCertificationRepository extends JpaRepository<TbResumeCertification, Integer> {
	public final static String Active = "active";
	public final static String NonActive = "non active";
}