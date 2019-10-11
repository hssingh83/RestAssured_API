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
import io.restassured.specification.RequestSpecification;

public class voicewatch_Post_API {
	

private static Logger log =LogManager.getLogger(voicewatch_Post_API.class.getName());

	
	Properties prop=new Properties();
	@BeforeTest
	public void getData() throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\hsingh\\Frameworks\\RestAssured_API\\src\\test\\java\\files\\data.properties");
		prop.load(fis);
		
	}
	
	@Test(priority=1)
	public void vw_post_Tag() {
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation Webapp server: "+prop.getProperty("webapp"));
		
	
		
	Response res= given().log().all().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookie", "iPlanetDirectoryPro="+reuseable.getTokenID())
	.body("{\"name\": \"okaol56kll\"}").
	 when().post("/webapp/tags").then().assertThat().statusCode(200).extract().response();
		            
		            
		    //        String ResposeString=res.asString();
			 //       log.info("Voicewatch Respose of User Info: "+ res);
	                JsonPath js=reuseable.rawToJson(res);
	               log.debug("User Respose: "+js.get("id")); 
	               
	                          int id =js.get("id");
	                          
	                          log.debug("info: "+id);
		            
		            
		//=========================================================================================            
		            
		          //Task 3 place this Tag id in the Delete request
			  	given().log().all().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookies", "iPlanetDirectoryPro="+reuseable.getTokenID()).
			  		body("{"+
			  		"\"id\": \""+id+"\""+
			  		"\"scopes\": [ \"READ\", \"WRITE\" ]"+
			  		"}").
			  		when().delete("/webapp/tags/").then().assertThat().statusCode(200);
	                          
	                          
	               /*           given().log().all().relaxedHTTPSValidation().header("Content-Type","application/json").header("Cookies", "iPlanetDirectoryPro="+reuseable.getTokenID()).
	      			  		when().delete("/webapp/tags/{55}").then().assertThat().statusCode(200);  */    
		

			  	
		
			  /*	 given().baseUri("https://os-2k16-vm332.empirix.com").basePath("/webapp/tags").delete("/55");*/
		            
		}

	}
	