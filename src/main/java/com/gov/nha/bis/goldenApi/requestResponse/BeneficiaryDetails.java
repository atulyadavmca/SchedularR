package com.gov.nha.bis.goldenApi.requestResponse;

public class BeneficiaryDetails{
    private String ahlTinId;
    private String uuid;
    private String hhId;
    private String mobileNumber;
    private String aadharToken;
    private RationCardDetails rationCardDetails;
    private String familyType;
    private String health_id;
	public String getAhlTinId() {
		return ahlTinId;
	}
	public void setAhlTinId(String ahlTinId) {
		this.ahlTinId = ahlTinId;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getHhId() {
		return hhId;
	}
	public void setHhId(String hhId) {
		this.hhId = hhId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAadharToken() {
		return aadharToken;
	}
	public void setAadharToken(String aadharToken) {
		this.aadharToken = aadharToken;
	}
	public RationCardDetails getRationCardDetails() {
		return rationCardDetails;
	}
	public void setRationCardDetails(RationCardDetails rationCardDetails) {
		this.rationCardDetails = rationCardDetails;
	}
	public String getFamilyType() {
		return familyType;
	}
	public void setFamilyType(String familyType) {
		this.familyType = familyType;
	}
	public String getHealth_id() {
		return health_id;
	}
	public void setHealth_id(String health_id) {
		this.health_id = health_id;
	}
	@Override
	public String toString() {
		return "BeneficiaryDetails [ahlTinId=" + ahlTinId + ", uuid=" + uuid + ", hhId=" + hhId + ", mobileNumber="
				+ mobileNumber + ", aadharToken=" + aadharToken + ", rationCardDetails=" + rationCardDetails
				+ ", familyType=" + familyType + ", health_id=" + health_id + "]";
	}
    
    
}
