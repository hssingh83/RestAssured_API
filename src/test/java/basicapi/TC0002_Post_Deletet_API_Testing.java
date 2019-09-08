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



@Test(priority=1)
public class TC0002_Post_Deletet_API_Testing {
	private static Logger log =LogManager.getLogger(TC0002_Post_Deletet_API_Testing.class.getName());


	public void post_delete_RestApi_on_Google_search_Server() {
		
		String url= RestAssured.baseURI="http://216.10.245.166";
		log.info("Access to URL" +url);
		
		Response res= given().
		queryParam("key","qaclick123").
		body ("{"+
			     "\"location\":{"+
			     "\"lat\" : -33.867591,"+
			     "\"lng\" : 151.201196"+
			    "},"+
			    "\"accuracy\":50,"+
			    "\"name\":\"Australian Cruise Group\","+
			    "\"phone_number\":\"(+91) 999 999 6038\","+
			    "\"address\" : \"RZP-264, Gali No:5, Rajnagar-2, Dwarka Sector 08\","+
			    "\"types\": [\"Residential Complex\",\"Home\"],"+
			    "\"website\" : \"http://google.com\","+
			    "\"language\" : \"Indian-IN\""+
				"}").		
     	
         when().post("/maps/api/place/add/json").
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
	  		queryParam("key","qaclick123").
	  		body("{"+
	  		"\"place_id\": \""+placeid+"\""+
	  		"}").when().post("/maps/api/place/delete/json").
	  		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
			body("status",equalTo("OK"));
	    
  
	    
	  		log.info("Verified Status code 200 after deleting place ID: " +placeid);
		    log.info("Verified Content type od deleteing is JSON after deleting");
		    log.info("Verified that Status is OK after deleting");
	}
  	
	public void post_delete_RestApi_on_reqres_server() {
		
		String url2= RestAssured.baseURI="https://reqres.in";
		log.info("Access to URL" +url2);
		
		Response res2=given().body ("{"+
				    "\"email\": \"eve.holt@reqres.in\","+
				    "\"password\": \"cityslicka\""+
				"}").
         when().post("/api/login/add/json").
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
