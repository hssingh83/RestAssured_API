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
import files.vw_reuseable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class voicewatch_Put_API {
	

private static Logger log =LogManager.getLogger(voicewatch_Put_API.class.getName());

	
	Properties prop=new Properties();
	@BeforeTest
	public void getData() throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\hsingh\\Frameworks\\RestAssured_API\\src\\test\\java\\files\\data.properties");
		prop.load(fis);
		
	}
	
	@Test(priority=1)
	public void vw_get_Tag() {
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation Webapp server: "+prop.getProperty("webapp"));
		
			
			
	/*	  Response res= given().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).body("{\"name\": \"kakao111\"}").
			        when().post("/webapp/tags").then().assertThat().statusCode(200).extract().response();
		            

	                JsonPath js=reuseable.rawToJson(res);
	               log.debug("User Respose: "+js.get("id")); 
	               
	                           int id=js.get("id"); */ 
		
		
		            
	                           //Task 3 place this Tag id in the Delete request
	       			  		given().log().all().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).
	       			  		body("{"+
	       			  	        "\"id\": 25,"+
	       			         "\"name\": \"kaka6\""+
	       			     "}").
	       			  		when().put("/webapp/tags").then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
	       				//	body("status",equalTo("OK"));
		            
		      
		}}

	
	