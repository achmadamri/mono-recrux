package com.api.rec.member.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rec.member.db.entity.TbPayment;

public interface TbPaymentRepository extends JpaRepository<TbPayment, Integer> {
	public final static String Created = "created";
	public final static String NeedConfirmation = "need confirmation";
	public final static String Active = "active";
	public final static String NonActive = "non active";
}