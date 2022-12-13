package com.api.rec.member.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rec.member.db.entity.TbNotificationData;

public interface TbNotificationDataRepository extends JpaRepository<TbNotificationData, Integer> {
    public final static String statusSend = "send";
	public final static String statusError = "error";
}