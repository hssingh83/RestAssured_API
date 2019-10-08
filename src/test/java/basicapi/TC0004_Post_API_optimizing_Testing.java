package basicapi;

import static io.restassured.RestAssured.given;

import files.resources;
import files.payLoads;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

 
public class TC0004_Post_API_optimizing_Testing {
	private static Logger log =LogManager.getLogger(TC0004_Post_API_optimizing_Testing.class.getName());

	
   Properties prop=new Properties();
	@BeforeTest
	public void getData() throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\hsingh\\Frameworks\\RestAssured_API\\src\\test\\java\\files\\data.properties");
		prop.load(fis);
		
	}
	
	
  @Test(priority=1)
	public void postRestApi_on_Google_search_Server() {
		
		String url1= RestAssured.baseURI=prop.getProperty("Host2");
		log.info("Access to URL" +url1);
		
		Response res1= given().
		queryParam("key",prop.getProperty("Key1")).
     	body (payLoads.getPostData04_1()).     	
     	
     	
		when().post(resources.placePostData4_1()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
        body("status",equalTo("OK")).extract().response();
		
		String responseString1=res1.asString();
		
		System.out.println(responseString1);
		
	//	JsonPath js1= new JsonPath(responseString1);


	
	    log.info("Verified Status code 200 successfully");
	    log.info("Verified Content typr is JSON");
	    log.info("Verified that following are the response details of post" +responseString1);
	    
	}

  @Test(priority=2)
		public void postRestApi_on_reqres_server() {
			
			String url2= RestAssured.baseURI=prop.getProperty("Host1");
			log.info("Access to URL" +url2);
			
			Response res2= given().body (payLoads.getPostData04_2()).
			when().post(resources.placePostData4_2()).
			then().assertThat().statusCode(201).and().contentType(ContentType.JSON).and().and().
			extract().response(); 
			String responseString2=res2.asString();
			

		    log.info("Verified Status code 201 successfully");
		    log.info("Verified Content typr is JSON");
		    log.info("Verified that following are the response details of post" +responseString2);
	    }
}
