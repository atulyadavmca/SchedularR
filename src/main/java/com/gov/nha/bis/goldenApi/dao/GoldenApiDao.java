package com.gov.nha.bis.goldenApi.dao;
//
//import java.util.List;
//import java.util.Map;
//
//import com.gov.nha.bis.goldenApi.model.BeneficieryAddressDetailEntity;
//import com.gov.nha.bis.goldenApi.requestResponse.CheckStatusRequest;
//import com.gov.nha.bis.goldenApi.requestResponse.DeceasedPmjayIdApiRequest;
//import com.gov.nha.bis.goldenApi.requestResponse.DisablePmjayIdApiRequest;
//import com.gov.nha.bis.goldenApi.requestResponse.DisablePmjayIdApiRequest2;
//import com.gov.nha.bis.goldenApi.requestResponse.LinkAadharRequest;
//
//public interface GoldenApiDao {
//
//	List<Map<String, Object>> getbenificieryDataByUuid(String uuid, String statecode);
//
//	List<Map<String, Object>> getbenificieryDataByHhId(String hhId,String stateCode);
//
//	List<Map<String, Object>> getbenificieryDataMobileNumber(String mobileNumber, String stateCode);
//
//	List<Map<String, Object>> getbenificieryDataAadharToken(String aadharToken,String stateCode);
//
//	List<Map<String, Object>> getbenificieryDataHealthId(String health_id,String stateCode);
//
//	BeneficieryAddressDetailEntity getCommunicationDetails(String pmjayid,String stateCode);
//
//	int saveCommunicationAddress(BeneficieryAddressDetailEntity beneficieryAddressDetail);
//
//	int upDateBeneficiery(DisablePmjayIdApiRequest req);
//
//	int deceasedpmjayid(DeceasedPmjayIdApiRequest req);
//
//	List<Map<String, Object>> getbenificieryDataByUuidtoCheck(String uuid, String stateCode);
//
//	List<Map<String, Object>> checkStatusPmjayid(CheckStatusRequest req);
//	
//	List<Map<String, Object>> checkStatusRefid(CheckStatusRequest req);
//
//	int markAsEmergencyPmjayId(CheckStatusRequest req);
//
//	List<Map<String, Object>> getbenificieryDataByUuidForBetaApi(String uuid, String stateCode);
//
//	List<Map<String, Object>> getbenificieryDataByHhIdForBetaApi(String ahl_hhid, String stateCode);
//
//	int upDateBeneficiery2(DisablePmjayIdApiRequest2 req);
//
//	int insertDisablePmjayIdMissingInTDataEntry(DisablePmjayIdApiRequest2 req);
//
//	int insertIntoTDataEntryAadhar(LinkAadharRequest req);
//
//	int updateTDataEntryStateWise(LinkAadharRequest req);	
//	
//}
