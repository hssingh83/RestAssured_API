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

import com.aventstack.extentreports.model.Log;

import files.reuseable;
import files.vw_header;
import files.vw_payLoads;
import files.vw_resources;
import files.vw_reuseable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class T0008_voicewatch_Hammer_ETE_API {
	

private static Logger log =LogManager.getLogger(T0008_voicewatch_Hammer_ETE_API.class.getName());

	
	Properties prop=new Properties();
	@BeforeTest
	public void getData() throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\hsingh\\Frameworks\\RestAssured_API\\src\\test\\java\\files\\data.properties");
		prop.load(fis);
		
	}
	
	@Test(priority=1)
	public void validate_Clients_Feature() {
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation Webapp server: "+prop.getProperty("webapp"));
		
	
	
	Response res= given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
	body(vw_payLoads.getClinet(vw_reuseable.getSaltString())).
	when().post(vw_resources.Clients()).
	then().assertThat().statusCode(200).and().header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
		            

	                JsonPath js_post=reuseable.rawToJson(res);
	               log.debug("Client ID: "+js_post.get("id")); 
	               
	                          int Post_id =js_post.get("id");
	                          
	                          log.debug("Client Name: : " +vw_reuseable.getSaltString()+ " created successfully");
	 
	                RestAssured.baseURI=prop.getProperty("webapp");
	                          
                
	  Response resGet= 
      given().log().all().relaxedHTTPSValidation().pathParam("id",Post_id).header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
	  when().get(vw_resources.Clients_Path()).
	  then().assertThat().statusCode(200).and().header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
				
				                JsonPath js_get=reuseable.rawToJson(resGet);
				               log.debug("Get repose of Generated Tag ID of Voicewatch: "+js_get.get("id"));  
				               
				               int Get_id =js_get.get("id");		                          
		                       log.debug("Tag ID info: "+Get_id);
	                          
				        if (Get_id==Post_id)
				        {
				        	log.debug("Post Clients ID: "+Post_id+ " and Get Clients ID: "+Get_id+ " is equal,So Test Case Pass successfully" );
				        					        	
				        } else if (Get_id!=Post_id) {
				        	
				        	log.debug("Post Clients ID: "+Post_id+" and Get Clients ID: "+Get_id+ " is not equal,So Test Case failed" );
				        				        	
				        }
                   	   
	                   }         
				         
				        }                             	               
	                        			                                

                       


	