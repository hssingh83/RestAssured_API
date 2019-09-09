package basicapi;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;




@Test
public class TC0000_Get_API_Testing {
	private static Logger log =LogManager.getLogger(TC0000_Get_API_Testing.class.getName());


	public void getRestApi() {
		
		String url= RestAssured.baseURI="https://reqres.in";
		log.info("Access to URL: " +url);
		
   given().
		
     	param("page","2").
		when().get("/api/users").then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		 body("data[0].first_name",equalTo("Michael")).and().
		 body("data[4].email",equalTo("george.edwards@reqres.in")).and().
		 header("Server", "cloudflare");
		 
	
	    log.info("Verified Status code 200 successfully");
	    log.info("Verified Content typr is JSON");
	    log.debug("Verified body contain Name as 'Michael'");
	    log.debug("Verified body contain Email as 'george.edwards@reqres.in'");
	    log.debug("Verified Header as Server equels to 'cloudflare'");
	}
  	
	

}
