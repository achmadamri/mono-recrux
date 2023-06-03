package com.api.rec.member.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_payment database table.
 * 
 */
@Entity
@Table(name="tb_payment")
@NamedQuery(name="TbPayment.findAll", query="SELECT t FROM TbPayment t")
public class TbPayment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tbp_id")
	private Integer tbpId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbp_create_date")
	private Date tbpCreateDate;

	@Column(name="tbp_create_id")
	private Integer tbpCreateId;

	@Column(name="tbp_create_idc")
	private Integer tbpCreateIdc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbp_update_date")
	private Date tbpUpdateDate;

	@Column(name="tbp_update_id")
	private Integer tbpUpdateId;

	@Column(name="tbp_order_id")
	private String tbpOrderId;

	@Column(name="tbp_payer_id")
	private String tbpPayerId;

	@Column(name="tbp_payment_source")
	private String tbpPaymentSource;

	@Column(name="tbp_intent")
	private String tbpIntent;

	@Lob
	@Column(columnDefinition = "text", name="tbp_links")
	private String tbpLinks;

	@Lob
	@Column(columnDefinition = "text", name="tbp_payer")
	private String tbpPayer;

	@Lob
	@Column(columnDefinition = "text", name="tbp_purchase_units")
	private String tbpPurchaseUnits;

	@Column(name="tbp_status")
	private String tbpStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbp_create_time")
	private Date tbpCreateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbp_update_time")
	private Date tbpUpdateTime;

	public Integer getTbpId() {
		return tbpId;
	}

	public void setTbpId(Integer tbpId) {
		this.tbpId = tbpId;
	}

	public Date getTbpCreateDate() {
		return tbpCreateDate;
	}

	public void setTbpCreateDate(Date tbpCreateDate) {
		this.tbpCreateDate = tbpCreateDate;
	}

	public Integer getTbpCreateId() {
		return tbpCreateId;
	}

	public void setTbpCreateId(Integer tbpCreateId) {
		this.tbpCreateId = tbpCreateId;
	}

	public Integer getTbpCreateIdc() {
		return tbpCreateIdc;
	}

	public void setTbpCreateIdc(Integer tbpCreateIdc) {
		this.tbpCreateIdc = tbpCreateIdc;
	}

	public Date getTbpUpdateDate() {
		return tbpUpdateDate;
	}

	public void setTbpUpdateDate(Date tbpUpdateDate) {
		this.tbpUpdateDate = tbpUpdateDate;
	}

	public Integer getTbpUpdateId() {
		return tbpUpdateId;
	}

	public void setTbpUpdateId(Integer tbpUpdateId) {
		this.tbpUpdateId = tbpUpdateId;
	}

	public String getTbpOrderId() {
		return tbpOrderId;
	}

	public void setTbpOrderId(String tbpOrderId) {
		this.tbpOrderId = tbpOrderId;
	}

	public String getTbpPayerId() {
		return tbpPayerId;
	}

	public void setTbpPayerId(String tbpPayerId) {
		this.tbpPayerId = tbpPayerId;
	}

	public String getTbpPaymentSource() {
		return tbpPaymentSource;
	}

	public void setTbpPaymentSource(String tbpPaymentSource) {
		this.tbpPaymentSource = tbpPaymentSource;
	}

	public String getTbpIntent() {
		return tbpIntent;
	}

	public void setTbpIntent(String tbpIntent) {
		this.tbpIntent = tbpIntent;
	}

	public String getTbpLinks() {
		return tbpLinks;
	}

	public void setTbpLinks(String tbpLinks) {
		this.tbpLinks = tbpLinks;
	}

	public String getTbpPayer() {
		return tbpPayer;
	}

	public void setTbpPayer(String tbpPayer) {
		this.tbpPayer = tbpPayer;
	}

	public String getTbpPurchaseUnits() {
		return tbpPurchaseUnits;
	}

	public void setTbpPurchaseUnits(String tbpPurchaseUnits) {
		this.tbpPurchaseUnits = tbpPurchaseUnits;
	}

	public String getTbpStatus() {
		return tbpStatus;
	}

	public void setTbpStatus(String tbpStatus) {
		this.tbpStatus = tbpStatus;
	}

	public Date getTbpCreateTime() {
		return tbpCreateTime;
	}

	public void setTbpCreateTime(Date tbpCreateTime) {
		this.tbpCreateTime = tbpCreateTime;
	}

	public Date getTbpUpdateTime() {
		return tbpUpdateTime;
	}

	public void setTbpUpdateTime(Date tbpUpdateTime) {
		this.tbpUpdateTime = tbpUpdateTime;
	}

}