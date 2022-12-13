package com.api.rec.member.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rec.member.db.entity.TbNotification;

public interface TbNotificationRepository extends JpaRepository<TbNotification, Integer> {
    public final static String statusActive = "active";
	public final static String statusDisable = "disable";
}