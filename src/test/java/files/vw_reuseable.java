package files;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.restassured.RestAssured;

import io.restassured.path.xml.XmlPath;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import voicewatchAPI.T0001_voicewatch_Get_API;

public class vw_reuseable {
	
private static Logger log =LogManager.getLogger(T0001_voicewatch_Get_API.class.getName());

	
	
//Generate Authonticate 

	
	public static String getTokenID() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\hsingh\\Frameworks\\RestAssured_API\\src\\test\\java\\files\\data.properties");
		prop.load(fis);
		RestAssured.baseURI=prop.getProperty("openam");
		
//	RestAssured.baseURI="https://os-2k16-vm333.empirix.com";
	
	log.info("Host infomation of aauthentication OpenAM server: " +prop.getProperty("openam"));
	
		
  
                Response res=given().relaxedHTTPSValidation().header("Content-Type","application/json").header("X-OpenAM-Username","admin").header("X-OpenAM-Password","password").
               // 		header(prop.getProperty("X-OpenAM-Username")).header(prop.getProperty("X-OpenAM-Password")).
		        when().post("/openam/json/authenticate").
		        then().assertThat().statusCode(200).extract().response();
   
                                          String ResposeString=res.asString();
                                          log.info("Auth-Respose: "+ ResposeString);
   
                           JsonPath js=vw_reuseable.rawToJson(res);
                          String iPlanetDirectoryPro= js.get("tokenId");
                          
               return iPlanetDirectoryPro;            
 
  
 // System.out.println(iPlanetDirectoryPro);
		
		
	}
	
	
//Authonticate using hashmap
	
    
	public static String Hash_getTokenID() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\hsingh\\Frameworks\\RestAssured_API\\src\\test\\java\\files\\data.properties");
		prop.load(fis);
		RestAssured.baseURI=prop.getProperty("openam");
		
//	RestAssured.baseURI="https://os-2k16-vm333.empirix.com";
	
	log.info("Host infomation of aauthentication OpenAM server: " +prop.getProperty("openam"));
	
		HashMap <String, String> authentication= new HashMap<String, String>();		
		authentication.put("X-OpenAM-Username", "admin");
		authentication.put("X-OpenAM-Password", "password");
		
		
		
  
                Response res=given().relaxedHTTPSValidation().header("Content-Type","application/json").body(authentication).
                		
                		
                		
                	//	header("X-OpenAM-Username","admin").header("X-OpenAM-Password","password").
               // 		header(prop.getProperty("X-OpenAM-Username")).header(prop.getProperty("X-OpenAM-Password")).
		        when().post("/openam/json/authenticate").
		        then().assertThat().statusCode(200).extract().response();
   
                                          String ResposeString=res.asString();
                                          log.info("Auth-Respose: "+ ResposeString);
   
                           JsonPath js=vw_reuseable.rawToJson(res);
                          String iPlanetDirectoryPro= js.get("tokenId");
                          
               return iPlanetDirectoryPro;            
 
  
 // System.out.println(iPlanetDirectoryPro);
		
		
	}
	
	
	

	public static XmlPath rawToXML(Response r)
	{
	
		
		String respon=r.asString();
		XmlPath x=new XmlPath(respon);
		return x;
		
	}
	
	public static JsonPath rawToJson(Response r)
	{ 
		String respon=r.asString();
		JsonPath x=new JsonPath(respon);
	//	JsonPath x=new JsonPath(respon);
		return x;
	}
	
	// Generate Random String

	public static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
	//Generate Random Number
	
	public static int getNumber() {
		
			  
			    { 
		        // create instance of Random class 
		        Random rand = new Random(); 
		  
		        // Generate random integers in range 0 to 999 
		        int rand_int1 = rand.nextInt(1000); 
		        int rand_int2 = rand.nextInt(1000); 
		  
		        // Print random integers 
		        System.out.println("Random Integers: "+rand_int1); 
		        System.out.println("Random Integers: "+rand_int2); 
		  
		        // Generate Random doubles 
		        double rand_dub1 = rand.nextDouble(); 
		        double rand_dub2 = rand.nextDouble(); 
		  
		        // Print random doubles 
		        System.out.println("Random Doubles: "+rand_dub1); 
		        System.out.println("Random Doubles: "+rand_dub2); 
		        
		        return  rand_int1;
		    } 
		 
			  
			    
	
		
		
	}
	
}
