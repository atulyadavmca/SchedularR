package com.gov.nha.bis.goldenApi.requestResponse;

public class DeceasedPmjayIdApiRequest {
	
	private UserDetail user;
	private String applicationName;
	private String stateCode;
	private String schemeName;
	private String pmjayId;
	private String status;
	private String deathCertificate;
	private String deathSummary;
	private String token;
	private DeceasedReason reason;
	private String dateofDeath;
	private String placeofDeath;
	private String institutionalName;
	private String address;
	private String remarks;

	@Override
	public String toString() {
		return "DeceasedPmjayIdApiRequest [user=" + user + ", applicationName=" + applicationName + ", stateCode="
				+ stateCode + ", schemeName=" + schemeName + ", pmjayId=" + pmjayId + ", status=" + status
				+ ", deathCertificate=" + deathCertificate + ", deathSummary=" + deathSummary + ", token=" + token
				+ ", reason=" + reason + ", dateofDeath=" + dateofDeath + ", placeofDeath=" + placeofDeath
				+ ", InstitutionalName=" + institutionalName + ", address=" + address + ", remarks=" + remarks + "]";
	}
	public UserDetail getUser() {
		return user;
	}
	public void setUser(UserDetail user) {
		this.user = user;
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
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
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
	public String getDeathCertificate() {
		return deathCertificate;
	}
	public void setDeathCertificate(String deathCertificate) {
		this.deathCertificate = deathCertificate;
	}
	public String getDeathSummary() {
		return deathSummary;
	}
	public void setDeathSummary(String deathSummary) {
		this.deathSummary = deathSummary;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public DeceasedReason getReason() {
		return reason;
	}
	public void setReason(DeceasedReason reason) {
		this.reason = reason;
	}
	public String getDateofDeath() {
		return dateofDeath;
	}
	public void setDateofDeath(String dateofDeath) {
		this.dateofDeath = dateofDeath;
	}
	public String getPlaceofDeath() {
		return placeofDeath;
	}
	public void setPlaceofDeath(String placeofDeath) {
		this.placeofDeath = placeofDeath;
	}
	public String getInstitutionalName() {
		return institutionalName;
	}
	public void setInstitutionalName(String institutionalName) {
		this.institutionalName = institutionalName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
