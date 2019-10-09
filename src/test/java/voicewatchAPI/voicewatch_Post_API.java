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

public class voicewatch_Post_API {
	

private static Logger log =LogManager.getLogger(voicewatch_Post_API.class.getName());

	
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
	}
	