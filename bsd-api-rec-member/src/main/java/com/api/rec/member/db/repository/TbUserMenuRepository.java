package com.api.rec.member.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rec.member.db.entity.TbUserMenu;

public interface TbUserMenuRepository extends JpaRepository<TbUserMenu, Integer> {
}