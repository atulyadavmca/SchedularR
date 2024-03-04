package com.gov.nha.bis.goldenApi.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BeneficieryAddressDetailEntity {

	private Long id;

    private String pmjayid;
	
	private String refernceid;

	private String rural_urban;

	private String address;
	
	private String state_code;
	
	private String districtcode;
	
	private String sub_distcode;
	
	private String vtccode;
	
	private String pin_code;
	
	private String vill_ward_code;

	@JsonIgnore
	private Date creation_Date;
	
	private String update_date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPmjayid() {
		return pmjayid;
	}

	public void setPmjayid(String pmjayid) {
		this.pmjayid = pmjayid;
	}

	public String getRefernceid() {
		return refernceid;
	}

	public void setRefernceid(String refernceid) {
		this.refernceid = refernceid;
	}

	public String getRural_urban() {
		return rural_urban;
	}

	public void setRural_urban(String rural_urban) {
		this.rural_urban = rural_urban;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState_code() {
		return state_code;
	}

	public void setState_code(String state_code) {
		this.state_code = state_code;
	}

	public String getDistrictcode() {
		return districtcode;
	}

	public void setDistrictcode(String districtcode) {
		this.districtcode = districtcode;
	}

	public String getSub_distcode() {
		return sub_distcode;
	}

	public void setSub_distcode(String sub_distcode) {
		this.sub_distcode = sub_distcode;
	}

	public String getVtccode() {
		return vtccode;
	}

	public void setVtccode(String vtccode) {
		this.vtccode = vtccode;
	}

	public String getPin_code() {
		return pin_code;
	}

	public void setPin_code(String pin_code) {
		this.pin_code = pin_code;
	}

	public Date getCreation_Date() {
		return creation_Date;
	}

	public void setCreation_Date(Date creation_Date) {
		this.creation_Date = creation_Date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	@Override
	public String toString() {
		return "BeneficieryAddressDetailEntity [id=" + id + ", pmjayid=" + pmjayid + ", refernceid=" + refernceid
				+ ", rural_urban=" + rural_urban + ", address=" + address + ", state_code=" + state_code
				+ ", districtcode=" + districtcode + ", sub_distcode=" + sub_distcode + ", vtccode=" + vtccode
				+ ", pin_code=" + pin_code + ", creation_Date=" + creation_Date + ", update_date=" + update_date + "]";
	}

	public String getVill_ward_code() {
		return vill_ward_code;
	}

	public void setVill_ward_code(String vill_ward_code) {
		this.vill_ward_code = vill_ward_code;
	}
	
}
