package com.gov.nha.bis.goldenApi.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringWriter;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.gov.nha.bis.goldenApi.properties.ApplicationConstantConfig;


@Service
public class CommonUtility {

	@Autowired
	ApplicationConstantConfig config;

	
	@Autowired
	@Qualifier("jdbcTemplateHaryana")
	private JdbcTemplate jdbcTemplateharyana;


	

	private static final Logger logger = LogManager.getLogger(CommonUtility.class);

	public JdbcTemplate getTemplete(String stateCode){return null;}

	public String getPhotoRequestBody(String pmjayId,String stateCode){
		JSONObject data= new JSONObject();

		if(stateCode.length()==1) {
			data.put("stateCode","0"+stateCode);
		}else {
			data.put("stateCode",stateCode);	
		}
		data.put("pmrssmid", pmjayId);


		switch (stateCode) {
		case MessageConstant.HARYANA:
			data.put("username", config.SIX_USERNAME);
			data.put("password", config.SIX_PASSWORD);
			break;
		case MessageConstant.JAMMUKASHMIR:
			data.put("username", config.ONE_USERNAME);
			data.put("password", config.ONE_PASSWORD);
			break;
		case MessageConstant.NAGALAND:
			data.put("username", config.THIRTEEN_USERNAME);
			data.put("password", config.THIRTEEN_PASSWORD);
			break;
		case MessageConstant.ASSAM:
			data.put("username", config.EIGHTEEN_USERNAME);
			data.put("password", config.EIGHTEEN_PASSWORD);
			break;
		case MessageConstant.BIHAR:
			data.put("username", config.TEN_USERNAME);
			data.put("password", config.TEN_PASSWORD);
			break;
		case MessageConstant.CHANDIGARH:
			data.put("username", config.FOUR_USERNAME);
			data.put("password", config.FOUR_PASSWORD);			
			break;
		case MessageConstant.CHATTISGARH:
			data.put("username", config.TWENTY_TWO_USERNAME);
			data.put("password", config.TWENTY_TWO_PASSWORD);			
			break;
		case MessageConstant.PUNJAB:
			data.put("username", config.THREE_USERNAME);
			data.put("password", config.THREE_PASSWORD);
			break;
		case MessageConstant.UP:
			data.put("username", config.NINE_USERNAME);
			data.put("password", config.NINE_PASSWORD);
			break;	
		default:

		}	
		logger.info("getPhotoRequestBody -"+data.toString());
		return data.toString();
	}

	public static String userRequest(String sAccessToken,String requestJson,String url,String header1_tag,String header1_value){
		String returnStr=null;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		try{
			logger.info(" Request URL---"+url);
			logger.info(" Request Json---"+requestJson);

			headers.setContentType(MediaType.APPLICATION_JSON);

			if(header1_tag!=null && !header1_tag.isEmpty()) {
				headers.set(header1_tag, header1_value);
			}

			if(sAccessToken!=null && !sAccessToken.isEmpty()) {
				headers.setBearerAuth(sAccessToken);
			}

			HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);

			returnStr = restTemplate.postForObject(url, entity, String.class);
			logger.info(" response Json---"+returnStr);
			return returnStr;
		}catch(HttpStatusCodeException e) {
			logger.error("HttpStatusCodeException error in---"+url+"-"+e.getResponseBodyAsString());
			return e.getResponseBodyAsString();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			restTemplate=null;headers=null;	
		}		
	}

	public static String getTokenOauth2_0(String clientId,String clientSecret,String OAUTH_ACCESS_TOKEN_URL){
		NhaSSSLUtil.setDefaultSSL();
		BufferedReader reader = null;
		HttpsURLConnection connection = null;
		String returnTokenValue = "";
		String auth = clientId + ":" + clientSecret;
		String authentication = Base64.getEncoder().encodeToString(auth.getBytes());
		String grantTypeContent ="grant_type=client_credentials";

		try {
			URL url = new URL(OAUTH_ACCESS_TOKEN_URL);
			connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setRequestProperty("Authorization", "basic " + authentication);
			connection.setRequestProperty("Accept", "application/json");

			PrintStream os = new PrintStream(connection.getOutputStream());
			os.print(grantTypeContent);
			os.close();
			reader = new BufferedReader(new
					InputStreamReader(connection.getInputStream()));
			String line = null;
			StringWriter out = new
					StringWriter(connection.getContentLength() > 0 ?
							connection.getContentLength() : 2048);
			while ((line = reader.readLine()) != null) {
				out.append(line);
			}
			String response = out.toString();
			returnTokenValue =new JSONObject(response.toString()).getString("access_token");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Error : " + e.getMessage());
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					logger.info("Error : " + e.getMessage());
				}
			}
			connection.disconnect();
		}
		//logger.info(returnTokenValue);
		return returnTokenValue;

	}

	public static void main(String[] args) {
		System.out.println(stringToDate("2022-10-15 12:56:49.785424+05:30"));
		
		System.out.println(addYearsToDate(stringToDate("2022-10-15 12:56:49.785424+05:30"),3));
	}
	
	public static Date stringToDate(String dateInString) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:sss");
		try {
			return formatter.parse(dateInString);
		}catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String datetoString(Date date) {
		SimpleDateFormat newFormatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			return newFormatter.format(date);
		}catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static Date addYearsToDate(Date date,int years) {
		try {
			Calendar c = Calendar.getInstance(); 
			c.setTime(date); 
			c.add(Calendar.YEAR, years);
			return c.getTime();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String fingYearInGivenString(String date) throws Exception{

		try {
			if(date.length()==4) {
				return date;
			}else {
				String dateFormat = "";

				if(date.matches("\\d{2}-\\d{2}-\\d{4}")) {
					dateFormat = "dd-MM-yyyy";
				}else if(date.matches("\\d{4}-\\d{2}-\\d{2}"))  {
					dateFormat = "yyyy-MM-dd";
				}

				SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);  
				Date parse = sdf.parse(date);  

				Calendar c = Calendar.getInstance();  
				c.setTime(parse);  

				return String.valueOf(c.get(Calendar.YEAR));
			}			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("som");
		}		
	}
	
}
