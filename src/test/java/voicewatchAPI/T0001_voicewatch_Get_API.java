package voicewatchAPI;

import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.reuseable;
import files.vw_header;
import files.vw_resources;
import files.vw_reuseable;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class T0001_voicewatch_Get_API {
	

private static Logger log =LogManager.getLogger(T0001_voicewatch_Get_API.class.getName());

	
	Properties prop=new Properties();
	@BeforeTest
	public void getData() throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\hsingh\\Frameworks\\RestAssured_API\\src\\test\\java\\files\\data.properties");
		prop.load(fis);
		
	}
	
	@Test(priority=1)
	public void vw_Get_Test_Result() {
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation of Webapp server: "+prop.getProperty("webapp"));
			
		
		Response res= 
		given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
		when().get(vw_resources.Test_Results()).
		then().assertThat().statusCode(200).and().header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
		     		
		JsonPath js=vw_reuseable.rawToJson(res);
		log.debug("final result of Tet Result is: " +js.get());                            	               
		                                
	}

	@Test(priority=2)
	public void vw_Get_dashboard() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation of Webapp server: "+prop.getProperty("webapp"));
		
		
		Response res= 
		given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
		when().get(vw_resources.dashboard()).
		then().assertThat().statusCode(200).and().header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
		
							
		               JsonPath js=vw_reuseable.rawToJson(res);
		               log.debug("VoiceWatch Dashboard result: "+js.get());         
		            	
	}
	@Test(priority=3)
	public void VW_Variable() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation of Webapp server: "+prop.getProperty("webapp"));
		
		
		Response res= 
		given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
		when().get(vw_resources.variable()).
		then().assertThat().statusCode(200).and().header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
		
								
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("Variable Respose: "+js.get());   

}
	@Test(priority=4)
	public void VW_Tests() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation of Webapp server: "+prop.getProperty("webapp"));
		
		
		Response res= 
		given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
		when().get(vw_resources.Tests()).
		then().assertThat().statusCode(200).and().header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
		
		
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("Tests Respose: "+js.get());   
}
	/*@Test(priority=5)
	public void VW_Test_Execute() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation of Webapp server: "+prop.getProperty("webapp"));
		
		
		Response res= given().relaxedHTTPSValidation().header(vw_header.content(), vw_header.content_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
			        when().get("/tests/2041/execute").then().assertThat().statusCode(200).extract().response();
		
		
		
        JsonPath js=reuseable.rawToJson(res);
       log.debug("Tests Execute: "+js.get());   
	
	}	*/

	@Test(priority=6)
	public void VW_scripts() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation of Webapp server: "+prop.getProperty("webapp"));
		
		
		Response res= 
		given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
	    when().get(vw_resources.Scripts()).
	    then().assertThat().statusCode(200).and().header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
				
					
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("Script Respose: "+js.get());   
}
	
	@Test(priority=7)
	public void script_summary() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation of Webapp server: "+prop.getProperty("webapp"));
		
		
		Response res= 
		given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
		when().get(vw_resources.Scripts_summary()).
		then().assertThat().statusCode(200).and().header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
		
		               JsonPath js=reuseable.rawToJson(res);
		               log.debug("script summary: "+js.get());   
	
	}	
	
	@Test(priority=8)
	public void VW_user_info() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation of Webapp server: "+prop.getProperty("webapp"));
		
		
		Response res= given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
	    when().get(vw_resources.User_info()).
	    then().assertThat().statusCode(200).and().header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
		
				       JsonPath js=reuseable.rawToJson(res);
		               log.debug("User Respose: "+js.get());   
}  

	@Test(priority=9)
	public void clients() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation of Webapp server: "+prop.getProperty("webapp"));
		
		
		Response res= 
		given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
		when().get(vw_resources.Clients()).
		then().assertThat().statusCode(200).and().header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
		
		               JsonPath js=reuseable.rawToJson(res);
		               log.debug("clients Respose: "+js.get());   
}  
	
	@Test(priority=10)
	public void parteners() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation of Webapp server: "+prop.getProperty("webapp"));
		
		
		Response res= 
	    given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
		when().get(vw_resources.Patners()).
		then().assertThat().statusCode(200).and().header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
		
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("partners Respose: "+js.get());   
}  
	
	@Test(priority=11)
	public void profiles() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation of Webapp server: "+prop.getProperty("webapp"));
		
		
		Response res= 
		given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
		when().get(vw_resources.Profiles()).
		then().assertThat().statusCode(200).and().header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
		
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("Profile Respose: "+js.get());   
}  
	@Test(priority=12)
	public void clients_details() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation of Webapp server: "+prop.getProperty("webapp"));
		
		
		Response res= 
	    given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
		when().get(vw_resources.Client_Details()).
		then().assertThat().statusCode(200).header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
		
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("Voicewatch Respose of Clients details from dropdown: "+js.get());   
	
	}	
	
	@Test(priority=13)
	public void hammer_details() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation of Webapp server: "+prop.getProperty("webapp"));
		
		
		Response res= given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
	    when().get(vw_resources.Hammer_Groups()).
	    then().assertThat().statusCode(200).header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
		
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("Voicewatch Respose of Hammer group details: "+js.get());   
	
	}	
	
	@Test(priority=14)
	public void tags() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation of Webapp server: "+prop.getProperty("webapp"));
		
		
		Response res= 
		given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
	    when().get(vw_resources.Tags()).
	    then().assertThat().statusCode(200).header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
		
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("Voicewatch Respose of Tags: "+js.get());   
	
	}	
	
	@Test(priority=15)
	public void notification() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation of Webapp server: "+prop.getProperty("webapp"));
		
		
		Response res= 
		given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
		when().get(vw_resources.Notification()).
		then().assertThat().statusCode(200).header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
		
		
				       JsonPath js=reuseable.rawToJson(res);
		               log.debug("Notification Respose: "+js.get());   
	
	}	
	

	@Test(priority=16)
	public void hammer_labels() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation of Webapp server: "+prop.getProperty("webapp"));
		
		
		Response res= 
	    given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
		when().get(vw_resources.Hammer_labels()).
		then().assertThat().statusCode(200).header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
		
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("Voicewatch Respose of hammer labels details: "+js.get());   
	
	}	
	
	@Test(priority=17)
	public void admin() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation of Webapp server: "+prop.getProperty("webapp"));	
		
		Response res= 
		given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
		when().get(vw_resources.admin()).
		then().assertThat().statusCode(200).header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
		
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("Voicewatch Respose of Admin Dashboard summary: "+js.get());   
	
	}	
	
	/*@Test(priority=18)
	public void admin_dashboard() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation of Webapp server: "+prop.getProperty("webapp"));
		
		
		Response res= 
		given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
	    when().get(vw_resources.admin_dashboard()).
	    then().assertThat().statusCode(408).header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
		                     
		                                  String Hello=res.asString();
		                                                                

		                               
		                                 log.debug("Responses Value of admin_dashboard: " +Hello);
		                                  
						JsonPath js=reuseable.rawToJson(res);
		               log.debug("Voicewatch Respose of Admin Dashboard Details: "+js.get());   
	
	}	*/
	
	/*@Test(priority=19)
	public void alerts() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		
		
		Response res= given().relaxedHTTPSValidation().header(vw_header.content(), vw_header.content_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
			        when().get("/webapp/triggered-alerts").then().assertThat().statusCode(200).extract().response();
		
		
						String ResposeString=res.asString();
				        log.info("Voicewatch Respose of Alerts Details: "+ ResposeString);
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("Alerts details: "+js.get());   
	
	}	*/
	
	@Test(priority=20)
	public void hammers() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation of Webapp server: "+prop.getProperty("webapp"));
		
		
		Response res= 
		given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
	    when().get(vw_resources.hammers()).
	    then().assertThat().statusCode(200).header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
		                     
		                                  
		                                 JsonPath js=reuseable.rawToJson(res);
		          		               log.debug("Voicewatch Respose of Hammers: "+js.get());   
	
	}	
	

	@Test(priority=21)
	public void databanks() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation of Webapp server: "+prop.getProperty("webapp"));
		
		
		Response res= 
		given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
	    when().get(vw_resources.databanks()).
	    then().assertThat().statusCode(200).header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
		                     
		                                  
		                                 JsonPath js=reuseable.rawToJson(res);
		          		               log.debug("Voicewatch Respose of Databanks: "+js.get());   
	
	}	
	
	@Test(priority=22)
	public void channel_groups() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation of Webapp server: "+prop.getProperty("webapp"));
		
		
		Response res= 
		given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
	    when().get(vw_resources.applications()).
	    then().assertThat().statusCode(200).header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
		                     
		                                  
		                                 JsonPath js=reuseable.rawToJson(res);
		          		               log.debug("Voicewatch Respose of Channel-Groups: "+js.get());  	
	}	
	
	@Test(priority=23)
	public void email_Temp() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation of Webapp server: "+prop.getProperty("webapp"));
		
		
		Response res= 
		given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
	    when().get(vw_resources.channel_groups()).
	    then().assertThat().statusCode(200).header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
		                     
		                                  
		                                 JsonPath js=reuseable.rawToJson(res);
		          		               log.debug("Voicewatch Respose of Email_Templates: "+js.get());   
	
	}	
	
	
	
}


