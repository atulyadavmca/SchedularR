package com.gov.nha.bis.goldenApi.requestResponse;

public class DeceasedReason{
    private String displayreason;
    private String codingsystem;
    private String codevalue;
	
    public String getDisplayreason() {
		return displayreason;
	}
	public void setDisplayreason(String displayreason) {
		this.displayreason = displayreason;
	}
	public String getCodingsystem() {
		return codingsystem;
	}
	public void setCodingsystem(String codingsystem) {
		this.codingsystem = codingsystem;
	}
	public String getCodevalue() {
		return codevalue;
	}
	public void setCodevalue(String codevalue) {
		this.codevalue = codevalue;
	}
}
