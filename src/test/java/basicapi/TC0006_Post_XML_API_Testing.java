package basicapi;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

 
public class TC0006_Post_XML_API_Testing {
	private static Logger log =LogManager.getLogger(TC0006_Post_XML_API_Testing.class.getName());

  @Test(priority=1)
	public void postRestApi_on_Google_search_Server() throws IOException {
		
	 String postdata= GenerateStringFromResources("C:\\Users\\hsingh\\Documents\\postData.xml");
		String url1= RestAssured.baseURI="http://216.10.245.166";
		log.info("Access to URL" +url1);
		
		Response res1= given().
		queryParam("key","qaclick123").
     	body (postdata).     	
     	
     	
		when().post("/maps/api/place/add/xml").
		then().assertThat().statusCode(200).and().contentType(ContentType.XML)
		.and().extract().response(); 
    //    body("status",equalTo("OK")).extract().response();
		
		String responseString1=res1.asString();
		System.out.println(responseString1);
		
		XmlPath x= new XmlPath(responseString1);
		System.out.println(x.get("place_id"));
		System.out.println(x.get("Status"));



	
	    log.info("Verified Status code 200 successfully");
	    log.info("Verified Content typr is XML");
	    log.info("Verified that following are the response details of post: " +responseString1);
	    log.info("Verified that following are the Status: " +x.get("status"));
	    log.info("Verified that following are the Place ID: " +x.get("place_id"));
	}

  public static String GenerateStringFromResources(String path) throws IOException {
	  
	  
	  return new String(Files.readAllBytes(Paths.get(path)));
  }
  
       
    
}
