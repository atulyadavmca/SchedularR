package com.gov.nha.bis.goldenApi.requestResponse;

public class SchedulerUpdateResponse {

	private String uidToken;
	private String uidTin;
	private String uidHash;
	
	public String getUidToken() {
		return uidToken;
	}
	public void setUidToken(String uidToken) {
		this.uidToken = uidToken;
	}
	public String getUidTin() {
		return uidTin;
	}
	public void setUidTin(String uidTin) {
		this.uidTin = uidTin;
	}
	public String getUidHash() {
		return uidHash;
	}
	public void setUidHash(String uidHash) {
		this.uidHash = uidHash;
	}
	@Override
	public String toString() {
		return "SchedulerUpdateResponse [uidToken=" + uidToken + ", uidTin=" + uidTin + ", uidHash=" + uidHash + "]";
	}
	
	
}
