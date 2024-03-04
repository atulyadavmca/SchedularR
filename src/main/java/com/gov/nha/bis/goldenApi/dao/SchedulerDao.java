package com.gov.nha.bis.goldenApi.dao;

import java.util.List;
import java.util.Map;

public interface SchedulerDao {

	List<Map<String, Object>> getReleaseData();

	Integer deleteDataFromHistory(String string, String stateCode);

	Integer getsetuMinioDataByReferenecId(String string, String string2);

	List<Map<String, Object>> getReleaseDataByRefStateCode(String refid, String stateCo);

	Integer  updateReleaseTable(String ahl_tin, String status);

}
