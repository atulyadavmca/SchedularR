package com.gov.nha.bis.goldenApi.util;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Component
@JsonInclude(Include.NON_NULL)
public class JSONResponse {
	
	private boolean status;
	private Object data;
	private String errorcode;
	private String errorMessage;

	@JsonInclude(Include.NON_NULL)
	private String ben_status;
	
	@JsonInclude(Include.NON_NULL)
	private String operationType;
	
	@JsonInclude(Include.NON_NULL)
	private String pmjay_id;
	
	@JsonInclude(Include.NON_NULL)
	private String uidtoken;
	
	public JSONResponse() {
		// TODO Auto-generated constructor stub
	}

	public JSONResponse(boolean status, String errorcode, String errorMessage) {
		this.status = status;
		this.errorcode = errorcode;
		this.errorMessage = errorMessage;
	}
	
	public JSONResponse(boolean status, String errorcode, String errorMessage,String ben_status,String pmjay_id) {
		this.status = status;
		this.errorcode = errorcode;
		this.errorMessage = errorMessage;
		this.ben_status = ben_status;
		this.pmjay_id = pmjay_id;
	}
	
	public JSONResponse(Object data,boolean status, String operationType, String errorcode, String errorMessage,String uidtoken) {
		this.status = status;
		this.operationType = operationType;
		this.errorcode = errorcode;
		this.errorMessage = errorMessage;
		this.uidtoken = uidtoken;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
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

	@Override
	public String toString() {
		return "JSONResponse [status=" + status + ", data=" + data + ", errorcode=" + errorcode + ", errorMessage="
				+ errorMessage + ", ben_status=" + ben_status + ", operationType=" + operationType + ", pmjay_id="
				+ pmjay_id + ", uidtoken=" + uidtoken + "]";
	}

	public String getBen_status() {
		return ben_status;
	}

	public void setBen_status(String ben_status) {
		this.ben_status = ben_status;
	}

	public String getPmjay_id() {
		return pmjay_id;
	}

	public void setPmjay_id(String pmjay_id) {
		this.pmjay_id = pmjay_id;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getUidtoken() {
		return uidtoken;
	}

	public void setUidtoken(String uidtoken) {
		this.uidtoken = uidtoken;
	}
	
}

