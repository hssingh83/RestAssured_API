package basicapi;

import static io.restassured.RestAssured.given;

import files.resources;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.payLoads;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;




public class TC0005_Post_Deletet_API_optimizing_Testing {
	private static Logger log =LogManager.getLogger(TC0005_Post_Deletet_API_optimizing_Testing.class.getName());


	Properties prop=new Properties();
	@BeforeTest
	public void getData() throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\hsingh\\Frameworks\\RestAssured_API\\src\\test\\java\\files\\data.properties");
		prop.load(fis);
		
	}
	
	@Test(priority=1)
	public void post_delete_RestApi_on_Google_search_Server() {
		
		String url= RestAssured.baseURI=prop.getProperty("Host2");
		log.info("Access to URL" +url);
		
		Response res= given().
		queryParam("key",prop.getProperty("Key1")).
		body (payLoads.getPostData05_1()).		
     	
         when().post(resources.placePostData5_1()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
        body("status",equalTo("OK")).extract().response();
		
		// Task 2- Grab the Place ID from response
		String responseString=res.asString();
		JsonPath js= new JsonPath(responseString);
		String placeid=js.get("place_id");
	
	    log.info("Verified Status code 200 after posting successfully");
	    log.info("Verified Content type of posting is JSON");
	    log.info("Verified that following are the response details of post" +responseString);
	    log.info("Verified that following placeID found: " +placeid);
	    
	  //Task 3 place this place id in the Delete request
	  		given().
	  		queryParam("key",prop.getProperty("Key1")).
	  		body("{"+
	  		"\"place_id\": \""+placeid+"\""+
	  		"}").when().post("/maps/api/place/delete/json").
	  		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
			body("status",equalTo("OK"));
	    
  
	    
	  		log.info("Verified Status code 200 after deleting place ID: " +placeid);
		    log.info("Verified Content type od deleteing is JSON after deleting");
		    log.info("Verified that Status is OK after deleting");
	}
	
	
	@Test(priority=2)
	public void post_delete_RestApi_on_reqres_server() {
		
		String url2= RestAssured.baseURI=prop.getProperty("Host1");
		log.info("Access to URL" +url2);
		
		Response res2=given().body (payLoads.getPostData05_2()).
         when().post(resources.placePostData5_2()).
		then().assertThat().statusCode(201).and().contentType(ContentType.JSON)
		.and().
		extract().response();
		
		// Task 2- Grab the Place ID from response
		String responseString=res2.asString();
		JsonPath js= new JsonPath(responseString);
		String tokenid=js.get("id");
	
	    log.info("Verified Status code 201 after posting successfully");
	    log.info("Verified Content type of posting is JSON");
	    log.info("Verified that following are the response details of post" +responseString);
	    log.info("Verified that following tokenID found: " +tokenid);
	    
	  //Task 3 place this place id in the Delete request
	  		given().
	  		
	  		body("{"+
	  		"\"token_id\": \""+tokenid+"\""+
	  		"}").when().post("/api/login/delete/json").
	  		then().assertThat().statusCode(201).and().contentType(ContentType.JSON); 
  
	    
	  		log.info("Verified Status code 201 after deleting place ID: " +tokenid);
		    log.info("Verified Content type od deleteing is JSON after deleting");
		   
	}
	
	

}
