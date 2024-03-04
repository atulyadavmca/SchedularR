package com.gov.nha.bis.goldenApi.dao.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gov.nha.bis.goldenApi.dao.SchedulerDao;
import com.gov.nha.bis.goldenApi.properties.QueryHelperConstant;
import com.gov.nha.bis.goldenApi.util.CommonUtility;

@Service
public class SchedulerDaoImpl implements SchedulerDao {
	@Autowired
	CommonUtility commonUtil;
	
	@Autowired
	@Qualifier("jdbcTemplateHaryana")
	private JdbcTemplate jdbcTemplateharyana;

	@Override
	public List<Map<String, Object>> getReleaseData() {
		return jdbcTemplateharyana.queryForList(QueryHelperConstant.getNonReleasedData());
	}

	@Override
	public Integer updateReleaseTable(String ahl_tin,String status) {
		 return jdbcTemplateharyana.update(QueryHelperConstant.updateReleasedTable(),status,ahl_tin);
		
	}
	
	@Override
	public List<Map<String, Object>> getReleaseDataByRefStateCode(String refid, String stateCo) {
		return commonUtil.getTemplete(stateCo).queryForList(QueryHelperConstant.getNonReleasedDataByRefState(),refid);
	}
	@Override
	public Integer getsetuMinioDataByReferenecId(String reference, String stateCode) {
		return commonUtil.getTemplete(stateCode).update(QueryHelperConstant.getSetuMinioData(),reference);
	}
	
	@Override
	public Integer deleteDataFromHistory(String reference, String stateCode) {
		return commonUtil.getTemplete(stateCode).update(QueryHelperConstant.deleteReleasedMinioHistoryData(),reference);
	}

}
