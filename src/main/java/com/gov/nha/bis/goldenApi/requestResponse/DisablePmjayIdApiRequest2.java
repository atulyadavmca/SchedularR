package com.gov.nha.bis.goldenApi.requestResponse;

public class DisablePmjayIdApiRequest2 {
	
	private Long userid;
	private String operationType;
	private String guid;
	private String stateCode;
	private String pmjay_id;
	private String verification_status;
	
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getOperationType() {
		return operationType;
	}
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getPmjay_id() {
		return pmjay_id;
	}
	public void setPmjay_id(String pmjay_id) {
		this.pmjay_id = pmjay_id;
	}
	public String getVerification_status() {
		return verification_status;
	}
	public void setVerification_status(String verification_status) {
		this.verification_status = verification_status;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	
}
