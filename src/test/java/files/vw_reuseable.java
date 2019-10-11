package files;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import voicewatchAPI.voicewatch_Get_API;

public class vw_reuseable {
	
private static Logger log =LogManager.getLogger(voicewatch_Get_API.class.getName());

	
	

	
	
	public static String getTokenID() {
		
	RestAssured.baseURI="https://os-2k16-vm333.empirix.com";
	
	log.info("Host infomation OpenAM server:https://os-2k16-vm333.empirix.com");
	
		
  
   Response res=given().relaxedHTTPSValidation().header("Content-Type","application/json").header("X-OpenAM-Username","admin").header("X-OpenAM-Password","password").
		        when().post("/openam/json/authenticate").
		        then().assertThat().statusCode(200).extract().response();
   
                                          String ResposeString=res.asString();
                                          log.info("Auth-Respose: "+ ResposeString);
   
                           JsonPath js=vw_reuseable.rawToJson(res);
                          String iPlanetDirectoryPro= js.get("tokenId");
                          
               return iPlanetDirectoryPro;            
 
  
 // System.out.println(iPlanetDirectoryPro);
		
		
	}
	

	public static XmlPath rawToXML(Response r)
	{
	
		
		String respon=r.asString();
		XmlPath x=new XmlPath(respon);
		return x;
		
	}
	
	public static JsonPath rawToJson(Response r)
	{ 
		String respon=r.asString();
		JsonPath x=new JsonPath(respon);
		return x;
	}

}
