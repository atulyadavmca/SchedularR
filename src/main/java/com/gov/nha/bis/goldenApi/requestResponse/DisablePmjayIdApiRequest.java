package com.gov.nha.bis.goldenApi.requestResponse;

public class DisablePmjayIdApiRequest {
	
	private Long userid;
	private String applicationName;
	private String stateCode;
	private String pmjayId;
	private String status;
	private String token;
	private String reason;
	
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getPmjayId() {
		return pmjayId;
	}
	public void setPmjayId(String pmjayId) {
		this.pmjayId = pmjayId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "DisablePmjayIdApiRequest [userid=" + userid + ", applicationName=" + applicationName + ", stateCode="
				+ stateCode + ", pmjayId=" + pmjayId + ", status=" + status + ", token=" + token + ", reason=" + reason
				+ "]";
	}

}
