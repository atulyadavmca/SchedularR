package com.gov.nha.bis.goldenApi.requestResponse;

public class Header{
    private String errorCode;
    private String version;
    private BeneficiaryDetails beneficiaryDetails;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public BeneficiaryDetails getBeneficiaryDetails() {
		return beneficiaryDetails;
	}
	public void setBeneficiaryDetails(BeneficiaryDetails beneficiaryDetails) {
		this.beneficiaryDetails = beneficiaryDetails;
	}
	@Override
	public String toString() {
		return "Header [errorCode=" + errorCode + ", version=" + version + ", beneficiaryDetails=" + beneficiaryDetails
				+ "]";
	}
}
