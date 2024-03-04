package com.gov.nha.bis.goldenApi.requestResponse;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class LinkAadharRequest {
	
	private Long user_id;
	private String uid_token;
	private String pmrssm_id;
	private String p_aadhar;
	private String photo;
	private String state_code;
	private String address_ekyc;
	private String districtname_ekyc;
	private String districtname_code_ekyc;
	private String gender_ekyc;
	private String name_ekyc;
	private String pincode_ekyc;
	private String relationshipname_ekyc;
	private String relationshiptype_ekyc;
	private String statename_ekyc;
	private String type_ekyc;
	private String dob_y_ekyc;
	
	@JsonIgnore
	private String h_aadhar;
	
	public String getUid_token() {
		return uid_token;
	}
	public void setUid_token(String uid_token) {
		this.uid_token = uid_token;
	}
	public String getPmrssm_id() {
		return pmrssm_id;
	}
	public void setPmrssm_id(String pmrssm_id) {
		this.pmrssm_id = pmrssm_id;
	}
	public String getP_aadhar() {
		return p_aadhar;
	}
	public void setP_aadhar(String p_aadhar) {
		this.p_aadhar = p_aadhar;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getState_code() {
		return state_code;
	}
	public void setState_code(String state_code) {
		this.state_code = state_code;
	}
	@Override
	public String toString() {
		return "LinkAadharRequest [user_id=" + user_id + ", uid_token=" + uid_token + ", pmrssm_id=" + pmrssm_id
				+ ", p_aadhar=" + p_aadhar + ", photo=" + photo + ", state_code=" + state_code + ", address_ekyc="
				+ address_ekyc + ", districtname_ekyc=" + districtname_ekyc + ", districtname_code_ekyc="
				+ districtname_code_ekyc + ", gender_ekyc=" + gender_ekyc + ", name_ekyc=" + name_ekyc
				+ ", pincode_ekyc=" + pincode_ekyc + ", relationshipname_ekyc=" + relationshipname_ekyc
				+ ", relationshiptype_ekyc=" + relationshiptype_ekyc + ", statename_ekyc=" + statename_ekyc
				+ ", type_ekyc=" + type_ekyc + ", dob_y_ekyc=" + dob_y_ekyc + ", h_aadhar=" + h_aadhar + "]";
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getH_aadhar() {
		return h_aadhar;
	}
	public void setH_aadhar(String h_aadhar) {
		this.h_aadhar = h_aadhar;
	}
	public String getAddress_ekyc() {
		return address_ekyc;
	}
	public void setAddress_ekyc(String address_ekyc) {
		this.address_ekyc = address_ekyc;
	}
	public String getDistrictname_ekyc() {
		return districtname_ekyc;
	}
	public void setDistrictname_ekyc(String districtname_ekyc) {
		this.districtname_ekyc = districtname_ekyc;
	}
	public String getDistrictname_code_ekyc() {
		return districtname_code_ekyc;
	}
	public void setDistrictname_code_ekyc(String districtname_code_ekyc) {
		this.districtname_code_ekyc = districtname_code_ekyc;
	}
	public String getGender_ekyc() {
		return gender_ekyc;
	}
	public void setGender_ekyc(String gender_ekyc) {
		this.gender_ekyc = gender_ekyc;
	}
	public String getName_ekyc() {
		return name_ekyc;
	}
	public void setName_ekyc(String name_ekyc) {
		this.name_ekyc = name_ekyc;
	}
	public String getPincode_ekyc() {
		return pincode_ekyc;
	}
	public void setPincode_ekyc(String pincode_ekyc) {
		this.pincode_ekyc = pincode_ekyc;
	}
	public String getRelationshipname_ekyc() {
		return relationshipname_ekyc;
	}
	public void setRelationshipname_ekyc(String relationshipname_ekyc) {
		this.relationshipname_ekyc = relationshipname_ekyc;
	}
	public String getRelationshiptype_ekyc() {
		return relationshiptype_ekyc;
	}
	public void setRelationshiptype_ekyc(String relationshiptype_ekyc) {
		this.relationshiptype_ekyc = relationshiptype_ekyc;
	}
	public String getStatename_ekyc() {
		return statename_ekyc;
	}
	public void setStatename_ekyc(String statename_ekyc) {
		this.statename_ekyc = statename_ekyc;
	}
	public String getType_ekyc() {
		return type_ekyc;
	}
	public void setType_ekyc(String type_ekyc) {
		this.type_ekyc = type_ekyc;
	}
	public String getDob_y_ekyc() {
		return dob_y_ekyc;
	}
	public void setDob_y_ekyc(String dob_y_ekyc) {
		this.dob_y_ekyc = dob_y_ekyc;
	}	
	
}
