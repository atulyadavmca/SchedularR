package com.gov.nha.bis.goldenApi.properties;

import org.springframework.stereotype.Component;


@Component
public class QueryHelperConstant {

	// golden api start
	public static String getbenificieryDataByUuid() {
		return new StringBuilder("select * from t_data_entry where pmrssm_id=? and state_code=?  ").toString();
	}

	public static String getbenificieryDataByUuidTransgender() {
		return new StringBuilder("select * from t_data_entry where pmrssm_id=?  ").toString();
	}
	
	public static String getbenificieryDataByHhId() {
		return new StringBuilder("select * from t_data_entry where ahl_hhid=? and state_code=?  ").toString();
	}

	public static String getbenificieryDataMobileNumber() {
		return new StringBuilder("select * from t_data_entry where mobile_member=? and state_code=?  ").toString();
	}

	public static String getbenificieryDataAadharToken() {
		return new StringBuilder("select * from t_data_entry where uid_token=? and state_code=?  ").toString();
	}

	public static String getbenificieryDataHealthId() {
		return new StringBuilder("select * from t_data_entry where health_id=? and state_code=?  ").toString();
	}
	
	public static String getCommunicationDetails() {
		return new StringBuilder("select * from beneficiery_address_detail where pmjayid = ? and state_code = ?").toString();
	}
	
	//silver api start
	public static String getbenificieryDataByUuidForSilver() {
		return new StringBuilder("select * from t_data_entry where pmrssm_id=? and state_code=? and verification_status in ('C','P') ").toString();
	}

	public static String getbenificieryDataByHhIdSilver() {
		return new StringBuilder("select * from t_data_entry where ahl_hhid=? and state_code=? and verification_status in ('C','P') ").toString();
	}

	public static String getbenificieryDataMobileNumberSilver() {
		return new StringBuilder("select * from t_data_entry where mobile_member=? and state_code=? and verification_status in ('C','P') ").toString();
	}

	public static String getbenificieryDataAadharTokenSilver() {
		return new StringBuilder("select * from t_data_entry where uid_token=? and state_code=? and verification_status in ('C','P') ").toString();
	}

	public static String getbenificieryDataHealthIdSilver() {
		return new StringBuilder("select * from t_data_entry where health_id=? and state_code=? and verification_status in ('C','P') ").toString();
	}

	public static String upDateBeneficieryDeathCase() {
		return new StringBuilder("update t_data_entry set verification_status='Z',disabled_by=?,disabled_reason=?,disable_by_applicationname=?,disabled_on=NOW() where pmrssm_id=? and state_code=? ").toString();
	}

	public static String getbenificieryDataByUuidtoCheck() {
		return new StringBuilder("select * from t_data_entry where pmrssm_id=? and state_code=?").toString();
	}

	public static String saveCommunicationAddress() {
		return new StringBuilder("insert into beneficiery_address_detail(id,pmjayid,refernceid,rural_urban,address,state_code,district_code,sub_distcode,vtccode,pin_code,vill_ward_code,creation_Date) values ( nextval('beneficiery_address_detail_seq'),?,?,?,?,?,?,?,?,?,?,NOW()) ").toString();
	}

	public static String deceasedpmjayid() {
		return new StringBuilder("insert into t_data_entry_death(id,pmjayId,statecode,applicationname,schemename,userid,hospitalcodingsystem,hospitalid,status,deathcertificate,deathsummary,placeofdeath,deathdatetime,institutionalname,address,remark,displayreason,codingsystem,codevalue,createdatetime) values (nextval('t_data_entry_death_seq'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NOW()) ").toString();
	}

	public static String checkStatusPmjayid() {
		return new StringBuilder("select verification_status from t_data_entry where pmrssm_id=? and state_code=? ").toString();
	}
	
	public static String checkStatusRefId() {
		return new StringBuilder("select verification_status from t_data_entry where guid=? and state_code=? ").toString();
	}

	public static String markAsEmergencyPmjayId() {
		return new StringBuilder("insert into t_data_entry_mark_emergency(id,pmjay_id,statecode,createdatetime) values (nextval('t_data_entry_mark_emergency_seq'),?,?,NOW()) ").toString();
	}

	public static String getbenificieryDataByUuidBetaApi() {
		return new StringBuilder("select * from t_data_entry where pmrssm_id=? and state_code=? ").toString();
	}

	public static String getbenificieryDataByHhIdBetaApi() {
		return new StringBuilder("select * from t_data_entry where ahl_hhid=? and state_code=? ").toString();
	}

	public static String upDateBeneficieryDeathCase2() {
		return new StringBuilder("update t_data_entry set verification_status=?,updatedby=?,disable_by_applicationname=?,updateddate=NOW() where pmrssm_id=? and state_code=? and guid=?").toString();
	}

	public static String insertDisablePmjayIdMissingInTDataEntry() {
		return new StringBuilder("insert into t_data_entry_missing_disabledata(id,pmjay_id,operation_type,guid,state_code,verification_status,created_by,creation_date) values (nextval('t_data_entry_missing_disabledata_seq'),?,?,?,?,?,?,NOW()) ").toString();
	}

	public static String insertIntoTDataEntryAadhar() {
		return new StringBuilder("insert into t_data_entry_link_aadhaar(id,pmrssm_id,createdby,enc_uid,photo,state_code,address_ekyc,districtname_ekyc,districtname_code_ekyc,gender_ekyc,name_ekyc,pincode_ekyc,relationshipname_ekyc,relationshiptype_ekyc,statename_ekyc,type_ekyc,creation_date,dob_y_ekyc) values  (nextval('t_data_entry_link_aadhaar_id_seq'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NOW(),?) ").toString();
	}

	public static String updateTDataEntryStateWise() {
		return new StringBuilder("update t_data_entry set uid_token=?,doc_pic=?,name_ben=?,dob_ben=?,gender_ben=?,address_ben=?,district_name_ben=?,district_codelgd_ben=?,state_name_ben=?,pin_code_ben=?,care_of_dec=?,care_of_type_dec=?,updateddate=NOW(),updatedby=? where pmrssm_id=? and state_code=? ").toString();
	}	
	
	
	
	//scheduleRelease api start
	public static String getNonReleasedData() {		
		return new StringBuilder("select * from up.needtodeletefromelk where status is null limit 10000").toString();
	}
	
	public static String updateReleasedTable() {
		return new StringBuilder("update up.needtodeletefromelk set status= ? where ahl_tin=? ").toString();
	}
	
	public static String getNonReleasedDataByRefState() {
//		return new StringBuilder("select guid,state_codelgd_ben,district_codelgd_ben,block_code,village_code,town_code,ward_code,ahl_hhid,ahl_tin,uid_token,verification_status,\r\n" + 
//				"rural_urban_ben from t_data_entry_disabled where guid=? ").toString();
		
		return new StringBuilder("select * from release_disabled where guid=? ").toString();
	}
	
	public static String getSetuMinioData() {
		
		//for staging 
//		return new StringBuilder("insert into setuminiodata_history(id,refernceid,rural_urban,statecode,\r\n" + 
//				"districtcode,schemeid,status,creationdate,createddby,urlpath)\r\n" + 
//				"select id,refernceid,rural_urban,statecode,\r\n" + 
//				"districtcode,schemeid,status,creationdate,createddby,urlpath\r\n" + 
//				"from setuminiodata where refernceid=? ").toString();
		
		//for prod
		return new StringBuilder("insert into setuminiodata_history(id,refernceid,rural_urban,statecode,districtcode,schemeid,status,\r\n" + 
				"creationdate,createddby,urlpath,uidtoken,encuid,townblockcode,villwardcode,cardstatus,\r\n" + 
				"hhid,ekyctype,reqmode,pmjayid)\r\n" + 
				"select id,refernceid,rural_urban,statecode,districtcode,schemeid,status,\r\n" + 
				"creationdate,createddby,urlpath,uidtoken,encuid,townblockcode,villwardcode,cardstatus,\r\n" + 
				"hhid,ekyctype,reqmode,pmjayid\r\n" + 
				"from setuminiodata where refernceid=? ").toString();
		
			}
	public static String deleteReleasedMinioHistoryData() {
		return new StringBuilder("delete from setuminiodata where refernceid=? ").toString();
	}


	
}