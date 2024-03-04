package com.gov.nha.bis.goldenApi.serviceImpl;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import org.hibernate.exception.ConstraintViolationException;
//import org.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.ObjectUtils;
//
//import com.google.gson.Gson;
//import com.gov.nha.bis.goldenApi.dao.GoldenApiDao;
//import com.gov.nha.bis.goldenApi.dao.SilverApiDao;
//import com.gov.nha.bis.goldenApi.model.BeneficieryAddressDetailEntity;
//import com.gov.nha.bis.goldenApi.properties.ApplicationConstantConfig;
//import com.gov.nha.bis.goldenApi.requestResponse.Address;
//import com.gov.nha.bis.goldenApi.requestResponse.CheckStatusRequest;
//import com.gov.nha.bis.goldenApi.requestResponse.CommunicationApiRequest;
//import com.gov.nha.bis.goldenApi.requestResponse.DeceasedPmjayIdApiRequest;
//import com.gov.nha.bis.goldenApi.requestResponse.DisablePmjayIdApiRequest;
//import com.gov.nha.bis.goldenApi.requestResponse.DisablePmjayIdApiRequest2;
//import com.gov.nha.bis.goldenApi.requestResponse.Family;
//import com.gov.nha.bis.goldenApi.requestResponse.FamilyMember;
//import com.gov.nha.bis.goldenApi.requestResponse.FamilySearchDetails;
//import com.gov.nha.bis.goldenApi.requestResponse.GoldenApiRequest;
//import com.gov.nha.bis.goldenApi.requestResponse.GoldenApiResponse;
//import com.gov.nha.bis.goldenApi.requestResponse.Header;
//import com.gov.nha.bis.goldenApi.requestResponse.LinkAadharRequest;
//import com.gov.nha.bis.goldenApi.service.GoldenApiService;
//import com.gov.nha.bis.goldenApi.util.CommonCryptor;
//import com.gov.nha.bis.goldenApi.util.CommonUtility;
//import com.gov.nha.bis.goldenApi.util.CustomException;
//import com.gov.nha.bis.goldenApi.util.JSONResponse;
//import com.gov.nha.bis.goldenApi.util.MessageConstant;
//
//@Service
//public class GoldenApiServiceImpl implements GoldenApiService{
//
//	private static final Logger logger = LoggerFactory.getLogger(GoldenApiServiceImpl.class); 
//
//	@Autowired
//	GoldenApiDao apiDao;
//
//	@Autowired
//	SilverApiDao silverApi;
//
//	@Autowired
//	CommonUtility commonUtility;
//
//	@Autowired
//	ApplicationConstantConfig config;
//
//	@Override
//	public GoldenApiResponse getgoldenApiData(GoldenApiRequest req) {
//		List<Map<String,Object>>  benData = null;
//		String stateCode = String.valueOf(req.getBeneficiaryDetails().getRationCardDetails().getStateCode());
//		try {				
//			if(req.getBeneficiaryDetails().getUuid()!=null && !req.getBeneficiaryDetails().getUuid().isEmpty()) {
//				//find by UUID
//				benData = apiDao.getbenificieryDataByUuid(req.getBeneficiaryDetails().getUuid(),stateCode);
//
//			}else if(req.getBeneficiaryDetails().getHhId()!=null && !req.getBeneficiaryDetails().getHhId().isEmpty()) {
//				//find by aadhar token
//				benData = apiDao.getbenificieryDataByHhId(req.getBeneficiaryDetails().getHhId(),stateCode);
//
//			}else if (req.getBeneficiaryDetails().getMobileNumber()!=null && !req.getBeneficiaryDetails().getMobileNumber().isEmpty()){
//
//				return new GoldenApiResponse(false,"101","Invalid Search");
//				//find by mobile Number
//				//benData = apiDao.getbenificieryDataMobileNumber(req.getBeneficiaryDetails().getMobileNumber(),stateCode);
//
//			}else if(req.getBeneficiaryDetails().getAadharToken()!=null && !req.getBeneficiaryDetails().getAadharToken().isEmpty()) {
//				//find by aadhar token
//				benData = apiDao.getbenificieryDataAadharToken(req.getBeneficiaryDetails().getAadharToken(),stateCode);
//
//			}else if(req.getBeneficiaryDetails().getHealth_id()!=null && !req.getBeneficiaryDetails().getHealth_id().isEmpty()) {
//				//find by health id
//				benData = apiDao.getbenificieryDataHealthId(req.getBeneficiaryDetails().getHealth_id(),stateCode);
//			}else {
//				return new GoldenApiResponse(false,"101","Invalid Search");
//			}
//
//			if(benData!=null && benData.size()>0) {
//				switch (benData.get(0).get("verification_status").toString()) {
//				case "G":
//					break;	
//				case "A":
//					break;
//				case "W":
//					return new GoldenApiResponse(false,"101",MessageConstant.REJECTED_W);
//				case "R":
//					return new GoldenApiResponse(false,"101",MessageConstant.REJECTED_R);
//				case "Z":
//					return new GoldenApiResponse(false,"101",MessageConstant.CARD_IS_DISABLED);
//				case "C":
//					return new GoldenApiResponse(false,"101",MessageConstant.REJECTED_C);
//				default:
//					return new GoldenApiResponse(false,"101",MessageConstant.RECORD_NOT_FOUND);
//				}
//			}
//
//			if(benData==null || benData.size()==0) {
//				GoldenApiResponse goldenapione = getgoldenapi1_0Response(req);
//
//				if(goldenapione!=null && goldenapione.isStatus()) {
//					return goldenapione;
//				}else if(goldenapione!=null && !goldenapione.isStatus() &&
//						goldenapione.getErrorcode()!=null && !goldenapione.getErrorcode().trim().equalsIgnoreCase("")) {
//					return new GoldenApiResponse(false,goldenapione.getErrorcode(),goldenapione.getErrorMessage());	
//				}else {
//					return new GoldenApiResponse(false,"101",MessageConstant.RECORD_NOT_FOUND);
//				}
//			}
//
//			return getgoldenApiDataByPmjayId(benData,req,stateCode);
//		} catch (Exception e) {
//			if(req.getBeneficiaryDetails().getRationCardDetails().getStateCode()==9) {
//				GoldenApiResponse goldenapione = getgoldenapi1_0Response(req);
//
//				if(goldenapione!=null && goldenapione.isStatus()) {
//					return goldenapione;
//				}else if(goldenapione!=null && !goldenapione.isStatus() &&
//						goldenapione.getErrorcode()!=null && !goldenapione.getErrorcode().trim().equalsIgnoreCase("")) {
//					return new GoldenApiResponse(false,goldenapione.getErrorcode(),goldenapione.getErrorMessage());	
//				}else {
//					return new GoldenApiResponse(false,"101",MessageConstant.RECORD_NOT_FOUND);
//				}
//			}
//			e.printStackTrace();
//			return new GoldenApiResponse(false,"101",MessageConstant.SOMETHING_WENT_WRONG);
//		}finally {
//			benData=null;
//		}
//	}
//
//	private GoldenApiResponse getgoldenapi1_0Response(GoldenApiRequest req) {
//		String response  =null;Gson gsonObj = new Gson();
//		try {
//			req.setHmac("212");
//			req.setToken("716558b4-fdba-4701-b06a-d211f4b60d7b");
//			Gson g = new Gson();
//			response =  CommonUtility.userRequest(null, g.toJson(req), config.GOLDEN_API_TCS_10,null,null);
//			if(response !=null) {
//				return gsonObj.fromJson(response, GoldenApiResponse.class);
//			}else {
//				return null;
//			}	
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}finally {
//			response  =null;gsonObj=null;
//		}
//	}
//
//	public GoldenApiResponse getgoldenApiDataByPmjayId(List<Map<String,Object>>  benData,GoldenApiRequest req,String stateCode) {
//		logger.info("getgoldenApiData service imple Starts");
//		GoldenApiResponse response = new GoldenApiResponse();
//		Header header = new Header();
//		FamilySearchDetails familySearchDetails = new FamilySearchDetails();
//		List<Family> familylist = new ArrayList<Family>();
//		Family family = new Family();
//		List<FamilyMember> familyMemberList = new ArrayList<FamilyMember>();
//		try {
//			for (Map<String,Object> beneficiaryCardDetailsEntity : benData) {
//				FamilyMember familyMember = new FamilyMember();
//				familyMember.setMobileNumber(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("mobile_member")).orElse("")));
//				familyMember.setNhaid(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("pmrssm_id")).orElse("")));
//				familyMember.setHealth_id(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("health_id")).orElse("")));
//				familyMember.setVenderToken(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("uid_token")).orElse("")));
//				familyMember.setMember_id(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("ahl_tin")).orElse("")));
//				familyMember.setCommunication_address(Optional.ofNullable(apiDao.getCommunicationDetails(familyMember.getNhaid(),stateCode)).orElse(null));
//				familyMember.setAaa_flag("N");
//				familyMember.setCard_delivery_date(null);
//				familyMember.setCard_delivery_status(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("card_delivery_status")).orElse("")));
//
//				if(beneficiaryCardDetailsEntity.get("gender_ben")!=null 
//						&& !beneficiaryCardDetailsEntity.get("gender_ben").toString().equalsIgnoreCase("")) {
//					if(beneficiaryCardDetailsEntity.get("gender_ben").toString().equalsIgnoreCase("Male")) {
//						familyMember.setGender("M");
//					}else if(beneficiaryCardDetailsEntity.get("gender_ben").toString().equalsIgnoreCase("Female")) {
//						familyMember.setGender("F");
//					}else if(beneficiaryCardDetailsEntity.get("gender_ben").toString().equalsIgnoreCase("Other")) {
//						familyMember.setGender("T");
//					}else {
//						familyMember.setGender(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("gender_ben")).orElse("")));
//					}
//				}else {
//					return new GoldenApiResponse(false,"101",MessageConstant.RECORD_NOT_CORRECT);
//				}
//
//				if(beneficiaryCardDetailsEntity.get("name_ben")!=null 
//						&& !beneficiaryCardDetailsEntity.get("name_ben").toString().equalsIgnoreCase("")
//						&& !beneficiaryCardDetailsEntity.get("name_ben").toString().equalsIgnoreCase("NA")) {
//					familyMember.setMemberName(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("name_ben")).orElse("")));
//				}else {
//					return new GoldenApiResponse(false,"101",MessageConstant.RECORD_NOT_CORRECT);
//				}
//
//				if(beneficiaryCardDetailsEntity.get("dob_ben")!=null 
//						&& !beneficiaryCardDetailsEntity.get("dob_ben").toString().equalsIgnoreCase("")
//						&& !beneficiaryCardDetailsEntity.get("dob_ben").toString().equalsIgnoreCase("NaN-NaN-NaN")) {
//					familyMember.setYearOfBirth(CommonUtility.fingYearInGivenString(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("dob_ben")).orElse(""))));
//				}else {
//					return new GoldenApiResponse(false,"101",MessageConstant.RECORD_NOT_CORRECT);
//				}
//
//				familyMember.setCareOfDec(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("care_of_dec")).orElse("")));
//				familyMember.setFatherName(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("father_name_secc")).orElse("")));
//				familyMember.setCareOfTypeDec(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("care_of_type_dec")).orElse("")));
//				familyMember.setFamilyDocId(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("fam_doc_number")).orElse("")));
//				familyMember.setFamilyDocTyp(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("fam_doc_type")).orElse("")));
//				family.setHhid(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("ahl_hhid")).orElse("")));
//				family.setScode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("state_code")).orElse("")));
//				family.setBentype(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("source_of_data")).orElse("")));
//				family.setHhdtype(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("source_of_data")).orElse("")));
//				family.setStateName(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("state_name_ben")).orElse("")));
//
//				if(stateCode.equalsIgnoreCase(MessageConstant.ASSAM) 
//						&&	!family.getBentype().equalsIgnoreCase("")
//						&& family.getBentype().equalsIgnoreCase("OA")) {
//					familyMember.setAaa_flag(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("is_bpl_apl")).orElse("")));
//					familyMember.setAaa_expiry_date(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("dateofexpiry")).orElse("")));
//					familyMember.setAaa_enrollment_date(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("dateofissue")).orElse("")));
//					familyMember.setAaa_URN(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("aaa_urn")).orElse("")));
//				}else {
//					familyMember.setAaa_flag("N");
//					familyMember.setAaa_expiry_date("");
//					familyMember.setAaa_enrollment_date("");
//					familyMember.setAaa_URN("");
//				}
//
//				Address address = new Address();
//				address.setAddress(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("address_ben")).orElse("")));
//				address.setRuralUrban(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("rural_urban_ben")).orElse("")));
//				if(stateCode.equalsIgnoreCase(MessageConstant.TRANSGENDER)) {
//					address.setStatelgdCode("96");
//					address.setDistrictlgdCode("996");
//				}else {
//					address.setStatelgdCode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("state_codelgd_ben")).orElse("")));
//					address.setDistrictlgdCode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("district_codelgd_ben")).orElse("")));
//				}
//				address.setBenstatelgdCode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("state_codelgd_ben")).orElse("")));
//				address.setBendistrictlgdCode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("district_codelgd_ben")).orElse("")));
//				address.setSubdistrictlgdCode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("subdistrict_codelgd_ben")).orElse("")));
//				address.setVillage_townlgdCode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("villagetown_code_lgd_ben")).orElse("")));
//				address.setPinCode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("pin_code_ben")).orElse("")));
//
//				if(beneficiaryCardDetailsEntity.get("doc_pic")!=null
//						&& !beneficiaryCardDetailsEntity.get("doc_pic").toString().equalsIgnoreCase("")) {
//					familyMember.setPhoto(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("doc_pic")).orElse("")));
//				}else {
//					GoldenApiResponse goldenapione = getgoldenapi1_0Response(req);
//
//					if(goldenapione!=null && goldenapione.isStatus()) {
//						return goldenapione;
//					}
//					//familyMember.setPhoto(getPhoto(familyMember.getNhaid(),stateCode));
//				}
//
//				familyMember.setAddress(address);
//				familyMemberList.add(familyMember);
//			}
//
//			//set family details
//			family.setFamilyMember(familyMemberList);
//			familylist.add(family);
//			familySearchDetails.setFamily(familylist);
//			response.setFamilySearchDetails(familySearchDetails);
//
//			//set header details
//			header.setBeneficiaryDetails(req.getBeneficiaryDetails());
//			header.setErrorCode("");
//			header.setVersion("2.0");
//			response.setHeader(header);
//
//			//set other respose status
//			response.setStatus(true);
//			response.setErrorcode("0");
//			response.setErrorMessage("");
//			response.setOperation("");
//			return response;
//		} catch (CustomException e) {
//			e.printStackTrace();
//			return new GoldenApiResponse(false,"101",MessageConstant.RECORD_NOT_CORRECT);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new GoldenApiResponse(false,"101",MessageConstant.SOMETHING_WENT_WRONG);
//		}finally {
//			benData=null;header=null;familylist=null;family=null;familyMemberList=null;familySearchDetails=null;
//		}
//	}
//
//	@Override
//	public JSONResponse saveCommunicationAddress(CommunicationApiRequest req) {
//		BeneficieryAddressDetailEntity object = null;
//		try {
//			object = apiDao.getCommunicationDetails(req.getBeneficieryAddressDetail().getPmjayid(),String.valueOf(req.getBeneficieryAddressDetail().getState_code()));
//			if(object!=null) {
//				req.getBeneficieryAddressDetail().setId(object.getId());
//				req.getBeneficieryAddressDetail().setUpdate_date(object.getUpdate_date());
//				apiDao.saveCommunicationAddress(req.getBeneficieryAddressDetail());
//			}else {
//				apiDao.saveCommunicationAddress(req.getBeneficieryAddressDetail());
//			}
//			return new JSONResponse(true,"200",MessageConstant.RESPONSE_SUCCESS);
//		} catch (ConstraintViolationException e) {
//			e.printStackTrace();
//			return new JSONResponse(false,"102","Data Already Exist");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new JSONResponse(false,"101",MessageConstant.SOMETHING_WENT_WRONG);
//		}
//	}
//
//	@Override
//	public GoldenApiResponse getSilverApiData(GoldenApiRequest req) {
//		List<Map<String,Object>>  benData = null;
//		String stateCode = String.valueOf(req.getBeneficiaryDetails().getRationCardDetails().getStateCode());
//		try {				
//			if(req.getBeneficiaryDetails().getUuid()!=null && !req.getBeneficiaryDetails().getUuid().isEmpty()) {
//				//find by UUID
//				benData = silverApi.getbenificieryDataByUuid(req.getBeneficiaryDetails().getUuid(),stateCode);
//
//			}else if(req.getBeneficiaryDetails().getHhId()!=null && !req.getBeneficiaryDetails().getHhId().isEmpty()) {
//				//find by aadhar token
//				benData = silverApi.getbenificieryDataByHhId(req.getBeneficiaryDetails().getHhId(),stateCode);
//
//			}else if (req.getBeneficiaryDetails().getMobileNumber()!=null && !req.getBeneficiaryDetails().getMobileNumber().isEmpty()){
//
//				//find by mobile Number
//				benData = silverApi.getbenificieryDataMobileNumber(req.getBeneficiaryDetails().getMobileNumber(),stateCode);
//
//			}else if(req.getBeneficiaryDetails().getAadharToken()!=null && !req.getBeneficiaryDetails().getAadharToken().isEmpty()) {
//				//find by aadhar token
//				benData = silverApi.getbenificieryDataAadharToken(req.getBeneficiaryDetails().getAadharToken(),stateCode);
//
//			}else if(req.getBeneficiaryDetails().getHealth_id()!=null && !req.getBeneficiaryDetails().getHealth_id().isEmpty()) {
//				//find by health id
//				benData = silverApi.getbenificieryDataHealthId(req.getBeneficiaryDetails().getHealth_id(),stateCode);
//			}else {
//				return new GoldenApiResponse(false,"101","Invalid Search");
//			}
//
//			if(benData==null || benData.size()==0) {
//				return new GoldenApiResponse(false,"100","No record found");
//			}
//
//			return getSilverApiDataByPmjayId(benData,req,stateCode);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new GoldenApiResponse(false,"101","Invalid Search");
//		}finally {
//			benData=null;
//		}
//	}
//
//
//	public GoldenApiResponse getSilverApiDataByPmjayId(List<Map<String,Object>>  benData,GoldenApiRequest req,String stateCode) {
//		logger.info("getSilverApiDataByPmjayId service imple Starts");
//		GoldenApiResponse response = new GoldenApiResponse();
//		Header header = new Header();
//		FamilySearchDetails familySearchDetails = new FamilySearchDetails();
//		List<Family> familylist = new ArrayList<Family>();
//		Family family = new Family();
//		List<FamilyMember> familyMemberList = new ArrayList<FamilyMember>();
//		try {
//			for (Map<String,Object> beneficiaryCardDetailsEntity : benData) {
//				FamilyMember familyMember = new FamilyMember();
//				familyMember.setMobileNumber(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("mobile_member")).orElse("")));
//				familyMember.setNhaid(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("pmrssm_id")).orElse("")));
//				familyMember.setHealth_id(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("health_id")).orElse("")));
//				familyMember.setVenderToken(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("uid_token")).orElse("")));
//				familyMember.setMember_id(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("ahl_tin")).orElse("")));
//				familyMember.setCommunication_address(Optional.ofNullable(apiDao.getCommunicationDetails(familyMember.getNhaid(),stateCode)).orElse(null));
//				familyMember.setAaa_flag("N");
//				familyMember.setCard_delivery_date(null);
//				familyMember.setCard_delivery_status(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("card_delivery_status")).orElse("")));
//
//				if(beneficiaryCardDetailsEntity.get("gender_ben")!=null 
//						&& !beneficiaryCardDetailsEntity.get("gender_ben").toString().equalsIgnoreCase("")) {
//					if(beneficiaryCardDetailsEntity.get("gender_ben").toString().equalsIgnoreCase("Male")) {
//						familyMember.setGender("M");
//					}else if(beneficiaryCardDetailsEntity.get("gender_ben").toString().equalsIgnoreCase("Female")) {
//						familyMember.setGender("F");
//					}else if(beneficiaryCardDetailsEntity.get("gender_ben").toString().equalsIgnoreCase("Other")) {
//						familyMember.setGender("T");
//					}else {
//						familyMember.setGender(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("gender_ben")).orElse("")));
//					}
//				}else {
//					return new GoldenApiResponse(false,"101",MessageConstant.RECORD_NOT_CORRECT);
//				}
//
//				if(beneficiaryCardDetailsEntity.get("name_ben")!=null 
//						&& !beneficiaryCardDetailsEntity.get("name_ben").toString().equalsIgnoreCase("")
//						&& !beneficiaryCardDetailsEntity.get("name_ben").toString().equalsIgnoreCase("NA")) {
//					familyMember.setMemberName(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("name_ben")).orElse("")));
//				}else {
//					return new GoldenApiResponse(false,"101",MessageConstant.RECORD_NOT_CORRECT);
//				}
//
//				if(beneficiaryCardDetailsEntity.get("dob_ben")!=null 
//						&& !beneficiaryCardDetailsEntity.get("dob_ben").toString().equalsIgnoreCase("")
//						&& !beneficiaryCardDetailsEntity.get("dob_ben").toString().equalsIgnoreCase("NaN-NaN-NaN")) {
//					familyMember.setYearOfBirth(CommonUtility.fingYearInGivenString(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("dob_ben")).orElse(""))));
//				}else {
//					return new GoldenApiResponse(false,"101",MessageConstant.RECORD_NOT_CORRECT);
//				}
//
//				familyMember.setCareOfDec(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("care_of_dec")).orElse("")));
//				familyMember.setFatherName(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("father_name_secc")).orElse("")));
//				familyMember.setCareOfTypeDec(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("care_of_type_dec")).orElse("")));
//				familyMember.setFamilyDocId(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("fam_doc_number")).orElse("")));
//				familyMember.setFamilyDocTyp(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("fam_doc_type")).orElse("")));
//				family.setHhid(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("ahl_hhid")).orElse("")));
//				family.setScode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("state_code")).orElse("")));
//				family.setBentype(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("source_of_data")).orElse("")));
//				family.setHhdtype(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("source_of_data")).orElse("")));
//				family.setStateName(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("state_name_ben")).orElse("")));
//
//				if(stateCode.equalsIgnoreCase(MessageConstant.ASSAM) 
//						&&	!family.getBentype().equalsIgnoreCase("")
//						&& family.getBentype().equalsIgnoreCase("OA")) {
//					familyMember.setAaa_flag(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("is_bpl_apl")).orElse("")));
//					familyMember.setAaa_expiry_date(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("dateofexpiry")).orElse("")));
//					familyMember.setAaa_enrollment_date(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("dateofissue")).orElse("")));
//					familyMember.setAaa_URN(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("aaa_urn")).orElse("")));
//				}else {
//					familyMember.setAaa_flag("N");
//					familyMember.setAaa_expiry_date("");
//					familyMember.setAaa_enrollment_date("");
//					familyMember.setAaa_URN("");
//				}
//
//				Address address = new Address();
//				address.setAddress(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("address_ben")).orElse("")));
//				address.setRuralUrban(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("rural_urban_ben")).orElse("")));
//				address.setStatelgdCode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("state_codelgd_ben")).orElse("")));
//				address.setBenstatelgdCode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("state_codelgd_ben")).orElse("")));
//				address.setDistrictlgdCode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("district_codelgd_ben")).orElse("")));
//				address.setBendistrictlgdCode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("district_codelgd_ben")).orElse("")));
//				address.setSubdistrictlgdCode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("subdistrict_codelgd_ben")).orElse("")));
//				address.setVillage_townlgdCode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("villagetown_code_lgd_ben")).orElse("")));
//				address.setPinCode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("pin_code_ben")).orElse("")));
//
//				if(beneficiaryCardDetailsEntity.get("doc_pic")!=null
//						&& !beneficiaryCardDetailsEntity.get("doc_pic").toString().equalsIgnoreCase("")) {
//					familyMember.setPhoto(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("doc_pic")).orElse("")));
//				}else {
//					familyMember.setPhoto(getPhoto(familyMember.getNhaid(),stateCode));
//				}
//
//				familyMember.setAddress(address);
//				familyMemberList.add(familyMember);
//			}
//
//			//set family details
//			family.setFamilyMember(familyMemberList);
//			familylist.add(family);
//			familySearchDetails.setFamily(familylist);
//			response.setFamilySearchDetails(familySearchDetails);
//
//			//set header details
//			header.setBeneficiaryDetails(req.getBeneficiaryDetails());
//			header.setErrorCode("");
//			header.setVersion("2.0");
//			response.setHeader(header);
//
//			//set other respose status
//			response.setStatus(true);
//			response.setErrorcode("0");
//			response.setErrorMessage("");
//			response.setOperation("");
//			return response;
//		} catch (CustomException e) {
//			e.printStackTrace();
//			return new GoldenApiResponse(false,"101",MessageConstant.RECORD_NOT_CORRECT);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new GoldenApiResponse(false,"101",MessageConstant.SOMETHING_WENT_WRONG);
//		}finally {
//			benData=null;header=null;familylist=null;family=null;familyMemberList=null;familySearchDetails=null;
//		}
//	}
//
//	@Override
//	public JSONResponse disablepmjayid(DisablePmjayIdApiRequest req) {
//		int resp=0;List<Map<String,Object>>  benData = null;
//		try {			
//			benData = apiDao.getbenificieryDataByUuidtoCheck(req.getPmjayId(),req.getStateCode());
//			if(benData!=null && benData.size()>0 && benData.get(0).get("verification_status")!=null
//					&& !String.valueOf(Optional.ofNullable(benData.get(0).get("verification_status")).orElse("")).equalsIgnoreCase("")
//					&& String.valueOf(Optional.ofNullable(benData.get(0).get("verification_status")).orElse("")).equalsIgnoreCase("Z")) {
//				return new JSONResponse(false,"101","Beneficiery id already disabled");
//			}else if(benData==null ||  benData.size()<=0) {
//				return new JSONResponse(false,"101","Beneficiery not found");
//			}
//
//			resp= apiDao.upDateBeneficiery(req);
//			if(resp==1) {
//				return new JSONResponse(true,"200",MessageConstant.RESPONSE_SUCCESS);	
//			}else {
//				return new JSONResponse(false,"101",MessageConstant.SOMETHING_WENT_WRONG);
//			}
//		} catch (Exception e) {
//			return new JSONResponse(false,"101",MessageConstant.SOMETHING_WENT_WRONG);
//		}finally {
//			benData=null;
//		}
//	}
//
//	@Override
//	public JSONResponse disablepmjayid2(DisablePmjayIdApiRequest2 req) {
//		int resp=0;List<Map<String,Object>>  benData = null;
//		try {			
//			benData = apiDao.getbenificieryDataByUuidtoCheck(req.getPmjay_id(),req.getStateCode());
//			if(benData==null || benData.size()==0) {
//				resp= apiDao.insertDisablePmjayIdMissingInTDataEntry(req);
//				if(resp==1) {
//					return new JSONResponse(null,true,req.getOperationType(),"200",MessageConstant.RESPONSE_SUCCESS,"");	
//				}else {
//					return new JSONResponse(null,false,req.getOperationType(),"100",MessageConstant.SOMETHING_WENT_WRONG,"");
//				}
//			}else if (benData!=null && benData.size()>0	&& benData.get(0).get("verification_status")!=null
//					&& String.valueOf(Optional.ofNullable(benData.get(0).get("verification_status")).orElse("")).equalsIgnoreCase(req.getVerification_status())) {
//				return new JSONResponse(false,"101",MessageConstant.RECORD_ALREADY_DISABLED+req.getVerification_status());
//			}else if (benData!=null && benData.size()>0	&& benData.get(0).get("verification_status")!=null
//					&& String.valueOf(Optional.ofNullable(benData.get(0).get("verification_status")).orElse("")).equalsIgnoreCase("C")){
//				resp= apiDao.upDateBeneficiery2(req);
//				if(resp==1) {
//					return new JSONResponse(null,true,req.getOperationType(),"200",MessageConstant.RESPONSE_SUCCESS,Optional.ofNullable(benData.get(0).get("uid_token")).orElse("").toString());	
//				}else {
//					return new JSONResponse(null,false,req.getOperationType(),"100",MessageConstant.SOMETHING_WENT_WRONG,Optional.ofNullable(benData.get(0).get("uid_token")).orElse("").toString());
//				}
//			}else {
//				return new JSONResponse(null,false,req.getOperationType(),"100",MessageConstant.RECORD_NOT_ELIGIBLE,Optional.ofNullable(benData.get(0).get("uid_token")).orElse("").toString());
//			}
//		} catch (Exception e) {
//			return new JSONResponse(null,false,req.getOperationType(),"100",MessageConstant.SOMETHING_WENT_WRONG,"");
//		}finally {
//			benData=null;
//		}
//	}
//
//	@Override
//	public JSONResponse deceasedpmjayid(DeceasedPmjayIdApiRequest req) {
//		DisablePmjayIdApiRequest disableben = new  DisablePmjayIdApiRequest();List<Map<String,Object>>  benData = null;
//		int resp=0;
//		try {
//			benData = apiDao.getbenificieryDataByUuidtoCheck(req.getPmjayId(),req.getStateCode());
//			if(benData!=null && benData.size()>0 && benData.get(0).get("verification_status")!=null
//					&& !String.valueOf(Optional.ofNullable(benData.get(0).get("verification_status")).orElse("")).equalsIgnoreCase("")
//					&& String.valueOf(Optional.ofNullable(benData.get(0).get("verification_status")).orElse("")).equalsIgnoreCase("Z")) {
//				return new JSONResponse(false,"101","Beneficiery id already disabled");
//			}else if(benData==null || benData.size()<=0) {
//				return new JSONResponse(false,"101","Beneficiery not found");
//			}
//
//			apiDao.deceasedpmjayid(req);
//
//			disableben.setPmjayId(req.getPmjayId());
//			disableben.setApplicationName(req.getApplicationName());
//			disableben.setStateCode(req.getStateCode());
//
//			resp= apiDao.upDateBeneficiery(disableben);
//			if(resp==1) {
//				return new JSONResponse(true,"200",MessageConstant.RESPONSE_SUCCESS);	
//			}else {
//				return new JSONResponse(false,"101",MessageConstant.SOMETHING_WENT_WRONG);
//			}
//		} catch (Exception e) {
//			return new JSONResponse(false,"101",MessageConstant.SOMETHING_WENT_WRONG);
//		}finally {
//			disableben=null;benData=null;
//		}
//	}
//
//	@Override
//	public JSONResponse checkStatusPmjayid(CheckStatusRequest req) {
//		List<Map<String,Object>>  benData = null;
//		try {
//			if(req.getRef_id()!=null && !req.getRef_id().isEmpty()) {
//				benData = apiDao.checkStatusRefid(req);
//			}else {
//				benData = apiDao.checkStatusPmjayid(req);	
//			}
//			if(benData!=null && benData.size()>0) {	
//				return new JSONResponse(true,"200",MessageConstant.RESPONSE_SUCCESS,benData.get(0).get("verification_status").toString(),req.getPmjay_id());
//			}else {
//				return new JSONResponse(false,"101","Beneficiery not found",null,req.getPmjay_id());
//			}
//		} catch (Exception e) {
//			return new JSONResponse(false,"101",MessageConstant.SOMETHING_WENT_WRONG,null,req.getPmjay_id());
//		}finally {
//			benData = null;
//		}		
//	}
//
//	public String getPhoto(String pmjayId,String stateCode) {
//		String token  =null;String response  =null;JSONObject demoRes=null;
//		try {
//			token  = CommonUtility.getTokenOauth2_0(config.PHOTO_GATEWAY_CLIENT, config.PHOTO_GATEWAY_SECRET,config.PHOTO_GATEWAY_URL);
//
//			response =  CommonUtility.userRequest(token, commonUtility.getPhotoRequestBody(pmjayId, stateCode), config.PHOTO_URL,config.PHOTO_HEADER_TAG_1,config.PHOTO_HEADER_VALUE_1);
//
//			demoRes= new JSONObject(response);
//
//			if(demoRes.getBoolean("status")==true && demoRes.getString("errorCode").equalsIgnoreCase("200")) {
//				return demoRes.getJSONObject("imageBase64").getString("profilePic");
//			}
//
//			return "";
//		} catch (Exception e) {
//			return "";
//		}finally {
//			token = null;response  =null;demoRes=null;
//		}
//	}
//
//	@Override
//	public JSONResponse markAsEmergencyPmjayId(CheckStatusRequest req) {
//		List<Map<String,Object>>  benData = null;int status = 0;
//		try {
//			benData = apiDao.getbenificieryDataByUuidtoCheck(req.getPmjay_id(),req.getState_code());
//			if(benData==null || benData.size()==0) {
//				return new JSONResponse(false,"E-100","Data Not Found In Our Database");
//			}
//
//			status = apiDao.markAsEmergencyPmjayId(req);
//
//			if(status==1) {	
//				return new JSONResponse(true,"200",MessageConstant.RESPONSE_SUCCESS,null,req.getPmjay_id());
//			}else {
//				return new JSONResponse(false,"E-100","Data Not Inserted In database for Emergency Record");
//			}
//		} catch (Exception e) {
//			return new JSONResponse(false,"E-101","Connection Error",null,req.getPmjay_id());
//		}finally {
//			benData = null;
//		}		
//	}
//
//	@Override
//	public GoldenApiResponse getbetaApiData(GoldenApiRequest req) {
//		List<Map<String,Object>>  benData = null;
//		String stateCode = String.valueOf(req.getBeneficiaryDetails().getRationCardDetails().getStateCode());
//		try {				
//			if(req.getBeneficiaryDetails().getUuid()!=null && !req.getBeneficiaryDetails().getUuid().isEmpty()) {
//				//find by UUID
//				benData = apiDao.getbenificieryDataByUuidForBetaApi(req.getBeneficiaryDetails().getUuid(),stateCode);
//
//			}else {
//				return new GoldenApiResponse(false,"101","Invalid Search");
//			}
//
//			if(benData==null || benData.size()==0) {
//				return new GoldenApiResponse(false,"100","No record found");
//			}
//
//			return getgoldenApiDataByPmjayIdForBetaAPI(benData,req,stateCode);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new GoldenApiResponse(false,"101","Invalid Search");
//		}finally {
//			benData=null;
//		}
//	}
//
//	public GoldenApiResponse getgoldenApiDataByPmjayIdForBetaAPI(List<Map<String,Object>>  benData,GoldenApiRequest req,String stateCode) {
//		logger.info("getgoldenApiData service imple Starts");
//		GoldenApiResponse response = new GoldenApiResponse();
//		Header header = new Header();
//		FamilySearchDetails familySearchDetails = new FamilySearchDetails();
//		List<Family> familylist = new ArrayList<Family>();
//		Family family = new Family();
//		List<FamilyMember> familyMemberList = new ArrayList<FamilyMember>();
//		try {
//			for (Map<String,Object> beneficiaryCardDetailsEntity : benData) {
//				FamilyMember familyMember = new FamilyMember();
//				familyMember.setMobileNumber(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("mobile_member")).orElse("")));
//				familyMember.setNhaid(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("pmrssm_id")).orElse("")));
//				familyMember.setHealth_id(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("health_id")).orElse("")));
//				familyMember.setVenderToken(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("uid_token")).orElse("")));
//				familyMember.setMember_id(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("ahl_tin")).orElse("")));
//				familyMember.setCommunication_address(Optional.ofNullable(apiDao.getCommunicationDetails(familyMember.getNhaid(),stateCode)).orElse(null));
//				familyMember.setAaa_flag("N");
//				familyMember.setCard_delivery_date(null);
//				familyMember.setCard_delivery_status(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("card_delivery_status")).orElse("")));
//
//				if(beneficiaryCardDetailsEntity.get("gender_ben")!=null 
//						&& !beneficiaryCardDetailsEntity.get("gender_ben").toString().equalsIgnoreCase("")) {
//					if(beneficiaryCardDetailsEntity.get("gender_ben").toString().equalsIgnoreCase("Male")) {
//						familyMember.setGender("M");
//					}else if(beneficiaryCardDetailsEntity.get("gender_ben").toString().equalsIgnoreCase("Female")) {
//						familyMember.setGender("F");
//					}else if(beneficiaryCardDetailsEntity.get("gender_ben").toString().equalsIgnoreCase("Other")) {
//						familyMember.setGender("T");
//					}else {
//						familyMember.setGender(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("gender_ben")).orElse("")));
//					}
//				}else {
//					return new GoldenApiResponse(false,"101",MessageConstant.RECORD_NOT_CORRECT);
//				}
//
//				if(beneficiaryCardDetailsEntity.get("name_ben")!=null 
//						&& !beneficiaryCardDetailsEntity.get("name_ben").toString().equalsIgnoreCase("")
//						&& !beneficiaryCardDetailsEntity.get("name_ben").toString().equalsIgnoreCase("NA")) {
//					familyMember.setMemberName(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("name_ben")).orElse("")));
//				}else {
//					return new GoldenApiResponse(false,"101",MessageConstant.RECORD_NOT_CORRECT);
//				}
//
//				if(beneficiaryCardDetailsEntity.get("dob_ben")!=null 
//						&& !beneficiaryCardDetailsEntity.get("dob_ben").toString().equalsIgnoreCase("")
//						&& !beneficiaryCardDetailsEntity.get("dob_ben").toString().equalsIgnoreCase("NaN-NaN-NaN")) {
//					familyMember.setYearOfBirth(CommonUtility.fingYearInGivenString(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("dob_ben")).orElse(""))));
//				}else {
//					return new GoldenApiResponse(false,"101",MessageConstant.RECORD_NOT_CORRECT);
//				}
//
//				familyMember.setCareOfDec(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("care_of_dec")).orElse("")));
//				familyMember.setFatherName(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("father_name_secc")).orElse("")));
//				familyMember.setCareOfTypeDec(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("care_of_type_dec")).orElse("")));
//				familyMember.setFamilyDocId(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("fam_doc_number")).orElse("")));
//				familyMember.setFamilyDocTyp(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("fam_doc_type")).orElse("")));
//				familyMember.setVerification_status(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("verification_status")).orElse("")));
//				family.setHhid(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("ahl_hhid")).orElse("")));
//				family.setScode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("state_code")).orElse("")));
//				family.setBentype(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("source_of_data")).orElse("")));
//				family.setHhdtype(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("source_of_data")).orElse("")));
//				family.setStateName(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("state_name_ben")).orElse("")));
//
//				if(stateCode.equalsIgnoreCase(MessageConstant.ASSAM) 
//						&&	!family.getBentype().equalsIgnoreCase("")
//						&& family.getBentype().equalsIgnoreCase("OA")) {
//					familyMember.setAaa_flag(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("is_bpl_apl")).orElse("")));
//					familyMember.setAaa_expiry_date(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("dateofexpiry")).orElse("")));
//					familyMember.setAaa_enrollment_date(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("dateofissue")).orElse("")));
//					familyMember.setAaa_URN(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("aaa_urn")).orElse("")));
//				}else {
//					familyMember.setAaa_flag("N");
//					familyMember.setAaa_expiry_date("");
//					familyMember.setAaa_enrollment_date("");
//					familyMember.setAaa_URN("");
//				}
//
//				Address address = new Address();
//				address.setAddress(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("address_ben")).orElse("")));
//				address.setRuralUrban(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("rural_urban_ben")).orElse("")));
//				address.setStatelgdCode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("state_codelgd_ben")).orElse("")));
//				address.setBenstatelgdCode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("state_codelgd_ben")).orElse("")));
//				address.setDistrictlgdCode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("district_codelgd_ben")).orElse("")));
//				address.setBendistrictlgdCode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("district_codelgd_ben")).orElse("")));
//				address.setSubdistrictlgdCode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("subdistrict_codelgd_ben")).orElse("")));
//				address.setVillage_townlgdCode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("villagetown_code_lgd_ben")).orElse("")));
//				address.setPinCode(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("pin_code_ben")).orElse("")));
//
//				if(beneficiaryCardDetailsEntity.get("doc_pic")!=null
//						&& !beneficiaryCardDetailsEntity.get("doc_pic").toString().equalsIgnoreCase("")) {
//					familyMember.setPhoto(String.valueOf(Optional.ofNullable(beneficiaryCardDetailsEntity.get("doc_pic")).orElse("")));
//				}else {
//					familyMember.setPhoto(getPhoto(familyMember.getNhaid(),stateCode));
//				}
//
//				familyMember.setAddress(address);
//				familyMemberList.add(familyMember);
//			}
//
//			//set family details
//			family.setFamilyMember(familyMemberList);
//			familylist.add(family);
//			familySearchDetails.setFamily(familylist);
//			response.setFamilySearchDetails(familySearchDetails);
//
//			//set header details
//			header.setBeneficiaryDetails(req.getBeneficiaryDetails());
//			header.setErrorCode("");
//			header.setVersion("2.0");
//			response.setHeader(header);
//
//			//set other respose status
//			response.setStatus(true);
//			response.setErrorcode("0");
//			response.setErrorMessage("");
//			response.setOperation("");
//			return response;
//		} catch (CustomException e) {
//			e.printStackTrace();
//			return new GoldenApiResponse(false,"101",MessageConstant.RECORD_NOT_CORRECT);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new GoldenApiResponse(false,"101",MessageConstant.SOMETHING_WENT_WRONG);
//		}finally {
//			benData=null;header=null;familylist=null;family=null;familyMemberList=null;familySearchDetails=null;
//		}
//	}
//
//	@Override
//	public GoldenApiResponse getbetaApiFamilyData(GoldenApiRequest req) {
//		List<Map<String,Object>>  benData = null;List<Map<String,Object>>  benDatahid = null;
//		String stateCode = String.valueOf(req.getBeneficiaryDetails().getRationCardDetails().getStateCode());
//		try {				
//			if(req.getBeneficiaryDetails().getUuid()!=null && !req.getBeneficiaryDetails().getUuid().isEmpty()) {
//				//find by UUID
//				benData = apiDao.getbenificieryDataByUuidForBetaApi(req.getBeneficiaryDetails().getUuid(),stateCode);
//				if(benData!=null && benData.size()>0
//						&& benData.get(0).get("ahl_hhid")!=null
//						&& !benData.get(0).get("ahl_hhid").toString().equalsIgnoreCase("")) {
//					benDatahid = apiDao.getbenificieryDataByHhIdForBetaApi(benData.get(0).get("ahl_hhid").toString(),stateCode);
//				}else {
//					return new GoldenApiResponse(false,"100","No record found");
//				}
//			}else {
//				return new GoldenApiResponse(false,"101","Invalid Search");
//			}
//
//			return getgoldenApiDataByPmjayIdForBetaAPI(benDatahid,req,stateCode);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new GoldenApiResponse(false,"101","Invalid Search");
//		}finally {
//			benData=null;benDatahid= null;
//		}
//	}
//
//	@Override
//	@Transactional
//	public JSONResponse linkAadhar(LinkAadharRequest req) {
//		int  saveSeccData =0;int updatestatedata=0;String apiresponse = null;
//		try {				
//
//			req.setH_aadhar(CommonCryptor.encrypt(req.getP_aadhar()));
//
//			//insert data into benall t_data_entry_aadhar
//			saveSeccData = apiDao.insertIntoTDataEntryAadhar(req);
//
//			//t_data_entry state_wise
//			updatestatedata = apiDao.updateTDataEntryStateWise(req);
//
//			apiresponse = saveTokentoRedisApi(req);			
//
//			if(saveSeccData==1 && updatestatedata==1 && apiresponse.equalsIgnoreCase(MessageConstant.RESPONSE_SUCCESS)) {
//				return new JSONResponse(true,"200",MessageConstant.RESPONSE_SUCCESS,null,req.getPmrssm_id());
//			}else {
//				return new JSONResponse(false,"E-100",MessageConstant.SOMETHING_WENT_WRONG);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new JSONResponse(false,"E-100",MessageConstant.SOMETHING_WENT_WRONG);
//		}finally {
//			apiresponse = null;
//		}
//	}
//
//
//	private String saveTokentoRedisApi(LinkAadharRequest req) {
//		String response  =null;JSONObject demoRes=null;
//		try {
//			JSONObject data= new JSONObject();
//			data.put("uid_hash", req.getP_aadhar());
//			data.put("uid_token", req.getUid_token());
//			data.put("reqType", "A");
//
//			response =  CommonUtility.userRequest(null, data.toString(), config.UPDATE_TOKEN_IN_REDIS,null,null);
//
//			if(!ObjectUtils.isEmpty(response)) {
//				demoRes= new JSONObject(response);
//				if(demoRes.getBoolean("status")) {
//					return MessageConstant.RESPONSE_SUCCESS;
//				}else if(demoRes.getBoolean("status")==false && demoRes.getString("errCode")!=null
//						&& demoRes.getString("errCode").equalsIgnoreCase("301")) {
//					return MessageConstant.RESPONSE_SUCCESS;
//				}	
//			}
//			return MessageConstant.RESPONSE_FAILED;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return MessageConstant.RESPONSE_FAILED;
//		}finally {
//			response  =null;response=null;
//		}
//	}
//}
