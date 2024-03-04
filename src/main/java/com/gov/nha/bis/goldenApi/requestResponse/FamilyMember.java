package com.gov.nha.bis.goldenApi.requestResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gov.nha.bis.goldenApi.model.BeneficieryAddressDetailEntity;

public class FamilyMember{
    private String careOfTypeDec;
    private String careOfDec;
    private String memberName;
    private String fatherName;
    private String gender;
    private String yearOfBirth;
    private String photo;
    private String mobileNumber;
    private Address address;
    private String venderToken;
    private String tempId;
    private String dependent_flag;
    private String member_id;
    private String dateofbirth;
    private String agegroup;
    private String card_delivery_status;
    private String card_delivery_date;
    private String health_id;
    private String nhaid;
    private String aaa_enrollment_date;
    private String aaa_expiry_date;
    private String aaa_flag;
    private String s_flag;
    private String aaa_URN;
    private String familyDocTyp;
    private String familyDocId;
    private BeneficieryAddressDetailEntity communication_address;
    
    @JsonInclude(Include.NON_NULL)
    private String verification_status;
    
	public BeneficieryAddressDetailEntity getCommunication_address() {
		return communication_address;
	}
	public void setCommunication_address(BeneficieryAddressDetailEntity communication_address) {
		this.communication_address = communication_address;
	}
    
	public String getCareOfTypeDec() {
		return careOfTypeDec;
	}
	public void setCareOfTypeDec(String careOfTypeDec) {
		this.careOfTypeDec = careOfTypeDec;
	}
	public String getCareOfDec() {
		return careOfDec;
	}
	public void setCareOfDec(String careOfDec) {
		this.careOfDec = careOfDec;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(String yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getVenderToken() {
		return venderToken;
	}
	public void setVenderToken(String venderToken) {
		this.venderToken = venderToken;
	}
	public String getTempId() {
		return tempId;
	}
	public void setTempId(String tempId) {
		this.tempId = tempId;
	}
	public String getDependent_flag() {
		return dependent_flag;
	}
	public void setDependent_flag(String dependent_flag) {
		this.dependent_flag = dependent_flag;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getAgegroup() {
		return agegroup;
	}
	public void setAgegroup(String agegroup) {
		this.agegroup = agegroup;
	}
	public String getCard_delivery_status() {
		return card_delivery_status;
	}
	public void setCard_delivery_status(String card_delivery_status) {
		this.card_delivery_status = card_delivery_status;
	}
	public String getCard_delivery_date() {
		return card_delivery_date;
	}
	public void setCard_delivery_date(String card_delivery_date) {
		this.card_delivery_date = card_delivery_date;
	}
	public String getHealth_id() {
		return health_id;
	}
	public void setHealth_id(String health_id) {
		this.health_id = health_id;
	}
	public String getNhaid() {
		return nhaid;
	}
	public void setNhaid(String nhaid) {
		this.nhaid = nhaid;
	}
	public String getAaa_enrollment_date() {
		return aaa_enrollment_date;
	}
	public void setAaa_enrollment_date(String aaa_enrollment_date) {
		this.aaa_enrollment_date = aaa_enrollment_date;
	}
	public String getAaa_expiry_date() {
		return aaa_expiry_date;
	}
	public void setAaa_expiry_date(String aaa_expiry_date) {
		this.aaa_expiry_date = aaa_expiry_date;
	}
	public String getAaa_flag() {
		return aaa_flag;
	}
	public void setAaa_flag(String aaa_flag) {
		this.aaa_flag = aaa_flag;
	}
	public String getS_flag() {
		return s_flag;
	}
	public void setS_flag(String s_flag) {
		this.s_flag = s_flag;
	}
	public String getAaa_URN() {
		return aaa_URN;
	}
	public void setAaa_URN(String aaa_URN) {
		this.aaa_URN = aaa_URN;
	}
	public String getFamilyDocTyp() {
		return familyDocTyp;
	}
	public void setFamilyDocTyp(String familyDocTyp) {
		this.familyDocTyp = familyDocTyp;
	}
	public String getFamilyDocId() {
		return familyDocId;
	}
	public void setFamilyDocId(String familyDocId) {
		this.familyDocId = familyDocId;
	}
	@Override
	public String toString() {
		return "FamilyMember [careOfTypeDec=" + careOfTypeDec + ", careOfDec=" + careOfDec + ", memberName="
				+ memberName + ", fatherName=" + fatherName + ", gender=" + gender + ", yearOfBirth=" + yearOfBirth
				+ ", photo=" + photo + ", mobileNumber=" + mobileNumber + ", address=" + address + ", venderToken="
				+ venderToken + ", tempId=" + tempId + ", dependent_flag=" + dependent_flag + ", member_id=" + member_id
				+ ", dateofbirth=" + dateofbirth + ", agegroup=" + agegroup + ", card_delivery_status="
				+ card_delivery_status + ", card_delivery_date=" + card_delivery_date + ", health_id=" + health_id
				+ ", nhaid=" + nhaid + ", aaa_enrollment_date=" + aaa_enrollment_date + ", aaa_expiry_date="
				+ aaa_expiry_date + ", aaa_flag=" + aaa_flag + ", s_flag=" + s_flag + ", aaa_URN=" + aaa_URN
				+ ", familyDocTyp=" + familyDocTyp + ", familyDocId=" + familyDocId + ", communication_address="
				+ communication_address + ", verification_status=" + verification_status + "]";
	}
	public String getVerification_status() {
		return verification_status;
	}
	public void setVerification_status(String verification_status) {
		this.verification_status = verification_status;
	}
    
    
}
