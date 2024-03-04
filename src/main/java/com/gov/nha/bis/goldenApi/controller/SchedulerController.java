package com.gov.nha.bis.goldenApi.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gov.nha.bis.goldenApi.model.TreleaseDataEntity;
import com.gov.nha.bis.goldenApi.service.SchedulerService;
import com.gov.nha.bis.goldenApi.util.MessageConstant;

@RestController
@RequestMapping("/sche")
@CrossOrigin
public class SchedulerController extends NhaGoldenApiBaseController  {

	private static final Logger logger = LoggerFactory.getLogger(SchedulerController.class);
	
//	@Autowired
//	GoldenApiService apiservice;	
	
	@Autowired
	SchedulerService schedSvc;
	
	
	@GetMapping(value ="/deleteupdta")
	public String releaseSecheduler() {		
		logger.info("scheduleRelease ===== starts");
		try {
				return schedSvc.getReleaseData();
		}catch (Exception e) {
			logger.info("error in scheduleRelease controller====="+e);
			e.printStackTrace();
			return MessageConstant.RESPONSE_FAILED;
		}finally{
		}	
	}
	
//	@PostMapping(value ="/releaseTokenHashTin")
//	public Map<String, Object> releaseTokenHashTin(@RequestBody TreleaseDataEntity req ) {		
//		logger.info("releaseTokenHashTin ===== starts");
////		GoldenApiResponse resp = null;
//		Map<String, Object> respo = new HashMap<>();
//		try {
//			respo =  schedSvc.getReleaseDataByRefid(req.getRefernceid(),req.getStateCode());
//			return respo;
//		}catch (Exception e) {
//			logger.info("error in releaseTokenHashTin controller====="+e);
//			e.printStackTrace();
//			return respo;
//		}finally{
//		}	
//	}

}
