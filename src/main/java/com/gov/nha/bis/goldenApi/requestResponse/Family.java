package com.gov.nha.bis.goldenApi.requestResponse;

import java.util.List;

public class Family{
	private String hhid;
	private String scode;
	private String bentype;
	private String hhdtype;
	private String stateName;
	private List<FamilyMember> familyMember;
	public String getHhid() {
		return hhid;
	}
	public void setHhid(String hhid) {
		this.hhid = hhid;
	}
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	public String getBentype() {
		return bentype;
	}
	public void setBentype(String bentype) {
		this.bentype = bentype;
	}
	public String getHhdtype() {
		return hhdtype;
	}
	public void setHhdtype(String hhdtype) {
		this.hhdtype = hhdtype;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public List<FamilyMember> getFamilyMember() {
		return familyMember;
	}
	public void setFamilyMember(List<FamilyMember> familyMember) {
		this.familyMember = familyMember;
	}
	@Override
	public String toString() {
		return "Family [hhid=" + hhid + ", scode=" + scode + ", bentype=" + bentype + ", hhdtype=" + hhdtype
				+ ", stateName=" + stateName + ", familyMember=" + familyMember + "]";
	}
	
	
}
