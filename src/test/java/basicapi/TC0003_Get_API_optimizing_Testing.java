package basicapi;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;





public class TC0003_Get_API_optimizing_Testing {
	private static Logger log =LogManager.getLogger(TC0003_Get_API_optimizing_Testing.class.getName());

	
	Properties prop=new Properties();
	@BeforeTest
	public void getData() throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\hsingh\\Frameworks\\RestAssured_API\\src\\test\\java\\files\\data.properties");
		prop.load(fis);
		
	}
	
	@Test
	public void getRestApi() {
		
		String url=RestAssured.baseURI=prop.getProperty("Host1");
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
