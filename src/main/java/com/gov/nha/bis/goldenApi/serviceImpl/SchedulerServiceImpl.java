package com.gov.nha.bis.goldenApi.serviceImpl;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gov.nha.bis.goldenApi.dao.SchedulerDao;
import com.gov.nha.bis.goldenApi.properties.ApplicationConstantConfig;
import com.gov.nha.bis.goldenApi.service.SchedulerService;
import com.gov.nha.bis.goldenApi.util.CommonUtility;
import com.gov.nha.bis.goldenApi.util.MessageConstant;

@Service
public class SchedulerServiceImpl implements SchedulerService{

	private static final Logger logger = LoggerFactory.getLogger(SchedulerServiceImpl.class);

	@Autowired
	SchedulerDao scheduleDao;

	@Autowired
	CommonUtility commonUtility;

	@Autowired
	ApplicationConstantConfig config;

	//scheduler call starts 
	@Override
	public String getReleaseData() {
		List<Map<String, Object>> reslt = null;JSONObject demoRes=null;
		try {
			for(int i=0;i<=100000;i++) {
				reslt = scheduleDao.getReleaseData();
				for (Map<String, Object> map : reslt) {
					logger.error(map.get("ahl_tin").toString());
					String respo = 	getRestData(null,"http://100.96.20.146:8080/elasticSearch2/api/elastic/delete/1.0?state=9&ahl_tin="+map.get("ahl_tin").toString());
					demoRes= new JSONObject(respo);
					if(demoRes.get("status")!=null && demoRes.getString("status").equalsIgnoreCase(MessageConstant.RESPONSE_SUCCESS)) {
						//update success
						scheduleDao.updateReleaseTable(map.get("ahl_tin").toString(),"1");
					}else {
						scheduleDao.updateReleaseTable(map.get("ahl_tin").toString(),"0");
					}
				}
			}
			return MessageConstant.RESPONSE_SUCCESS;
		}catch (Exception e) {
			logger.info("error in scheduleRelease getReleaseData service====="+e);
			e.printStackTrace();
			return MessageConstant.RESPONSE_FAILED;
		}finally{
			reslt = null;
		}	
	}

	//
	//	private String executeDataProcess(List<Map<String, Object>> reslt,String urlCode,String stateCode) {
	//		JSONObject jsonResponsTinCheck = null;
	//		JSONObject jsonResponsTokenCheck = null;
	//		JSONObject jsonResponsHashCheck = null;
	//		JSONObject jsonResponsUpdateTokenHash = null;
	//		JSONObject jsonResponsUpdateTin = null;
	//		JSONObject jsonResponsUpdateRadis = null;
	//		List<String> tokenList= new ArrayList<String>();
	//		List<String> tinList= new ArrayList<String>();
	//		List<String> hashList= new ArrayList<String>();
	//		List<String> RadisTokenList= new ArrayList<String>();
	//		List<String> referenceList= new ArrayList<String>();
	//		try {
	//				for (Map<String, Object> obj : reslt) {
	//					String decHash= null;
	//					String hasCodeId = null;
	//					Integer completionCode = 5; //completionCode 5 as not released
	//		//	Map<String, Object> obj= new HashMap<String, Object>();
	//					
	//					if (obj.get("ahl_tin") != null && !obj.get("ahl_tin").toString().equalsIgnoreCase("")) {
	//						
	//						//check tin by api-----------------------------
	//						String stringRespon = getRestData(updateJsontoRequestUid(obj.get("ahl_tin").toString(), "ahl_tin", "T", stateCode),config.TIN_CHECK_URL);
	////						System.out.println(" tin:"+stringRespon);
	//						if(stringRespon!=null) {
	//						jsonResponsTinCheck = new JSONObject(stringRespon);
	//						}
	//					}
	//					
	//					//Release tin>>>>>>>>>>>>>>>>>>>>>
	//					if (jsonResponsTinCheck !=null && jsonResponsTinCheck.get("status") !=null && jsonResponsTinCheck.get("status").toString().equalsIgnoreCase("true")) {
	//					String stringRespon = getRestData(updateJsontoRequestRemoveTin(obj.get("ahl_tin").toString(),stateCode, "R"),config.REMOVE_TIN_URL);
	//					jsonResponsUpdateTin = new JSONObject(stringRespon);
	//					if(jsonResponsUpdateTin !=null && jsonResponsUpdateTin.get("status") !=null 
	//							&& (jsonResponsUpdateTin.get("status").toString().equalsIgnoreCase("true"))) {
	//					tinList.add(obj.get("ahl_tin").toString());
	//					completionCode=1; //code 4 as tin Released
	//					}
	//					}
	//					
	//					
	//					if (obj.get("uid_token") != null && !obj.get("uid_token").toString().equalsIgnoreCase("")) {
	//						
	//						//check token by api----------------------
	//						String stringRespon = getRestData(updateJsontoRequest(obj.get("uid_token").toString(), "uid_token", "T"),config.UID_TOKEN_CHECK_URL);
	////						System.out.println("token "+stringRespon);
	//						if(stringRespon !=null) {
	//							jsonResponsTokenCheck = new JSONObject(stringRespon);
	//							JSONArray tokenlist = jsonResponsTokenCheck.getJSONArray("tokenData");
	//							if(!tokenlist.isEmpty() && tokenlist.getJSONObject(0).get("aadhaar_hash") !=null){
	//							hasCodeId = tokenlist.getJSONObject(0).get("aadhaar_hash").toString();
	//							decHash = CommonCryptor.decrypt(hasCodeId);
	//							
	//							//check hash by api
	//							String stringResponHash = getRestData(updateJsontoRequest(decHash, "uid_hash", "H"),config.HASH_CHECK_URL);
	//							if(stringResponHash!=null) {
	//							jsonResponsHashCheck = new JSONObject(stringResponHash);
	//							}
	//							}
	//						}
	//					}
	//					
	//					//Release token and hash >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	//					if ((jsonResponsTokenCheck !=null && jsonResponsTokenCheck.get("status") !=null && jsonResponsTokenCheck.get("status").toString().equalsIgnoreCase("true"))
	//							|| (jsonResponsHashCheck!=null && jsonResponsHashCheck.get("status") !=null && jsonResponsHashCheck.get("status").toString().equalsIgnoreCase("true"))) {
	//					
	//					String stringRespon = getRestData(updateJsontoRequestTokenHash(obj.get("uid_token").toString(),hasCodeId, "R"),config.REMOVE_TOEKN_HASH_URL);
	//					jsonResponsUpdateTokenHash = new JSONObject(stringRespon);
	//					tokenList.add(obj.get("uid_token").toString());
	//					hashList.add(decHash);
	//						if(jsonResponsUpdateTokenHash !=null && jsonResponsUpdateTokenHash.get("status") !=null 
	//								&& (jsonResponsUpdateTokenHash.get("status").toString().equalsIgnoreCase("true"))) {
	//							completionCode=2; //code 2 as token/hash Released
	//						}
	//					}
	//				
	//					//if released add refeid/guid *****************************
	//					if ((jsonResponsUpdateTokenHash !=null && jsonResponsUpdateTokenHash.get("status") !=null 
	//							&& (jsonResponsUpdateTokenHash.get("status").toString().equalsIgnoreCase("true")))
	//							|| (jsonResponsUpdateTin !=null && jsonResponsUpdateTin.get("status") !=null 
	//							&& (jsonResponsUpdateTin.get("status").toString().equalsIgnoreCase("true")))) {
	//						
	//					int insertedData = scheduleDao.getsetuMinioDataByReferenecId(obj.get("guid").toString(),"9898");//copy to history table
	//					int deletedData = scheduleDao.deleteDataFromHistory(obj.get("guid").toString(),"9898");//delete from setuminiodata table
	//					if(deletedData>0) {
	//					referenceList.add(obj.get("guid").toString());
	//					}
	//					}
	//					//Radis Data Release >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	//				String radisRespo = getRestData(updateJsontoRequestForRadis(obj),config.RADIS_DOMAIN_START_URL+urlCode+config.RADIS_DOMAIN_END_URL);	
	//				if(radisRespo !=null) {
	//				jsonResponsUpdateRadis = new JSONObject(radisRespo);
	//				}
	//					if(jsonResponsUpdateRadis !=null && jsonResponsUpdateRadis.get("status") !=null && jsonResponsUpdateRadis.get("status").toString().equalsIgnoreCase("SUCCESS")) {
	//						RadisTokenList.add(obj.get("uid_token").toString());
	//						completionCode=4; //code 4 as Radis Released
	//					}
	//					if((jsonResponsUpdateTokenHash !=null && jsonResponsUpdateTokenHash.get("status") !=null 
	//							&& (jsonResponsUpdateTokenHash.get("status").toString().equalsIgnoreCase("true")))
	//							&& (jsonResponsUpdateTin !=null && jsonResponsUpdateTin.get("status") !=null 
	//							&& (jsonResponsUpdateTin.get("status").toString().equalsIgnoreCase("true")))) {
	//						completionCode=3; //code 3 as complete Released
	//					}
	//					
	//					Integer upd = scheduleDao.updateReleaseTable(obj.get("guid").toString(),completionCode,stateCode);
	//				}
	//		logger.info("Released token list===== of StateCode : "+ stateCode +"=====" + tokenList.toString());
	//		logger.info("Released tin list===== of StateCode : "+ stateCode +"=====" + tinList.toString());
	//		logger.info("Released hash list===== of StateCode : "+ stateCode +"=====" + hashList.toString());
	//		logger.info("Released guid list to history ===== of StateCode : "+ stateCode +"=====" + referenceList.toString());
	//		logger.info("deleted Radis data Token List====== of StateCode : "+ stateCode +"====="+ RadisTokenList.toString());
	//			return MessageConstant.RESPONSE_SUCCESS;
	//		}catch (Exception e) {
	//			logger.info("error in scheduleRelease executeDataProcess service====="+e);
	//			e.printStackTrace();
	//			return MessageConstant.RESPONSE_FAILED;
	//		}finally{
	//			 reslt = null; jsonResponsTinCheck = null;jsonResponsTokenCheck = null;jsonResponsHashCheck = null;
	//			 jsonResponsUpdateTokenHash = null;jsonResponsUpdateTin = null;jsonResponsUpdateRadis = null;urlCode = null;
	//		}	
	//			
	//	}
	//
	//	// scheduler call end
	//	
	//	@Override
	//	public Map<String, Object> getReleaseDataByRefid(String refid, String stateCo) {
	//		List<Map<String, Object>> reslt = null; 
	//		String urlCode = null;Map<String, Object> respo =new HashMap<String,Object>();
	//		try {
	//			if ((refid != null && !refid.equalsIgnoreCase("") && stateCo != null && !stateCo.equalsIgnoreCase(""))) {
	//				reslt = scheduleDao.getReleaseDataByRefStateCode(refid, stateCo);
	//				if (!reslt.isEmpty()) {
	//					if (stateCo == "22") {
	//						urlCode = "198";
	//					} else if (stateCo == "6" || stateCo == "36") {
	//						urlCode = "36";
	//					} else if (stateCo == "4" || stateCo == "8") {
	//						urlCode = "4";
	//					} else {
	//						urlCode = stateCo.toString();
	//					}
	//					respo = executeDataProcessByRefidStatecode(reslt, urlCode, stateCo);
	//				}
	//			}if(respo.isEmpty() || (respo.get("is_tinReleased").toString().equalsIgnoreCase("no")
	//					&& respo.get("is_TokenHashReleased").toString().equalsIgnoreCase("no") 
	//					&& respo.get("is_radisreleased").toString().equalsIgnoreCase("no"))) {
	//				respo.put("status", MessageConstant.RESPONSE_FAILED);
	//			}else {
	//				respo.put("status", MessageConstant.RESPONSE_SUCCESS);
	//			}
	//			return respo;
	//		}catch (Exception e) {
	//			logger.info("error in scheduleRelease getReleaseDataByRefid service====="+e);
	//			e.printStackTrace();
	//			return respo;
	//		}finally{
	//			 reslt = null;urlCode = null;
	//		}	
	//	}
	//	
	//		private Map<String, Object> executeDataProcessByRefidStatecode(List<Map<String, Object>> reslt, String urlCode, String stateCode) {
	//			JSONObject jsonResponsTinCheck = null;
	//			JSONObject jsonResponsTokenCheck = null;
	//			JSONObject jsonResponsHashCheck = null;
	//			JSONObject jsonResponsUpdateTokenHash = null;
	//			JSONObject jsonResponsUpdateTin = null;
	//			JSONObject jsonResponsUpdateRadis = null;
	//			List<String> tokenList= new ArrayList<String>();
	//			List<String> tinList= new ArrayList<String>();
	//			List<String> hashList= new ArrayList<String>();
	//			List<String> RadisTokenList= new ArrayList<String>();
	//			List<String> referenceList= new ArrayList<String>();
	//			Map<String, Object> respo = new HashMap<String, Object>();
	//			try {
	//					for (Map<String, Object> obj : reslt) {
	//						String decHash= null;
	//						String hasCodeId = null;
	//						Integer completionCode = 5; //completionCode 5 as not released
	//						respo.put("uid_token", obj.get("uid_token").toString());
	//						respo.put("aadhaar_hash", "");
	//						respo.put("ahl_tin", obj.get("ahl_tin").toString());
	//			//	Map<String, Object> obj= new HashMap<String, Object>();
	//			
	////						obj.put("guid", "765367");
	////						obj.put("ahl_tin", "81765129139918176512913991");
	////						obj.put("uid_token", "01002414SU+J6n7GkuERv/PgqoWQVujSy2dfVWxN0x/YCohHqTLpUnzqgz3WzZLuIDv7Xig5");
	//						
	//						
	//						//check tin by api-----------------------------
	//						if (obj.get("ahl_tin") != null && !obj.get("ahl_tin").toString().equalsIgnoreCase("")) {
	//							String stringRespon = getRestData(updateJsontoRequestUid(obj.get("ahl_tin").toString(), "ahl_tin", "T", stateCode),config.TIN_CHECK_URL);
	//							if(stringRespon!=null) {
	//								jsonResponsTinCheck = new JSONObject(stringRespon);
	//								}
	//						}
	//						
	//						//Release tin>>>>>>>>>>>>>>>>>>>>>
	//						if (jsonResponsTinCheck !=null && jsonResponsTinCheck.get("status") !=null && jsonResponsTinCheck.get("status").toString().equalsIgnoreCase("true")) {
	//						String stringRespon = getRestData(updateJsontoRequestRemoveTin(obj.get("ahl_tin").toString(),stateCode, "R"),config.REMOVE_TIN_URL);
	//						jsonResponsUpdateTin = new JSONObject(stringRespon);
	//						tinList.add(obj.get("ahl_tin").toString());
	//						completionCode=1; //code 4 as tin Released
	//						respo.put("is_tinReleased", "yes");
	//						}else {
	//							respo.put("is_tinReleased", "no");
	//						}
	//						
	//						if (obj.get("uid_token") != null && !obj.get("uid_token").toString().equalsIgnoreCase("")) {
	//							
	//							//check token by api
	//							String stringRespon = getRestData(updateJsontoRequest(obj.get("uid_token").toString(), "uid_token", "T"),config.UID_TOKEN_CHECK_URL);
	//							if(stringRespon !=null) {
	//							jsonResponsTokenCheck = new JSONObject(stringRespon);
	//							JSONArray tokenlist = jsonResponsTokenCheck.getJSONArray("tokenData");
	//							if(!tokenlist.isEmpty() && tokenlist.getJSONObject(0).get("aadhaar_hash") !=null){
	//							hasCodeId = tokenlist.getJSONObject(0).get("aadhaar_hash").toString();
	//							respo.put("aadhaar_hash", hasCodeId);
	//							decHash = CommonCryptor.decrypt(hasCodeId);
	//							
	//							//check hash by api
	//							String stringResponHash = getRestData(updateJsontoRequest(decHash, "uid_hash", "H"),config.HASH_CHECK_URL);
	//							if(stringResponHash!=null) {
	//								jsonResponsHashCheck = new JSONObject(stringResponHash);
	//								}
	//							System.out.println(jsonResponsHashCheck);
	//							}
	//							}
	//						}
	//						//Release token and hash >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	//						if ((jsonResponsTokenCheck !=null && jsonResponsTokenCheck.get("status") !=null && jsonResponsTokenCheck.get("status").toString().equalsIgnoreCase("true"))
	//								|| (jsonResponsHashCheck!=null && jsonResponsHashCheck.get("status") !=null && jsonResponsHashCheck.get("status").toString().equalsIgnoreCase("true"))) {
	//						String stringRespon = getRestData(updateJsontoRequestTokenHash(obj.get("uid_token").toString(),hasCodeId, "R"),config.REMOVE_TOEKN_HASH_URL);
	//						jsonResponsUpdateTokenHash = new JSONObject(stringRespon);
	//						tokenList.add(obj.get("uid_token").toString());
	//						hashList.add(decHash);
	//						if(jsonResponsUpdateTokenHash !=null && jsonResponsUpdateTokenHash.get("status") !=null 
	//								&& (jsonResponsUpdateTokenHash.get("status").toString().equalsIgnoreCase("true"))) {
	//							completionCode=2; //code 2 as token/hash Released
	//						}
	//						respo.put("is_TokenHashReleased", "yes");
	//						}else {
	//							respo.put("is_TokenHashReleased", "no");
	//						}
	//					
	//						//if released add refeid/guid *****************************
	//						if ((jsonResponsUpdateTokenHash !=null && jsonResponsUpdateTokenHash.get("status") !=null 
	//								&& (jsonResponsUpdateTokenHash.get("status").toString().equalsIgnoreCase("true")))
	//								|| (jsonResponsUpdateTin !=null && jsonResponsUpdateTin.get("status") !=null 
	//								&& (jsonResponsUpdateTin.get("status").toString().equalsIgnoreCase("true")))) {
	//							
	//						int insertedData = scheduleDao.getsetuMinioDataByReferenecId(obj.get("guid").toString(),"9898");//copy to history table
	//						int deletedData = scheduleDao.deleteDataFromHistory(obj.get("guid").toString(),"9898");//delete from setuminiodata table
	//						if(deletedData>0) {
	//						referenceList.add(obj.get("guid").toString());
	//						respo.put("is_historyInsert", "yes");
	//						}else {
	//							respo.put("is_historyInsert", "no");
	//						}
	//						}
	//						//Radis Data Release >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	//					String radisRespo = getRestData(updateJsontoRequestForRadis(obj),config.RADIS_DOMAIN_START_URL+urlCode+config.RADIS_DOMAIN_END_URL);	
	//					if(radisRespo !=null) {
	//						jsonResponsUpdateRadis = new JSONObject(radisRespo);
	//						}
	//			//		System.out.println(jsonResponsUpdateRadis);
	//						if(jsonResponsUpdateRadis !=null && jsonResponsUpdateRadis.get("status") !=null && jsonResponsUpdateRadis.get("status").toString().equalsIgnoreCase("SUCCESS")) {
	//							RadisTokenList.add(obj.get("uid_token").toString());
	//							completionCode=4; //code 4 as Radis Released
	//							respo.put("is_radisreleased", "yes");
	//						}else {
	//							respo.put("is_radisreleased", "no");
	//						}
	//						
	//						if((jsonResponsUpdateTokenHash !=null && jsonResponsUpdateTokenHash.get("status") !=null 
	//								&& (jsonResponsUpdateTokenHash.get("status").toString().equalsIgnoreCase("true")))
	//								&& (jsonResponsUpdateTin !=null && jsonResponsUpdateTin.get("status") !=null 
	//								&& (jsonResponsUpdateTin.get("status").toString().equalsIgnoreCase("true")))) {
	//							completionCode=3; //code 3 as complete Released
	//						}
	//						
	//						Integer upd = scheduleDao.updateReleaseTable(obj.get("guid").toString(),completionCode,stateCode);
	//					}
	//			logger.info("Released token list===== of StateCode : "+ stateCode +"=====" + tokenList.toString());
	//			logger.info("Released tin list===== of StateCode : "+ stateCode +"=====" + tinList.toString());
	//			logger.info("Released hash list===== of StateCode : "+ stateCode +"=====" + hashList.toString());
	//			logger.info("Released guid list to history ===== of StateCode : "+ stateCode +"=====" + referenceList.toString());
	//			logger.info("deleted Radis data Token List====== of StateCode : "+ stateCode +"====="+ RadisTokenList.toString());
	//				return respo;
	//			}catch (Exception e) {
	//				logger.info("error in scheduleRelease executeDataProcessByRefidStatecode service====="+e);
	//				e.printStackTrace();
	//				return respo;
	//			}finally{
	//				 reslt = null; jsonResponsTinCheck = null;jsonResponsTokenCheck = null;jsonResponsHashCheck = null;
	//				 jsonResponsUpdateTokenHash = null;jsonResponsUpdateTin = null;jsonResponsUpdateRadis = null;urlCode = null;
	//			}	
	//				
	//		}
	//
	//
	//
	//
	//	private String updateJsontoRequest(String id,String key, String idType) {
	//		JSONObject check= new JSONObject();
	//		check.put(key, id);
	//		check.put("idType", idType);
	//		return check.toString();
	//	}
	//	private String updateJsontoRequestUid(String id,String key, String idType, String stateCode) {
	//		JSONObject check= new JSONObject();
	//		check.put(key, id);
	//		check.put("idType", idType);
	//		check.put("statecode", stateCode);
	//		return check.toString();
	//	}
	//
	//	private String updateJsontoRequestTokenHash(String token,String hash, String reqType) {
	//		JSONObject remove= new JSONObject();
	//		remove.put("uid_token", token);
	//		remove.put("uid_hash", hash);
	//		remove.put("reqType", reqType);
	//		return remove.toString();
	//	}
	//	
	//	private String updateJsontoRequestRemoveTin(String tin,String stateCode, String reqType) {
	//		JSONObject remove= new JSONObject();
	//		remove.put("statecode", stateCode);
	//		remove.put("ahl_tin", tin);
	//		remove.put("reqType", reqType);
	//		return remove.toString();
	//	}
	//	
	//	private String updateJsontoRequestForRadis(Map<String, Object> obj) {
	//		JSONObject radis= new JSONObject();
	//		
	//		if(obj.get("state_codelgd_ben")!=null) {
	//			radis.put("stateCode", obj.get("state_codelgd_ben").toString());
	//			}else {radis.put("stateCode", "");}
	//		
	//		if(obj.get("district_codelgd_ben")!=null) {
	//			radis.put("districtCode", obj.get("district_codelgd_ben").toString());
	//			}else {radis.put("districtCode", "");}
	//		
	//		if(obj.get("block_code")!=null && !obj.get("block_code").toString().equalsIgnoreCase("NULL")) {
	//			radis.put("blockCode", obj.get("block_code").toString());
	//			}else {radis.put("blockCode", "");}
	//		
	//		if(obj.get("village_code")!=null && !obj.get("village_code").toString().equalsIgnoreCase("NULL")) {
	//			radis.put("villageCode", obj.get("village_code").toString());
	//			}else {radis.put("villageCode", "");}
	//		
	//		if(obj.get("town_code")!=null) {
	//			radis.put("townCode", obj.get("town_code").toString());
	//			}else {radis.put("townCode", "");}
	//			
	//		if(obj.get("ward_code")!=null) {
	//			radis.put("wardCode", obj.get("ward_code").toString());
	//			}else {radis.put("wardCode", "");}
	//		
	//		if(obj.get("rural_urban_ben")!=null) {
	//			radis.put("urFlag", obj.get("rural_urban_ben").toString());
	//			}else {radis.put("urFlag", "");}
	//		
	//		
	//		if(obj.get("ahl_hhid")!=null) {
	//			radis.put("ahl_hhid", obj.get("ahl_hhid").toString());
	//			}else {radis.put("ahl_hhid", "");}
	//		
	//		radis.put("updatestatus", "6");
	//		
	//		if(obj.get("ahl_tin")!=null) {
	//			radis.put("ahl_tin", obj.get("ahl_tin").toString());
	//			}else {radis.put("ahl_tin", "");}
	//		
	//		radis.put("verificatio_status", obj.get("verification_status").toString());
	//		
	//		if(obj.get("uid_token")!=null) {
	//			radis.put("uid_token", obj.get("uid_token").toString());
	//			}else {radis.put("uid_token", "");}
	//		
	//		radis.put("pmjayid", "");
	//		radis.put("searchType", "2");
	//		
	//		return radis.toString();
	//	}
	//	

	public  String getRestData(String requestJson,String reqUrl){
		String returnStr=null;
		RestTemplate restTemplate = new RestTemplate();
		try{
			logger.error(reqUrl);
			HttpHeaders headers = new HttpHeaders();

			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);

			returnStr = restTemplate.postForObject(reqUrl, entity, String.class);
			logger.error(returnStr);
		}catch(Exception e)
		{
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return returnStr;
	}






}
