package com.api.rec.member.db.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the tb_user_menu database table.
 * 
 */
@Entity
@Table(name="tb_user_menu")
@NamedQuery(name="TbUserMenu.findAll", query="SELECT t FROM TbUserMenu t")
public class TbUserMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tbum_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tbumId;

	@Column(name="tbm_id")
	private Integer tbmId;

	@Column(name="tbu_id")
	private Integer tbuId;

	@Column(name="tbum_add")
	private Integer tbumAdd;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbum_create_date")
	private Date tbumCreateDate;

	@Column(name="tbum_create_id")
	private Integer tbumCreateId;

	@Column(name="tbum_delete")
	private Integer tbumDelete;

	@Column(name="tbum_edit")
	private Integer tbumEdit;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbum_update_date")
	private Date tbumUpdateDate;

	@Column(name="tbum_update_id")
	private Integer tbumUpdateId;

	@Column(name="tbum_view")
	private Integer tbumView;

	public TbUserMenu() {
	}

	public Integer getTbumId() {
		return this.tbumId;
	}

	public void setTbumId(Integer tbumId) {
		this.tbumId = tbumId;
	}

	public Integer getTbmId() {
		return this.tbmId;
	}

	public void setTbmId(Integer tbmId) {
		this.tbmId = tbmId;
	}

	public Integer getTbuId() {
		return this.tbuId;
	}

	public void setTbuId(Integer tbuId) {
		this.tbuId = tbuId;
	}

	public Integer getTbumAdd() {
		return this.tbumAdd;
	}

	public void setTbumAdd(Integer tbumAdd) {
		this.tbumAdd = tbumAdd;
	}

	public Date getTbumCreateDate() {
		return this.tbumCreateDate;
	}

	public void setTbumCreateDate(Date tbumCreateDate) {
		this.tbumCreateDate = tbumCreateDate;
	}

	public Integer getTbumCreateId() {
		return this.tbumCreateId;
	}

	public void setTbumCreateId(Integer tbumCreateId) {
		this.tbumCreateId = tbumCreateId;
	}

	public Integer getTbumDelete() {
		return this.tbumDelete;
	}

	public void setTbumDelete(Integer tbumDelete) {
		this.tbumDelete = tbumDelete;
	}

	public Integer getTbumEdit() {
		return this.tbumEdit;
	}

	public void setTbumEdit(Integer tbumEdit) {
		this.tbumEdit = tbumEdit;
	}

	public Date getTbumUpdateDate() {
		return this.tbumUpdateDate;
	}

	public void setTbumUpdateDate(Date tbumUpdateDate) {
		this.tbumUpdateDate = tbumUpdateDate;
	}

	public Integer getTbumUpdateId() {
		return this.tbumUpdateId;
	}

	public void setTbumUpdateId(Integer tbumUpdateId) {
		this.tbumUpdateId = tbumUpdateId;
	}

	public Integer getTbumView() {
		return this.tbumView;
	}

	public void setTbumView(Integer tbumView) {
		this.tbumView = tbumView;
	}

}