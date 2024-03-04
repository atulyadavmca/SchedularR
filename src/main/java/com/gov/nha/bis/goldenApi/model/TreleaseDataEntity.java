package com.gov.nha.bis.goldenApi.model;

import java.util.Date;

public class TreleaseDataEntity {

	private Long id;

    private String ahl_tin;
	
	private String uid_token;

	private String encrypted_uid;

	private String pmjay_id;
	
	private String status;
	
	private Date create_date;
	
	private Date update_date;
	
	private String refernceid;
	
	private String stateCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAhl_tin() {
		return ahl_tin;
	}

	public void setAhl_tin(String ahl_tin) {
		this.ahl_tin = ahl_tin;
	}

	public String getUid_token() {
		return uid_token;
	}

	public void setUid_token(String uid_token) {
		this.uid_token = uid_token;
	}

	public String getEncrypted_uid() {
		return encrypted_uid;
	}

	public void setEncrypted_uid(String encrypted_uid) {
		this.encrypted_uid = encrypted_uid;
	}

	public String getPmjay_id() {
		return pmjay_id;
	}

	public void setPmjay_id(String pmjay_id) {
		this.pmjay_id = pmjay_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	
	

	public String getRefernceid() {
		return refernceid;
	}

	public void setRefernceid(String refernceid) {
		this.refernceid = refernceid;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	@Override
	public String toString() {
		return "TreleaseDataEntity [id=" + id + ", ahl_tin=" + ahl_tin + ", uid_token=" + uid_token + ", encrypted_uid="
				+ encrypted_uid + ", pmjay_id=" + pmjay_id + ", status=" + status + ", create_date=" + create_date
				+ ", update_date=" + update_date + ", refernceid=" + refernceid + ", stateCode=" + stateCode + "]";
	}


	
	
	
}
