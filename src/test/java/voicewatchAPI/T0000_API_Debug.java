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

public class T0000_API_Debug {
	

private static Logger log =LogManager.getLogger(T0000_API_Debug.class.getName());

	
	Properties prop=new Properties();
	@BeforeTest
	public void getData() throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\hsingh\\Frameworks\\RestAssured_API\\src\\test\\java\\files\\data.properties");
		prop.load(fis);
		
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


