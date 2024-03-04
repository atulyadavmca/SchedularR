package com.gov.nha.bis.goldenApi.dao.Impl;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.gov.nha.bis.goldenApi.dao.SilverApiDao;
//import com.gov.nha.bis.goldenApi.properties.QueryHelperConstant;
//import com.gov.nha.bis.goldenApi.util.CommonUtility;
//
//@Service
//public class SilverApiDaoImpl implements SilverApiDao{
//
//	@Autowired
//	CommonUtility commonUtil;
//	
//	@Override
//	public List<Map<String, Object>> getbenificieryDataByUuid(String uuid, String stateCode) {
//		return commonUtil.getTemplete(stateCode).queryForList(QueryHelperConstant.getbenificieryDataByUuidForSilver().toString(),uuid,stateCode);
//	}
//
//	@Override
//	public List<Map<String, Object>> getbenificieryDataByHhId(String hhId, String stateCode) {
//		return commonUtil.getTemplete(stateCode).queryForList(QueryHelperConstant.getbenificieryDataByHhIdSilver().toString(),hhId,stateCode);
//	}
//
//	@Override
//	public List<Map<String, Object>> getbenificieryDataMobileNumber(String mobileNumber, String stateCode) {
//		return commonUtil.getTemplete(stateCode).queryForList(QueryHelperConstant.getbenificieryDataMobileNumberSilver().toString(),mobileNumber,stateCode);
//	}
//
//	@Override
//	public List<Map<String, Object>> getbenificieryDataAadharToken(String aadharToken, String stateCode) {
//		return commonUtil.getTemplete(stateCode).queryForList(QueryHelperConstant.getbenificieryDataAadharTokenSilver().toString(),aadharToken,stateCode);
//	}
//
//	@Override
//	public List<Map<String, Object>> getbenificieryDataHealthId(String health_id, String stateCode) {
//		return commonUtil.getTemplete(stateCode).queryForList(QueryHelperConstant.getbenificieryDataHealthIdSilver().toString(),health_id,stateCode);
//	}
//
//}
