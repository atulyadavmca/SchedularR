package com.gov.nha.bis.goldenApi.util;

import org.springframework.stereotype.Component;

import com.gov.nha.bis.goldenApi.requestResponse.CheckStatusRequest;
import com.gov.nha.bis.goldenApi.requestResponse.CommunicationApiRequest;
import com.gov.nha.bis.goldenApi.requestResponse.DeceasedPmjayIdApiRequest;
import com.gov.nha.bis.goldenApi.requestResponse.DisablePmjayIdApiRequest;
import com.gov.nha.bis.goldenApi.requestResponse.DisablePmjayIdApiRequest2;
import com.gov.nha.bis.goldenApi.requestResponse.GoldenApiRequest;
import com.gov.nha.bis.goldenApi.requestResponse.GoldenApiResponse;
import com.gov.nha.bis.goldenApi.requestResponse.LinkAadharRequest;

@Component
public class RequestValidation {
	
	public static GoldenApiResponse checkRequest(GoldenApiRequest req){
		if(req==null) {
			return new GoldenApiResponse(false,"100","req Object is null or not Valid");
		}

		if(req.getHmac() ==null || req.getHmac().isEmpty()) {
			return new GoldenApiResponse(false,"100","hmac Object is null / empty");
		}

		if(req.getToken() ==null || req.getToken().isEmpty()) {
			return new GoldenApiResponse(false,"100","token Object is null / empty");
		}
		
		if(req.getBeneficiaryDetails().getRationCardDetails()==null || req.getBeneficiaryDetails().getRationCardDetails().getStateCode()==null) {
			return new GoldenApiResponse(false,"100","statecode Object is null / empty");
		}
		
		return null;
	}
	
	public static JSONResponse checkCommunicationAddressRequest(CommunicationApiRequest req) {
		if(req==null) {
			return new JSONResponse(false,"100","req Object is null or not Valid");
		}

		if(req.getHmac() ==null || req.getHmac().isEmpty()) {
			return new JSONResponse(false,"100","hmac Object is null / empty");
		}

		if(req.getToken() ==null || req.getToken().isEmpty()) {
			return new JSONResponse(false,"100","token Object is null / empty");
		}
		
		if(req.getBeneficieryAddressDetail()==null) {
			return new JSONResponse(false,"100","beneficieryAddressDetail Object is null / empty");
		}
		
		if(req.getBeneficieryAddressDetail().getPmjayid()==null 
				|| req.getBeneficieryAddressDetail().getPmjayid().isEmpty()) {
			return new JSONResponse(false,"100","pmjayid Object is null / empty");
		}
		
		if(req.getBeneficieryAddressDetail().getAddress()==null 
				|| req.getBeneficieryAddressDetail().getAddress().isEmpty()) {
			return new JSONResponse(false,"100","address Object is null / empty");
		}
		
		return null;
	}

	public static JSONResponse checkDisablePmjayIdApiRequest(DisablePmjayIdApiRequest req) {
		if(req==null) {
			return new JSONResponse(false,"100","req Object is null or not Valid");
		}

		if(req.getPmjayId() ==null || req.getPmjayId().isEmpty()) {
			return new JSONResponse(false,"100","pmjayid Object is null / empty");
		}

		if(req.getToken() ==null || req.getToken().isEmpty()) {
			return new JSONResponse(false,"100","token Object is null / empty");
		}
		
		if(req.getStateCode() ==null || req.getToken().isEmpty()) {
			return new JSONResponse(false,"100","stateCode Object is null / empty");
		}
		
		if(req.getReason() ==null || req.getReason().isEmpty()) {
			return new JSONResponse(false,"100","reason Object is null / empty");
		}
		
		if(req.getApplicationName() ==null || req.getApplicationName().isEmpty()) {
			return new JSONResponse(false,"100","applicationName Object is null / empty");
		}
		
		return null;
	}

	public static JSONResponse checkDeceasedPmjayIdApiRequest(DeceasedPmjayIdApiRequest req) {
		if(req==null) {
			return new JSONResponse(false,"100","req Object is null or not Valid");
		}

		if(req.getPmjayId() ==null || req.getPmjayId().isEmpty()) {
			return new JSONResponse(false,"100","pmjayid Object is null / empty");
		}

		if(req.getToken() ==null || req.getToken().isEmpty()) {
			return new JSONResponse(false,"100","token Object is null / empty");
		}
		
		if(req.getStateCode() ==null || req.getStateCode().isEmpty()) {
			return new JSONResponse(false,"100","stateCode Object is null / empty");
		}
		
		if(req.getApplicationName() ==null || req.getApplicationName().isEmpty()) {
			return new JSONResponse(false,"100","applicationName Object is null / empty");
		}
		return null;
	}

	public static JSONResponse checkStatusPmjayIdApiRequest(CheckStatusRequest req) {
		if(req==null) {
			return new JSONResponse(false,"100","req Object is null or not Valid");
		}

		if((req.getPmjay_id() ==null || req.getPmjay_id().isEmpty())
				&& (req.getRef_id() ==null || req.getRef_id().isEmpty())) {
			return new JSONResponse(false,"100","pmjay_id/ref id Object is null / empty");
		}

		if(req.getToken() ==null || req.getToken().isEmpty()) {
			return new JSONResponse(false,"100","token Object is null / empty");
		}
		
		if(req.getState_code() ==null || req.getState_code().isEmpty()) {
			return new JSONResponse(false,"100","state_code Object is null / empty");
		}
		
		return null;
	}

	public static JSONResponse checkmarkAsEmergencyPmjayIdApiRequest(CheckStatusRequest req) {
		if(req==null) {
			return new JSONResponse(false,"100","req Object is null or not Valid");
		}

		if(req.getPmjay_id() ==null || req.getPmjay_id().isEmpty()) {
			return new JSONResponse(false,"100","pmjay_id Object is null / empty");
		}

		if(req.getToken() ==null || req.getToken().isEmpty()) {
			return new JSONResponse(false,"100","token Object is null / empty");
		}
		
		if(req.getState_code() ==null || req.getState_code().isEmpty()) {
			return new JSONResponse(false,"100","state_code Object is null / empty");
		}
		
		return null;
	}

	public static JSONResponse checkDisablePmjayIdApiRequest2(DisablePmjayIdApiRequest2 req) {
		if(req==null) {
			return new JSONResponse(false,"100","req Object is null or not Valid");
		}

		if(req.getPmjay_id() ==null || req.getPmjay_id().isEmpty()) {
			return new JSONResponse(false,"100","pmjayid Object is null / empty");
		}
		
		if(req.getStateCode() ==null || req.getStateCode().isEmpty()) {
			return new JSONResponse(false,"100","stateCode Object is null / empty");
		}
		
		if(req.getGuid() ==null || req.getGuid().isEmpty()) {
			return new JSONResponse(false,"100","guid Object is null / empty");
		}
		
		if(req.getVerification_status() ==null || req.getVerification_status().isEmpty()) {
			return new JSONResponse(false,"100","verification_status Object is null / empty");
		}
		
		if(req.getStateCode() ==null || req.getStateCode().isEmpty()) {
			return new JSONResponse(false,"100","stateCode Object is null / empty");
		}
		
		if(req.getOperationType() ==null || req.getOperationType().isEmpty()) {
			return new JSONResponse(false,"100","operationType Object is null / empty");
		}
		
		return null;
	}

	public static JSONResponse checkRequestLinkAadhar(LinkAadharRequest req) {
		if(req==null) {
			return new JSONResponse(false,"100","req Object is null or not Valid");
		}

		if(req.getP_aadhar() ==null || req.getP_aadhar().isEmpty()) {
			return new JSONResponse(false,"100","p_aadhar Object is null / empty");
		}
		
		if(req.getPhoto() ==null || req.getPhoto().isEmpty()) {
			return new JSONResponse(false,"100","photo Object is null / empty");
		}
		
		if(req.getPmrssm_id() ==null || req.getPmrssm_id().isEmpty()) {
			return new JSONResponse(false,"100","pmrssm_id Object is null / empty");
		}
		
		if(req.getState_code() ==null || req.getState_code().isEmpty()) {
			return new JSONResponse(false,"100","state_code Object is null / empty");
		}
		
		if(req.getUid_token() ==null || req.getUid_token().isEmpty()) {
			return new JSONResponse(false,"100","uid_token Object is null / empty");
		}
		
		return null;
	}
}
