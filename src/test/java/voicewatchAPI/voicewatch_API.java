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

public class voicewatch_API {
	

private static Logger log =LogManager.getLogger(voicewatch_API.class.getName());

	
	Properties prop=new Properties();
	@BeforeTest
	public void getData() throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\hsingh\\Frameworks\\RestAssured_API\\src\\test\\java\\files\\data.properties");
		prop.load(fis);
		
	}
	
	@Test(priority=1)
	public void vw_Get_Test_Result() {
		
		
		RestAssured.baseURI="https://os-2k16-vm332.empirix.com";
		
		
		Response hari= given().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).
			        when().get("/webapp/test-results").then().assertThat().statusCode(200).extract().response();
		
		                                JsonPath js=reuseable.rawToJson(hari);
		               log.debug(js.get());                            	               
		                                
	}

	
	
	@Test(priority=2)
	public void vw_Get_vw_dashboard() {
		
		
		RestAssured.baseURI="https://os-2k16-vm332.empirix.com";
		
		
		Response hari= given().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).
			        when().get("/webapp/vw-dashboard").then().assertThat().statusCode(200).extract().response();
		
		                                JsonPath js=reuseable.rawToJson(hari);
		               log.debug(js.get());         
		            	
	}
	@Test(priority=3)
	public void vw_Get_vw_Variable() {
		
		
		RestAssured.baseURI="https://os-2k16-vm332.empirix.com";
		
		
		Response hari= given().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID()).
			        when().get("/webapp/global-variables/27").then().assertThat().statusCode(200).extract().response();
		
		                                JsonPath js=reuseable.rawToJson(hari);
		               log.debug(js.get());   

}
}