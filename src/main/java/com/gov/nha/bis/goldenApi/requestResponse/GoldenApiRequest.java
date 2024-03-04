package com.gov.nha.bis.goldenApi.requestResponse;

public class GoldenApiRequest {
	
	private String hmac;
	private String token;
	private String errorCode;
	private BeneficiaryDetails beneficiaryDetails;

	@Override
	public String toString() {
		return "GoldenApiRequest [hmac=" + hmac + ", token=" + token + ", errorCode=" + errorCode
				+ ", beneficiaryDetails=" + beneficiaryDetails + "]";
	}
	public String getHmac() {
		return hmac;
	}
	public void setHmac(String hmac) {
		this.hmac = hmac;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public BeneficiaryDetails getBeneficiaryDetails() {
		return beneficiaryDetails;
	}
	public void setBeneficiaryDetails(BeneficiaryDetails beneficiaryDetails) {
		this.beneficiaryDetails = beneficiaryDetails;
	}
	
}
