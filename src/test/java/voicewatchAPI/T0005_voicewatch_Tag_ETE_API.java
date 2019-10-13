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

public class T0005_voicewatch_Tag_ETE_API {
	

private static Logger log =LogManager.getLogger(T0005_voicewatch_Tag_ETE_API.class.getName());

	
	Properties prop=new Properties();
	@BeforeTest
	public void Validate_Tag() throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\hsingh\\Frameworks\\RestAssured_API\\src\\test\\java\\files\\data.properties");
		prop.load(fis);
		
	}
	
	@Test(priority=1)
	public void validate_Tag_Feature() {
		
		RestAssured.baseURI=prop.getProperty("webapp");
		log.info("Host infomation Webapp server: "+prop.getProperty("webapp"));
		
	
	
	Response res= given().log().all().relaxedHTTPSValidation().header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
	body(vw_payLoads.tag(vw_reuseable.getSaltString())).
	when().post(vw_resources.Tags()).
	then().assertThat().statusCode(200).and().header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
		            

	                JsonPath js_post=reuseable.rawToJson(res);
	               log.debug("Added New Tag ID: "+js_post.get("id")); 
	               
	                          int Post_id =js_post.get("id");
	                          
	                          log.debug("Tag ID info: "+Post_id);
	 
	      RestAssured.baseURI=prop.getProperty("webapp");
	      
	  Response resGet= 
      given().log().all().relaxedHTTPSValidation().pathParam("id",Post_id).header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
	  when().get(vw_resources.Tags_Path()).
	  then().assertThat().statusCode(200).and().header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response();
				
				                JsonPath js_get=reuseable.rawToJson(resGet);
				               log.debug("Get repose of Generated Tag ID of Voicewatch: "+js_get.get("id"));  
				               
				               int Get_id =js_post.get("id");		                          
		                       log.debug("Tag ID info: "+Get_id);
	                          
				        if (Get_id==Post_id)
				        {
				        	log.debug("Post Tag ID: "+Post_id+ " and Get Tag ID: "+Get_id+ " is equal,So Test Case Pass successfully" );
				        					        	
				        } else if (Get_id!=Post_id) {
				        	
				        	log.debug("Post Tag ID: "+Post_id+" and Get Tag ID: "+Get_id+ " is not equal,So Test Case failed" );
				        				        	
				        }
      
				        RestAssured.baseURI=prop.getProperty("webapp"); 
		                
	   Response del=
	   	given().log().all().relaxedHTTPSValidation().pathParam("id", Post_id).header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
		when().delete(vw_resources.Tags_Path()).
		then().assertThat().statusCode(200).and().header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response(); 	   
			   
	   
	   			   	 
				   	     JsonPath js_del=reuseable.rawToJson(del);
				         log.debug("Delete Tag id is: "+js_del.get());
				         
				         
				         
				         RestAssured.baseURI=prop.getProperty("webapp"); 
				         
	  String resGetAgain= 
	   
		given().log().all().relaxedHTTPSValidation().pathParam("id", Post_id).header(vw_header.Content_Type(), vw_header.content_Type_value()).header(vw_header.cookie(), vw_header.cookie_value()+reuseable.getTokenID()).
		when().get(vw_resources.Tags_Path()).
		then().assertThat().statusCode(200).and().header(vw_header.Content_Type_Option(),vw_header.Content_Type_Option_value()).and().header(vw_header.Content_Type(),vw_header.content_Type_value()).extract().response().asString();      		  
	 
	                   log.info("Again Get response is: " +resGetAgain);
	                
	  
	                   if (resGetAgain != null) {
	                	   
	                	   log.debug("Created tag id delete successfully");
	                	   
	                   } else {
	                	   
	                	   log.debug("Created tag id still avaiable");
	                		   
	                		   
	                	   }
	                	
	                	   
	                   }         
				         
				        }                             	               
	                        			                                

                       


	