package com.gov.nha.bis.goldenApi.requestResponse;

public class CheckStatusRequest {
	
	private String state_code;
	private String pmjay_id;
	private String ref_id;
	private String token;
	
	public String getState_code() {
		return state_code;
	}
	public void setState_code(String state_code) {
		this.state_code = state_code;
	}
	public String getPmjay_id() {
		return pmjay_id;
	}
	public void setPmjay_id(String pmjay_id) {
		this.pmjay_id = pmjay_id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "CheckStatusRequest [state_code=" + state_code + ", pmjay_id=" + pmjay_id + ", ref_id=" + ref_id
				+ ", token=" + token + "]";
	}
	public String getRef_id() {
		return ref_id;
	}
	public void setRef_id(String ref_id) {
		this.ref_id = ref_id;
	}

}
