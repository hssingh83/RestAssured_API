package voicewatchAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.reuseable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class voicewatch_Get_API {
	

private static Logger log =LogManager.getLogger(voicewatch_Get_API.class.getName());

	
	Properties prop=new Properties();
	@BeforeTest
	public void getData() throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\hsingh\\Frameworks\\RestAssured_API\\src\\test\\java\\files\\data.properties");
		prop.load(fis);
		
	}
	
	@Test(priority=1)
	public void vw_Get_Test_Result() {
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation Webapp server: "+prop.getProperty("webapp"));
		
	//	RestAssured.baseURI="https://os-2k16-vm332.empirix.com";
		
		
		            Response res= given().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).
			        when().get("/webapp/test-results").then().assertThat().statusCode(200).extract().response();
		            
		            String ResposeString=res.asString();
                    log.info("Test Result-Respose: "+ ResposeString);
		
		            JsonPath js=reuseable.rawToJson(res);
		            log.debug("final result of Tet Result is: " +js.get());                            	               
		                                
	}

	@Test(priority=2)
	public void vw_Get_vw_dashboard() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		
		
		Response res= given().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).
			        when().get("/webapp/vw-dashboard").then().assertThat().statusCode(200).extract().response();
		
						 String ResposeString=res.asString();
				         log.info("Voicewatch Respose: "+ ResposeString);
		
		               JsonPath js=reuseable.rawToJson(res);
		               log.debug("VoiceWatch Dashboard result: "+js.get());         
		            	
	}
	@Test(priority=3)
	public void VW_Variable() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		
		
		Response res= given().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).
			        when().get("/webapp/global-variables/27").then().assertThat().statusCode(200).extract().response();
		
		
						String ResposeString=res.asString();
				        log.info("Voicewatch Respose of Variable: "+ ResposeString);
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("Variable Respose: "+js.get());   

}
	@Test(priority=4)
	public void VW_Tests() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		
		
		Response res= given().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).
			        when().get("/webapp/tests").then().assertThat().statusCode(200).extract().response();
		
		
						String ResposeString=res.asString();
				        log.info("Voicewatch Respose of Tests: "+ ResposeString);
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("Tests Respose: "+js.get());   
}
	/*@Test(priority=5)
	public void VW_Test_Execute() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		
		
		Response res= given().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).
			        when().get("/tests/2041/execute").then().assertThat().statusCode(200).extract().response();
		
		
						String ResposeString=res.asString();
				        log.info("Voicewatch Respose of Tests_Execute: "+ ResposeString);
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("Tests Execute Respose: "+js.get());   
	
	}	*/

	@Test(priority=6)
	public void VW_scripts() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		
		
		Response res= given().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).
			        when().get("/webapp/scripts").then().assertThat().statusCode(200).extract().response();
		
		
						String ResposeString=res.asString();
				        log.info("Voicewatch Respose of Scripts: "+ ResposeString);
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("Script Respose: "+js.get());   
}
	
	@Test(priority=7)
	public void script_summary() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		
		
		Response res= given().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).
			        when().get("/webapp/scripts/summary").then().assertThat().statusCode(200).extract().response();
		
		
						String ResposeString=res.asString();
				        log.info("Voicewatch Respose of script summary: "+ ResposeString);
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("script summary: "+js.get());   
	
	}	
	
	@Test(priority=8)
	public void VW_user_info() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		
		
		Response res= given().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).
			        when().get("/webapp/user-info").then().assertThat().statusCode(200).extract().response();
		
		
						String ResposeString=res.asString();
				        log.info("Voicewatch Respose of User Info: "+ ResposeString);
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("User Respose: "+js.get());   
}  

	@Test(priority=9)
	public void clients() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		
		
		Response res= given().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).
			        when().get("/webapp/clients").then().assertThat().statusCode(200).extract().response();
		
		
						String ResposeString=res.asString();
				        log.info("Voicewatch Respose of clients Info: "+ ResposeString);
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("clients Respose: "+js.get());   
}  
	
	@Test(priority=10)
	public void parteners() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		
		
		Response res= given().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).
			        when().get("/webapp/partners").then().assertThat().statusCode(200).extract().response();
		
		
						String ResposeString=res.asString();
				        log.info("Voicewatch Respose of partners Info: "+ ResposeString);
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("partners Respose: "+js.get());   
}  
	
	@Test(priority=11)
	public void profiles() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		
		
		Response res= given().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).
			        when().get("/webapp/users/admin/notifications").then().assertThat().statusCode(200).extract().response();
		
		
						String ResposeString=res.asString();
				        log.info("Voicewatch Respose of Profile details of User: "+ ResposeString);
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("Profile Respose: "+js.get());   
}  
	@Test(priority=12)
	public void clients_details() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		
		
		Response res= given().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).
			        when().get("/webapp/clients/-2/info").then().assertThat().statusCode(200).extract().response();
		
		
						String ResposeString=res.asString();
				        log.info("Voicewatch Respose of Clients details from dropdown: "+ ResposeString);
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("Clients deatils Respose: "+js.get());   
	
	}	
	
	@Test(priority=13)
	public void hammer_details() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		
		
		Response res= given().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).
			        when().get("/webapp/hammer-groups").then().assertThat().statusCode(200).extract().response();
		
		
						String ResposeString=res.asString();
				        log.info("Voicewatch Respose of Hammer group details: "+ ResposeString);
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("Hammer deatils Respose: "+js.get());   
	
	}	
	
	@Test(priority=14)
	public void tags() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		
		
		Response res= given().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).
			        when().get("/webapp/tags").then().assertThat().statusCode(200).extract().response();
		
		
						String ResposeString=res.asString();
				        log.info("Voicewatch Respose of Tags details: "+ ResposeString);
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("Tag Respose: "+js.get());   
	
	}	
	
	@Test(priority=15)
	public void notification() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		
		
		Response res= given().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).
			        when().get("/webapp/notifications").then().assertThat().statusCode(200).extract().response();
		
		
						String ResposeString=res.asString();
				        log.info("Voicewatch Respose of Notification details: "+ ResposeString);
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("Notification Respose: "+js.get());   
	
	}	
	

	@Test(priority=16)
	public void hammer_labels() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		
		
		Response res= given().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).
			        when().get("/webapp/hammer-labels").then().assertThat().statusCode(200).extract().response();
		
		
						String ResposeString=res.asString();
				        log.info("Voicewatch Respose of hammer labels details: "+ ResposeString);
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("Notification Respose: "+js.get());   
	
	}	
	
	@Test(priority=17)
	public void admin() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		
		
		Response res= given().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).
			        when().get("/webapp/admin-dashboard/summary").then().assertThat().statusCode(200).extract().response();
		
		
						String ResposeString=res.asString();
				        log.info("Voicewatch Respose of Admin Dashboard summary: "+ ResposeString);
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("Dashboard Summary: "+js.get());   
	
	}	
	
	@Test(priority=18)
	public void admin_dashboard() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		
		
		Response res= given().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).
			        when().get("/webapp/admin-dashboard/details").then().assertThat().statusCode(200).extract().response();
		
		
						String ResposeString=res.asString();
				        log.info("Voicewatch Respose of Admin Dashboard Details: "+ ResposeString);
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("Admin dashboard details: "+js.get());   
	
	}	
	
	/*@Test(priority=19)
	public void alerts() {
		
		
		RestAssured.baseURI=prop.getProperty("webapp");
		
		
		Response res= given().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).
			        when().get("/webapp/triggered-alerts").then().assertThat().statusCode(200).extract().response();
		
		
						String ResposeString=res.asString();
				        log.info("Voicewatch Respose of Alerts Details: "+ ResposeString);
		                JsonPath js=reuseable.rawToJson(res);
		               log.debug("Alerts details: "+js.get());   
	
	}	*/
	
	
	
}


