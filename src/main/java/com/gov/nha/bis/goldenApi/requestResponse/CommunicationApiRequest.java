package com.gov.nha.bis.goldenApi.requestResponse;

import com.gov.nha.bis.goldenApi.model.BeneficieryAddressDetailEntity;

public class CommunicationApiRequest {
	
	private String hmac;
	private String token;
	private BeneficieryAddressDetailEntity beneficieryAddressDetail;

	@Override
	public String toString() {
		return "CommunicationApiRequest [hmac=" + hmac + ", token=" + token + ", beneficieryAddressDetail="
				+ beneficieryAddressDetail + "]";
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
	public BeneficieryAddressDetailEntity getBeneficieryAddressDetail() {
		return beneficieryAddressDetail;
	}
	public void setBeneficieryAddressDetail(BeneficieryAddressDetailEntity beneficieryAddressDetail) {
		this.beneficieryAddressDetail = beneficieryAddressDetail;
	}
}
