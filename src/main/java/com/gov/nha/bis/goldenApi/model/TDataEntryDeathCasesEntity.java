package com.gov.nha.bis.goldenApi.model;

import java.util.Date;

public class TDataEntryDeathCasesEntity {

	private Long id;

    private String pmjayId;
	
	private String userid;

	private String status;

	private String prevflag;
	
	private String dateofDeath;
	
	private String placeofDeath;
	
	private Date createdatetime;
	
	private String displayreason;
	
	private boolean isrevoked;
	
	private String vill_ward_code;
	
	private String applicationName;
	
	private String deathCertificate;
	
	private String deathSummary;
	
	private String remarks;
	
	private String transactionnumber;
	
	private String stateCode;
	
	private String schemeName;

	private String institutionalName;

	private String address;
	
	private String codingsystem;

	private String codevalue;
	
	private String userId;
	
	private String hospitalcodingSystem;
	
	private String hospitalId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPmjayId() {
		return pmjayId;
	}

	public void setPmjayId(String pmjayId) {
		this.pmjayId = pmjayId;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrevflag() {
		return prevflag;
	}

	public void setPrevflag(String prevflag) {
		this.prevflag = prevflag;
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

	public Date getCreatedatetime() {
		return createdatetime;
	}

	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}

	public String getDisplayreason() {
		return displayreason;
	}

	public void setDisplayreason(String displayreason) {
		this.displayreason = displayreason;
	}

	public boolean isIsrevoked() {
		return isrevoked;
	}

	public void setIsrevoked(boolean isrevoked) {
		this.isrevoked = isrevoked;
	}

	public String getVill_ward_code() {
		return vill_ward_code;
	}

	public void setVill_ward_code(String vill_ward_code) {
		this.vill_ward_code = vill_ward_code;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTransactionnumber() {
		return transactionnumber;
	}

	public void setTransactionnumber(String transactionnumber) {
		this.transactionnumber = transactionnumber;
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

	@Override
	public String toString() {
		return "TDataEntryDeathCasesEntity [id=" + id + ", pmjayId=" + pmjayId + ", userid=" + userid + ", status="
				+ status + ", prevflag=" + prevflag + ", dateofDeath=" + dateofDeath + ", placeofDeath=" + placeofDeath
				+ ", createdatetime=" + createdatetime + ", displayreason=" + displayreason + ", isrevoked=" + isrevoked
				+ ", vill_ward_code=" + vill_ward_code + ", applicationName=" + applicationName + ", deathCertificate="
				+ deathCertificate + ", deathSummary=" + deathSummary + ", remarks=" + remarks + ", transactionnumber="
				+ transactionnumber + ", stateCode=" + stateCode + ", schemeName=" + schemeName + ", institutionalName="
				+ institutionalName + ", address=" + address + ", codingsystem=" + codingsystem + ", codevalue="
				+ codevalue + ", userId=" + userId + ", hospitalcodingSystem=" + hospitalcodingSystem + ", hospitalId="
				+ hospitalId + "]";
	}

	public String getCodingsystem() {
		return codingsystem;
	}

	public void setCodingsystem(String codingsystem) {
		this.codingsystem = codingsystem;
	}

	public String getCodevalue() {
		return codevalue;
	}

	public void setCodevalue(String codevalue) {
		this.codevalue = codevalue;
	}

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
