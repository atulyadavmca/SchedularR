package com.gov.nha.bis.goldenApi.requestResponse;

public class RationCardDetails{
    private String rationCard;
    private Integer stateCode;
	public String getRationCard() {
		return rationCard;
	}
	public void setRationCard(String rationCard) {
		this.rationCard = rationCard;
	}
	public Integer getStateCode() {
		return stateCode;
	}
	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}
	@Override
	public String toString() {
		return "RationCardDetails [rationCard=" + rationCard + ", stateCode=" + stateCode + "]";
	}
    
    
    
}
