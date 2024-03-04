package com.gov.nha.bis.goldenApi.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@Configuration
@PropertySource({"classpath:application.properties"})
public class ApplicationConstantConfig {
	
	@Value("${UID_TOKEN_CHECK_URL}")
	public String UID_TOKEN_CHECK_URL;
	
//	@Value("${GOLDEN_API_CHECK}")
//	public String GOLDEN_API_CHECK;
	
	@Value("${TIN_CHECK_URL}")
	public String TIN_CHECK_URL;
	
	@Value("${HASH_CHECK_URL}")
	public String HASH_CHECK_URL;
	
	@Value("${REMOVE_TOEKN_HASH_URL}")
	public String REMOVE_TOEKN_HASH_URL;
	
	@Value("${REMOVE_TIN_URL}")
	public String REMOVE_TIN_URL;
	
	@Value("${RADIS_DOMAIN_START_URL}")
	public String RADIS_DOMAIN_START_URL;
	
	@Value("${RADIS_DOMAIN_END_URL}")
	public String RADIS_DOMAIN_END_URL;
	
	//----------------------------------------------
	
	
	@Value("${UPDATE_TOKEN_IN_REDIS}")
	public String UPDATE_TOKEN_IN_REDIS;
	
	@Value("${PHOTO_HEADER_TAG_1}")
	public String PHOTO_HEADER_TAG_1;
	
	@Value("${PHOTO_HEADER_VALUE_1}")
	public String PHOTO_HEADER_VALUE_1;

	@Value("${PHOTO_GATEWAY_URL}")
	public String PHOTO_GATEWAY_URL;
	
	@Value("${PHOTO_GATEWAY_CLIENT}")
	public String PHOTO_GATEWAY_CLIENT;
	
	@Value("${PHOTO_GATEWAY_SECRET}")
	public String PHOTO_GATEWAY_SECRET;
	
	@Value("${PHOTO_URL}")
	public String PHOTO_URL;
	
	@Value("${GOLDEN_API_TCS_10}")
	public String GOLDEN_API_TCS_10;
	
	@Value("${1_USERNAME}")
	public String ONE_USERNAME;
	
	@Value("${1_PASSWORD}")
	public String ONE_PASSWORD;
	
	@Value("${3_USERNAME}")
	public String THREE_USERNAME;
	
	@Value("${3_PASSWORD}")
	public String THREE_PASSWORD;
	
	@Value("${4_USERNAME}")
	public String FOUR_USERNAME;
	
	@Value("${4_PASSWORD}")
	public String FOUR_PASSWORD;
	
	@Value("${6_USERNAME}")
	public String SIX_USERNAME;
	
	@Value("${6_PASSWORD}")
	public String SIX_PASSWORD;

	@Value("${9_USERNAME}")
	public String NINE_USERNAME;
	
	@Value("${9_PASSWORD}")
	public String NINE_PASSWORD;
	
	@Value("${10_USERNAME}")
	public String TEN_USERNAME;
	
	@Value("${10_PASSWORD}")
	public String TEN_PASSWORD;
	
	@Value("${13_USERNAME}")
	public String THIRTEEN_USERNAME;
	
	@Value("${13_PASSWORD}")
	public String THIRTEEN_PASSWORD;
	
	@Value("${18_USERNAME}")
	public String EIGHTEEN_USERNAME;
	
	@Value("${18_PASSWORD}")
	public String EIGHTEEN_PASSWORD;
	
	@Value("${22_USERNAME}")
	public String TWENTY_TWO_USERNAME;
	
	@Value("${22_PASSWORD}")
	public String TWENTY_TWO_PASSWORD;
	
}