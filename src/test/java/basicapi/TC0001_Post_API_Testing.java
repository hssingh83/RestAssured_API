package basicapi;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

 
public class TC0001_Post_API_Testing {
	private static Logger log =LogManager.getLogger(TC0001_Post_API_Testing.class.getName());

  @Test(priority=1)
	public void postRestApi_on_Google_search_Server() {
		
		String url1= RestAssured.baseURI="http://216.10.245.166";
		log.info("Access to URL" +url1);
		
		Response res1= given().
		queryParam("key","qaclick123").
     	body ("{"+
			    "\"location\":{"+
			        "\"lat\" : -38.383494,"+
			        "\"lng\" : 33.427362"+
			    "},"+
			    "\"accuracy\":50,"+
			    "\"name\":\"Frontline house\","+
			    "\"phone_number\":\"(+91) 983 893 3937\","+
			    "\"address\" : \"29, side layout, cohen 09\","+
			    "\"types\": [\"shoe_park\",\"shop\"],"+
			    "\"website\" : \"http://google.com/\","+
			    "\"language\" : \"French-IN\""+
			"}").     	
     	
     	
		when().post("/maps/api/place/add/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
        body("status",equalTo("OK")).extract().response();
		
		String responseString1=res1.asString();
//		System.out.println(responseString);
		
		JsonPath js1= new JsonPath(responseString1);
//		String placeid=js.get("place_id");
//		System.out.println(placeid);

	
	    log.info("Verified Status code 200 successfully");
	    log.info("Verified Content typr is JSON");
	    log.info("Verified that following are the response details of post" +responseString1);
	    
	}

  @Test(priority=2)
		public void postRestApi_on_reqres_server() {
			
			String url2= RestAssured.baseURI="https://reqres.in/";
			log.info("Access to URL" +url2);
			
			Response res2= given().body ("{"+
		//	given().body ("{"+
				    "\"name\": \"morpheus\","+
				    "\"job\": \"leader\""+
				"}").
			when().post("/api/users").
			then().assertThat().statusCode(201).and().contentType(ContentType.JSON).and().and().
		//	body("status",equalTo("Created")).extract().response();
			extract().response(); 
			String responseString2=res2.asString();
		//	JsonPath js2= new JsonPath(responseString2);
			

		    log.info("Verified Status code 201 successfully");
		    log.info("Verified Content typr is JSON");
		    log.info("Verified that following are the response details of post" +responseString2);
	    }
}
