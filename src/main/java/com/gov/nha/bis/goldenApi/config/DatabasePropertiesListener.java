package com.gov.nha.bis.goldenApi.config;

import java.util.Properties;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

public class DatabasePropertiesListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
	  public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
		  if(System.getenv("POSTGRES_HOST_BH")!=null) {
		    ConfigurableEnvironment environment = event.getEnvironment();
		    Properties props = new Properties();
		    
		    
		    // ben_all Prod
		    props.put("spring.datasource.jdbcUrl", "jdbc:postgresql://"
		    		+ System.getenv("POSTGRES_HOST_BENALL") + ":" 
		    		+ System.getenv("POSTGRES_PORT_BENALL")	+ "/" 
		    		+ System.getenv("POSTGRES_DB_BENALL") + "?currentSchema="
		    		+ System.getenv("POSTGRES_SCHEMA_BENALL")	+ "&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		    props.put("spring.datasource.username", System.getenv("POSTGRES_USERNAME_BENALL"));
		    props.put("spring.datasource.password", System.getenv("POSTGRES_PWD_BENALL"));
		    props.put("spring.datasource.driverClassName", System.getenv("POSTGRES_DRIVER_BENALL"));
		    environment.getPropertySources().addFirst(new PropertiesPropertySource("datasource", props));
		    
		    // Haryana Prod
		    props.put("spring.datasource.jdbcUrl", "jdbc:postgresql://"
		    		+ System.getenv("POSTGRES_HOST_HR") + ":" 
		    		+ System.getenv("POSTGRES_PORT_HR")	+ "/" 
		    		+ System.getenv("POSTGRES_DB_HR") + "?currentSchema="
		    		+ System.getenv("POSTGRES_SCHEMA_HR")	+ "&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		    props.put("spring.datasource.username", System.getenv("POSTGRES_USERNAME_HR"));
		    props.put("spring.datasource.password", System.getenv("POSTGRES_PWD_HR"));
		    props.put("spring.datasource.driverClassName", System.getenv("POSTGRES_DRIVER_HR"));
		    environment.getPropertySources().addFirst(new PropertiesPropertySource("datasource", props));
		    
		    // Second DB
		    props.put("spring.second-db.jdbcUrl", "jdbc:postgresql://"
		    		+ System.getenv("POSTGRES_HOST_SECND") + ":" 
		    		+ System.getenv("POSTGRES_PORT_SECND")	+ "/" 
		    		+ System.getenv("POSTGRES_DB_SECND") + "?currentSchema="	
		    		+ System.getenv("POSTGRES_SCHEMA_SECND")	+ "&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		    props.put("spring.second-db.username", System.getenv("POSTGRES_USERNAME_SECND"));
		    props.put("spring.second-db.password", System.getenv("POSTGRES_PWD_SECND"));
		    props.put("spring.second-db.driverClassName", System.getenv("POSTGRES_DRIVER_SECND"));
		    environment.getPropertySources().addFirst(new PropertiesPropertySource("datasource", props));
		    
		    // Nagaland DB
		    props.put("spring.second-nagaland.jdbcUrl", "jdbc:postgresql://"
		    		+ System.getenv("POSTGRES_HOST_NAGA") + ":" 
		    		+ System.getenv("POSTGRES_PORT_NAGA")	+ "/" 
		    		+ System.getenv("POSTGRES_DB_NAGA") + "?currentSchema="	
		    		+ System.getenv("POSTGRES_SCHEMA_NAGA")	+ "&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		    props.put("spring.second-nagaland.username", System.getenv("POSTGRES_USERNAME_NAGA"));
		    props.put("spring.second-nagaland.password", System.getenv("POSTGRES_PWD_NAGA"));
		    props.put("spring.second-nagaland.driverClassName", System.getenv("POSTGRES_DRIVER_NAGA"));
		    environment.getPropertySources().addFirst(new PropertiesPropertySource("datasource", props));
		    
		    // Assam DB
		    props.put("spring.second-assam.jdbcUrl", "jdbc:postgresql://"
		    		+ System.getenv("POSTGRES_HOST_ASM") + ":" 
		    		+ System.getenv("POSTGRES_PORT_ASM")	+ "/" 
		    		+ System.getenv("POSTGRES_DB_ASM") + "?currentSchema="	
		    		+ System.getenv("POSTGRES_SCHEMA_ASM")	+ "&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		    props.put("spring.second-assam.username", System.getenv("POSTGRES_USERNAME_ASM"));
		    props.put("spring.second-assam.password", System.getenv("POSTGRES_PWD_ASM"));
		    props.put("spring.second-assam.driverClassName", System.getenv("POSTGRES_DRIVER_ASM"));
		    environment.getPropertySources().addFirst(new PropertiesPropertySource("datasource", props));
		    
		    // Bihar DB
		    props.put("spring.second-bihar.jdbcUrl", "jdbc:postgresql://"
		    		+ System.getenv("POSTGRES_HOST_BH") + ":" 
		    		+ System.getenv("POSTGRES_PORT_BH")	+ "/" 
		    		+ System.getenv("POSTGRES_DB_BH") + "?currentSchema="	
		    		+ System.getenv("POSTGRES_SCHEMA_BH")	+ "&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		    props.put("spring.second-bihar.username", System.getenv("POSTGRES_USERNAME_BH"));
		    props.put("spring.second-bihar.password", System.getenv("POSTGRES_PWD_BH"));
		    props.put("spring.second-bihar.driverClassName", System.getenv("POSTGRES_DRIVER_BH"));
		    environment.getPropertySources().addFirst(new PropertiesPropertySource("datasource", props));
		    
		    // Chandigarh DB
		    props.put("spring.second-chandigarh.jdbcUrl", "jdbc:postgresql://"
		    		+ System.getenv("POSTGRES_HOST_CHNG") + ":" 
		    		+ System.getenv("POSTGRES_PORT_CHNG")	+ "/" 
		    		+ System.getenv("POSTGRES_DB_CHNG") + "?currentSchema="	
		    		+ System.getenv("POSTGRES_SCHEMA_CHNG")	+ "&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		    props.put("spring.second-chandigarh.username", System.getenv("POSTGRES_USERNAME_CHNG"));
		    props.put("spring.second-chandigarh.password", System.getenv("POSTGRES_PWD_CHNG"));
		    props.put("spring.second-chandigarh.driverClassName", System.getenv("POSTGRES_DRIVER_CHNG"));
		    environment.getPropertySources().addFirst(new PropertiesPropertySource("datasource", props));
		    
		    // Chhatisgarh DB
		    props.put("spring.second-chhattisgarh.jdbcUrl", "jdbc:postgresql://"
		    		+ System.getenv("POSTGRES_HOST_CHHG") + ":" 
		    		+ System.getenv("POSTGRES_PORT_CHHG")	+ "/" 
		    		+ System.getenv("POSTGRES_DB_CHHG") + "?currentSchema="	
		    		+ System.getenv("POSTGRES_SCHEMA_CHHG")	+ "&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		    props.put("spring.second-chhattisgarh.username", System.getenv("POSTGRES_USERNAME_CHHG"));
		    props.put("spring.second-chhattisgarh.password", System.getenv("POSTGRES_PWD_CHHG"));
		    props.put("spring.second-chhattisgarh.driverClassName", System.getenv("POSTGRES_DRIVER_CHHG"));
		    environment.getPropertySources().addFirst(new PropertiesPropertySource("datasource", props));
		    
		    // Punjab DB
		    props.put("spring.second-punjab.jdbcUrl", "jdbc:postgresql://"
		    		+ System.getenv("POSTGRES_HOST_PJ") + ":" 
		    		+ System.getenv("POSTGRES_PORT_PJ")	+ "/" 
		    		+ System.getenv("POSTGRES_DB_PJ") + "?currentSchema="	
		    		+ System.getenv("POSTGRES_SCHEMA_PJ")	+ "useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		    props.put("spring.second-punjab.username", System.getenv("POSTGRES_USERNAME_PJ"));
		    props.put("spring.second-punjab.password", System.getenv("POSTGRES_PWD_PJ"));
		    props.put("spring.second-punjab.driverClassName", System.getenv("POSTGRES_DRIVER_PJ"));
		    environment.getPropertySources().addFirst(new PropertiesPropertySource("datasource", props));
		    
		    // UP DB
		    props.put("spring.second-up.jdbcUrl", "jdbc:postgresql://"
		    		+ System.getenv("POSTGRES_HOST_UP") + ":" 
		    		+ System.getenv("POSTGRES_PORT_UP")	+ "/" 
		    		+ System.getenv("POSTGRES_DB_UP") + "?currentSchema="	
		    		+ System.getenv("POSTGRES_SCHEMA_UP")	+ "&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		    props.put("spring.second-up.username", System.getenv("POSTGRES_USERNAME_UP"));
		    props.put("spring.second-up.password", System.getenv("POSTGRES_PWD_UP"));
		    props.put("spring.second-up.driverClassName", System.getenv("POSTGRES_DRIVER_UP"));
		    environment.getPropertySources().addFirst(new PropertiesPropertySource("datasource", props));
		    
		    // Jharkhand DB
		    props.put("spring.second-jharkhand.jdbcUrl", "jdbc:postgresql://"
		    		+ System.getenv("POSTGRES_HOST_JH") + ":" 
		    		+ System.getenv("POSTGRES_PORT_JH")	+ "/" 
		    		+ System.getenv("POSTGRES_DB_JH") + "?currentSchema="	
		    		+ System.getenv("POSTGRES_SCHEMA_JH")	+ "&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		    props.put("spring.second-jharkhand.username", System.getenv("POSTGRES_USERNAME_JH"));
		    props.put("spring.second-jharkhand.password", System.getenv("POSTGRES_PWD_JH"));
		    props.put("spring.second-jharkhand.driverClassName", System.getenv("POSTGRES_DRIVER_JH"));
		    environment.getPropertySources().addFirst(new PropertiesPropertySource("datasource", props));
		  
		    // transgender DB
		    props.put("spring.second-transgender.jdbcUrl", "jdbc:postgresql://"
		    		+ System.getenv("POSTGRES_HOST_TRANS") + ":" 
		    		+ System.getenv("POSTGRES_PORT_TRANS")	+ "/" 
		    		+ System.getenv("POSTGRES_DB_TRANS") + "?currentSchema="	
		    		+ System.getenv("POSTGRES_SCHEMA_TRANS")	+ "&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		    props.put("spring.second-jharkhand.username", System.getenv("POSTGRES_USERNAME_TRANS"));
		    props.put("spring.second-jharkhand.password", System.getenv("POSTGRES_PWD_TRANS"));
		    props.put("spring.second-jharkhand.driverClassName", System.getenv("POSTGRES_DRIVER_TRANS"));
		    environment.getPropertySources().addFirst(new PropertiesPropertySource("datasource", props));
		    
		    // secc_data DB
		    props.put("spring.second-seccdata.jdbcUrl", "jdbc:postgresql://"
		    		+ System.getenv("POSTGRES_HOST_SECCDATA") + ":" 
		    		+ System.getenv("POSTGRES_PORT_SECCDATA")	+ "/" 
		    		+ System.getenv("POSTGRES_DB_SECCDATA") + "?currentSchema="	
		    		+ System.getenv("POSTGRES_SCHEMA_SECCDATA")	+ "&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		    props.put("spring.second-seccdata.username", System.getenv("POSTGRES_USERNAME_SECCDATA"));
		    props.put("spring.second-seccdata.password", System.getenv("POSTGRES_PWD_SECCDATA"));
		    props.put("spring.second-seccdata.driverClassName", System.getenv("POSTGRES_DRIVER_SECCDATA"));
		    environment.getPropertySources().addFirst(new PropertiesPropertySource("datasource", props));
		    
		    //
		    props.put("UPDATE_TOKEN_IN_REDIS",System.getenv("UPDATE_TOKEN_IN_REDIS"));
		  
		  }
	  }
}