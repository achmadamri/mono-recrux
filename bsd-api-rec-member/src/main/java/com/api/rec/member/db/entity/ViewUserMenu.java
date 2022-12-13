package com.api.rec.member.db.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


/**
 * The persistent class for the view_user_menu database table.
 * 
 */
@Entity
@Table(name="view_user_menu")
@NamedQuery(name="ViewUserMenu.findAll", query="SELECT v FROM ViewUserMenu v")
public class ViewUserMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="tbm_id")
	private Integer tbmId;

	@Column(name="tbm_name")
	private String tbmName;

	@Column(name="tbu_email")
	private String tbuEmail;

	@Column(name="tbu_firstname")
	private String tbuFirstname;

	@Column(name="tbu_id")
	private Integer tbuId;

	@Column(name="tbu_lastname")
	private String tbuLastname;

	@Column(name="tbum_add")
	private Integer tbumAdd;

	@Column(name="tbum_delete")
	private Integer tbumDelete;

	@Column(name="tbum_edit")
	private Integer tbumEdit;

	@Column(name="tbum_view")
	private Integer tbumView;

	@Column(name="tbm_sort")
	private Integer tbmSort;

	@Id
	private String uuid;

	public ViewUserMenu() {
	}

	public Integer getTbmId() {
		return this.tbmId;
	}

	public void setTbmId(Integer tbmId) {
		this.tbmId = tbmId;
	}

	public String getTbmName() {
		return this.tbmName;
	}

	public void setTbmName(String tbmName) {
		this.tbmName = tbmName;
	}

	public String getTbuEmail() {
		return this.tbuEmail;
	}

	public void setTbuEmail(String tbuEmail) {
		this.tbuEmail = tbuEmail;
	}

	public String getTbuFirstname() {
		return this.tbuFirstname;
	}

	public void setTbuFirstname(String tbuFirstname) {
		this.tbuFirstname = tbuFirstname;
	}

	public Integer getTbuId() {
		return this.tbuId;
	}

	public void setTbuId(Integer tbuId) {
		this.tbuId = tbuId;
	}

	public String getTbuLastname() {
		return this.tbuLastname;
	}

	public void setTbuLastname(String tbuLastname) {
		this.tbuLastname = tbuLastname;
	}

	public Integer getTbumAdd() {
		return this.tbumAdd;
	}

	public void setTbumAdd(Integer tbumAdd) {
		this.tbumAdd = tbumAdd;
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

	public Integer getTbumView() {
		return this.tbumView;
	}

	public void setTbumView(Integer tbumView) {
		this.tbumView = tbumView;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getTbmSort() {
		return tbmSort;
	}

	public void setTbmSort(Integer tbmSort) {
		this.tbmSort = tbmSort;
	}

}