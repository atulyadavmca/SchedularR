package com.gov.nha.bis.goldenApi.requestResponse;

public class Address{
    private String statelgdCode;
    private String benstatelgdCode;
    private String districtlgdCode;
    private String subdistrictlgdCode;
    private String bendistrictlgdCode;
    private String address;
    private String village_townlgdCode;
    private String ruralUrban;
    private String pinCode;
	public String getStatelgdCode() {
		return statelgdCode;
	}
	public void setStatelgdCode(String statelgdCode) {
		this.statelgdCode = statelgdCode;
	}
	public String getBenstatelgdCode() {
		return benstatelgdCode;
	}
	public void setBenstatelgdCode(String benstatelgdCode) {
		this.benstatelgdCode = benstatelgdCode;
	}
	public String getDistrictlgdCode() {
		return districtlgdCode;
	}
	public void setDistrictlgdCode(String districtlgdCode) {
		this.districtlgdCode = districtlgdCode;
	}
	public String getSubdistrictlgdCode() {
		return subdistrictlgdCode;
	}
	public void setSubdistrictlgdCode(String subdistrictlgdCode) {
		this.subdistrictlgdCode = subdistrictlgdCode;
	}
	public String getBendistrictlgdCode() {
		return bendistrictlgdCode;
	}
	public void setBendistrictlgdCode(String bendistrictlgdCode) {
		this.bendistrictlgdCode = bendistrictlgdCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVillage_townlgdCode() {
		return village_townlgdCode;
	}
	public void setVillage_townlgdCode(String village_townlgdCode) {
		this.village_townlgdCode = village_townlgdCode;
	}
	public String getRuralUrban() {
		return ruralUrban;
	}
	public void setRuralUrban(String ruralUrban) {
		this.ruralUrban = ruralUrban;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public String toString() {
		return "Address [statelgdCode=" + statelgdCode + ", benstatelgdCode=" + benstatelgdCode + ", districtlgdCode="
				+ districtlgdCode + ", subdistrictlgdCode=" + subdistrictlgdCode + ", bendistrictlgdCode="
				+ bendistrictlgdCode + ", address=" + address + ", village_townlgdCode=" + village_townlgdCode
				+ ", ruralUrban=" + ruralUrban + ", pinCode=" + pinCode + "]";
	}
    
    
}
