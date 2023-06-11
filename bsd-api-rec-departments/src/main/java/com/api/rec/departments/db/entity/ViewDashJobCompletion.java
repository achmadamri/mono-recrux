package com.api.rec.departments.db.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the view_dash_job_completion database table.
 * 
 */
@Entity
@Table(name="view_dash_job_completion")
@NamedQuery(name="ViewDashJobCompletion.findAll", query="SELECT t FROM ViewDashJobCompletion t")
public class ViewDashJobCompletion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uuid;

	@Column(name="status")
	private String status;

	@Column(columnDefinition = "bigint", name="count_data")
	private Integer countData;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCountData() {
		return countData;
	}

	public void setCountData(Integer countData) {
		this.countData = countData;
	}
}