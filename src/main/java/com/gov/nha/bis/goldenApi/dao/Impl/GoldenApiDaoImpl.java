package com.gov.nha.bis.goldenApi.dao.Impl;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Service;
//
//import com.gov.nha.bis.goldenApi.dao.GoldenApiDao;
//import com.gov.nha.bis.goldenApi.model.BeneficieryAddressDetailEntity;
//import com.gov.nha.bis.goldenApi.properties.QueryHelperConstant;
//import com.gov.nha.bis.goldenApi.requestResponse.CheckStatusRequest;
//import com.gov.nha.bis.goldenApi.requestResponse.DeceasedPmjayIdApiRequest;
//import com.gov.nha.bis.goldenApi.requestResponse.DisablePmjayIdApiRequest;
//import com.gov.nha.bis.goldenApi.requestResponse.DisablePmjayIdApiRequest2;
//import com.gov.nha.bis.goldenApi.requestResponse.LinkAadharRequest;
//import com.gov.nha.bis.goldenApi.util.CommonUtility;
//import com.gov.nha.bis.goldenApi.util.MessageConstant;
//
//@Service
//public class GoldenApiDaoImpl implements GoldenApiDao{
//
//	@Autowired
//	CommonUtility commonUtil;
//	
//	@Autowired
//	@Qualifier("jdbcTemplateBenAll")
//	private JdbcTemplate jdbcTemplateBenAll;
//
//	@Override
//	public List<Map<String, Object>> getbenificieryDataByUuid(String uuid, String stateCode) {
//		if(!stateCode.equalsIgnoreCase(MessageConstant.TRANSGENDER)) {
//			return commonUtil.getTemplete(stateCode).queryForList(QueryHelperConstant.getbenificieryDataByUuid(),uuid,stateCode);
//		}else {
//			return commonUtil.getTemplete(stateCode).queryForList(QueryHelperConstant.getbenificieryDataByUuidTransgender(),uuid);
//		}
//	}
//
//	@Override
//	public List<Map<String, Object>> getbenificieryDataByHhId(String hhId, String stateCode) {
//		return commonUtil.getTemplete(stateCode).queryForList(QueryHelperConstant.getbenificieryDataByHhId(),hhId,stateCode);			
//	}
//
//	@Override
//	public List<Map<String, Object>> getbenificieryDataMobileNumber(String mobileNumber, String stateCode) {
//		return commonUtil.getTemplete(stateCode).queryForList(QueryHelperConstant.getbenificieryDataMobileNumber(),mobileNumber,stateCode);			
//	}
//
//	@Override
//	public List<Map<String, Object>> getbenificieryDataAadharToken(String aadharToken, String stateCode) {
//		return commonUtil.getTemplete(stateCode).queryForList(QueryHelperConstant.getbenificieryDataAadharToken(),aadharToken,stateCode);			
//	}
//
//	@Override
//	public List<Map<String, Object>> getbenificieryDataHealthId(String health_id, String stateCode) {
//		return commonUtil.getTemplete(stateCode).queryForList(QueryHelperConstant.getbenificieryDataHealthId(),health_id,stateCode);			
//	}
//
//	@Override
//	public BeneficieryAddressDetailEntity getCommunicationDetails(String pmjayid,String stateCode) {
//		BeneficieryAddressDetailEntity obj = null;List<Map<String, Object>> lst =null;
//		try {
//			lst = commonUtil.getTemplete(stateCode).queryForList(QueryHelperConstant.getCommunicationDetails(),pmjayid,stateCode);			
//			if(lst!=null && lst.size()>0) {
//				obj = new BeneficieryAddressDetailEntity();
//				obj.setAddress(String.valueOf(Optional.ofNullable(lst.get(0).get("address")).orElse("")));
//				obj.setDistrictcode(String.valueOf(Optional.ofNullable(lst.get(0).get("district_code")).orElse("")));
//				obj.setPin_code(String.valueOf(Optional.ofNullable(lst.get(0).get("pin_code")).orElse("")));
//				obj.setPmjayid(String.valueOf(Optional.ofNullable(lst.get(0).get("pmjayid")).orElse("")));
//				obj.setRefernceid(String.valueOf(Optional.ofNullable(lst.get(0).get("refernceid")).orElse("")));
//				obj.setRural_urban(String.valueOf(Optional.ofNullable(lst.get(0).get("rural_urban")).orElse("")));
//				obj.setState_code(String.valueOf(Optional.ofNullable(lst.get(0).get("state_code")).orElse("")));
//				obj.setSub_distcode(String.valueOf(Optional.ofNullable(lst.get(0).get("sub_distcode")).orElse("")));
//				obj.setVill_ward_code(String.valueOf(Optional.ofNullable(lst.get(0).get("vill_ward_code")).orElse("")));
//				obj.setVtccode(String.valueOf(Optional.ofNullable(lst.get(0).get("vtccode")).orElse("")));
//				obj.setUpdate_date(String.valueOf(Optional.ofNullable(lst.get(0).get("creation_date")).orElse("")));
//				return obj;
//			}else {
//				return null;
//			}
//		} catch (Exception e) {
//			return null;
//		}finally {
//			obj = null;lst=null;
//		}
//	}
//
//	@Override
//	public int saveCommunicationAddress(BeneficieryAddressDetailEntity e) {
//		return commonUtil.getTemplete(e.getState_code()).update(QueryHelperConstant.saveCommunicationAddress(), new Object[] {e.getPmjayid(), e.getRefernceid(), e.getRural_urban(),e.getAddress(),e.getState_code(),e.getDistrictcode(),e.getSub_distcode(),e.getVtccode(),e.getPin_code(),e.getVill_ward_code()});			
//	}
//
//	@Override
//	public int upDateBeneficiery(DisablePmjayIdApiRequest req) {
//		return commonUtil.getTemplete(req.getStateCode()).update(QueryHelperConstant.upDateBeneficieryDeathCase(),req.getUserid(),req.getReason(),req.getApplicationName(),req.getPmjayId(),req.getStateCode());			
//	}
//
//	@Override
//	public int deceasedpmjayid(DeceasedPmjayIdApiRequest e) {
//		return commonUtil.getTemplete(e.getStateCode()).update(QueryHelperConstant.deceasedpmjayid(), new Object[] {e.getPmjayId(), e.getStateCode(), e.getApplicationName(),e.getSchemeName(),e.getUser().getUserId(),e.getUser().getHospitalcodingSystem(),e.getUser().getHospitalId(),e.getStatus(),e.getDeathCertificate(),e.getDeathSummary(),e.getPlaceofDeath(),e.getDateofDeath(),e.getInstitutionalName(),e.getAddress(),e.getRemarks(),e.getReason().getDisplayreason(),e.getReason().getCodingsystem(),e.getReason().getCodevalue()});			
//	}
//
//	@Override
//	public List<Map<String, Object>> getbenificieryDataByUuidtoCheck(String uuid, String stateCode) {
//		return commonUtil.getTemplete(stateCode).queryForList(QueryHelperConstant.getbenificieryDataByUuidtoCheck(),uuid,stateCode);			
//	}
//
//	@Override
//	public List<Map<String, Object>> checkStatusPmjayid(CheckStatusRequest req) {
//		return commonUtil.getTemplete(req.getState_code()).queryForList(QueryHelperConstant.checkStatusPmjayid(),req.getPmjay_id(),req.getState_code());			
//	}
//	
//	@Override
//	public List<Map<String, Object>> checkStatusRefid(CheckStatusRequest req) {
//		return commonUtil.getTemplete(req.getState_code()).queryForList(QueryHelperConstant.checkStatusRefId(),req.getRef_id(),req.getState_code());			
//	}
//
//	@Override
//	public int markAsEmergencyPmjayId(CheckStatusRequest req) {
//		return commonUtil.getTemplete(req.getState_code()).update(QueryHelperConstant.markAsEmergencyPmjayId(), new Object[] {req.getPmjay_id(), req.getState_code()});
//	}
//
//	@Override
//	public List<Map<String, Object>> getbenificieryDataByUuidForBetaApi(String uuid, String stateCode) {
//		return commonUtil.getTemplete(stateCode).queryForList(QueryHelperConstant.getbenificieryDataByUuidBetaApi(),uuid,stateCode);
//	}
//
//	@Override
//	public List<Map<String, Object>> getbenificieryDataByHhIdForBetaApi(String ahl_hhid, String stateCode) {
//		return commonUtil.getTemplete(stateCode).queryForList(QueryHelperConstant.getbenificieryDataByHhIdBetaApi(),ahl_hhid,stateCode);
//	}
//
//	@Override
//	public int upDateBeneficiery2(DisablePmjayIdApiRequest2 req) {
//		return commonUtil.getTemplete(req.getStateCode()).update(QueryHelperConstant.upDateBeneficieryDeathCase2(),req.getVerification_status(),req.getUserid(),req.getOperationType(),req.getPmjay_id(),req.getStateCode(),req.getGuid());
//	}
//
//	@Override
//	public int insertDisablePmjayIdMissingInTDataEntry(DisablePmjayIdApiRequest2 req) {
//		return commonUtil.getTemplete(req.getStateCode()).update(QueryHelperConstant.insertDisablePmjayIdMissingInTDataEntry(),req.getPmjay_id(),req.getOperationType(),req.getGuid(),req.getStateCode(),req.getVerification_status(),req.getUserid());
//	}
//
//	@Override
//	public int insertIntoTDataEntryAadhar(LinkAadharRequest req) {
//		return jdbcTemplateBenAll.update(QueryHelperConstant.insertIntoTDataEntryAadhar(),req.getPmrssm_id(),req.getUser_id(),req.getH_aadhar(),req.getPhoto(),req.getState_code(),req.getAddress_ekyc(),req.getDistrictname_ekyc(),Integer.valueOf(req.getDistrictname_code_ekyc()),req.getGender_ekyc(),req.getName_ekyc(),req.getPincode_ekyc(),req.getRelationshipname_ekyc(),req.getRelationshiptype_ekyc(),req.getStatename_ekyc(),req.getType_ekyc(),req.getDob_y_ekyc());
//	}
//
//	@Override
//	public int updateTDataEntryStateWise(LinkAadharRequest req) {
//		return commonUtil.getTemplete(req.getState_code()).update(QueryHelperConstant.updateTDataEntryStateWise(),req.getUid_token(),req.getPhoto(),req.getName_ekyc(),req.getDob_y_ekyc(),req.getGender_ekyc(),req.getAddress_ekyc(),req.getDistrictname_ekyc(),Integer.valueOf(req.getDistrictname_code_ekyc()),req.getStatename_ekyc(),req.getPincode_ekyc(),req.getRelationshipname_ekyc(),req.getRelationshiptype_ekyc(),req.getUser_id(),req.getPmrssm_id(),req.getState_code());
//	}
//
//}
