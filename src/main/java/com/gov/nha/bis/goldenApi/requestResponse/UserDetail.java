package com.gov.nha.bis.goldenApi.requestResponse;

public class UserDetail{
    private String userId;
    private String hospitalcodingSystem;
    private String hospitalId;
	
    public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getHospitalcodingSystem() {
		return hospitalcodingSystem;
	}
	public void setHospitalcodingSystem(String hospitalcodingSystem) {
		this.hospitalcodingSystem = hospitalcodingSystem;
	}
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
}
