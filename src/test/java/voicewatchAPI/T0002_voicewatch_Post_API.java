package voicewatchAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.reuseable;
import files.vw_header;
import files.vw_payLoads;
import files.vw_resources;
import files.vw_reuseable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class T0002_voicewatch_Post_API {
	

private static Logger log =LogManager.getLogger(T0002_voicewatch_Post_API.class.getName());

	
	Properties prop=new Properties();
	@BeforeTest
	public void getData() throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\hsingh\\Frameworks\\RestAssured_API\\src\\test\\java\\files\\data.properties");
		prop.load(fis);
		
	}
	
	@Test(priority=1)
	public void vw_Add_Tag() {
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation Webapp server: "+prop.getProperty("webapp"));
		
	
	
	Response res= given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
	body(vw_payLoads.tag(vw_reuseable.getSaltString())).
	when().post(vw_resources.Tags()).
	then().assertThat().statusCode(200).extract().response();
		            

	                JsonPath js=reuseable.rawToJson(res);
	               log.debug("User Respose: "+js.get("id")); 
	               
	                          int id =js.get("id");
	                          
	                          log.debug("Tag ID info: "+id);

	                          
	}            
		            
		//=========================================================================================            
		    
	@Test(priority=2)
	public void vw_Add_Client() {
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation Webapp server: "+prop.getProperty("webapp"));
		
	
	
	Response res= given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
	body(vw_payLoads.getClinet(vw_reuseable.getSaltString())).
	when().post(vw_resources.Clients()).
	then().assertThat().statusCode(200).extract().response();
		            

	                JsonPath js=reuseable.rawToJson(res);
	               log.debug("Client Respose: "+js.get("id")); 
	               
	                          int id =js.get("id");
	                          
	                          log.debug("Client: " +vw_reuseable.getSaltString()+ " created successfully");
	 
	   RestAssured.baseURI=prop.getProperty("webapp");
	                          
	 Response resGet= 
	  given().log().all().relaxedHTTPSValidation().pathParam("id", id).header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
	  when().get("/webapp/clients/{id}").
	  then().assertThat().statusCode(200).and().header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
	                        			     		
	  JsonPath js1=vw_reuseable.rawToJson(resGet);
	  log.debug("final result of Tet Result is: " +js1.get());                            	               
	                        			                                
	                  		}
                       
           
       
	            
	
	}
	