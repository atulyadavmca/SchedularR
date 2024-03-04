package com.gov.nha.bis.goldenApi.requestResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class GoldenApiResponse{
	private boolean status;
	private String operation;
	private String errorcode;
	private String errorMessage;
	
	@JsonInclude(Include.NON_NULL)
	private Header header;
	
	@JsonInclude(Include.NON_NULL)
	private FamilySearchDetails familySearchDetails;
	
	public GoldenApiResponse(boolean status,String errorcode,String errorMessage) {
		this.status = status;
		this.errorcode = errorcode;
		this.errorMessage = errorMessage;
	}
	
	public GoldenApiResponse() {
		// TODO Auto-generated constructor stub
	}

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	public FamilySearchDetails getFamilySearchDetails() {
		return familySearchDetails;
	}
	public void setFamilySearchDetails(FamilySearchDetails familySearchDetails) {
		this.familySearchDetails = familySearchDetails;
	}
	@Override
	public String toString() {
		return "GoldenApiResponse [status=" + status + ", operation=" + operation + ", errorcode=" + errorcode
				+ ", errorMessage=" + errorMessage + ", header=" + header + ", familySearchDetails="
				+ familySearchDetails + "]";
	}
	
	
}