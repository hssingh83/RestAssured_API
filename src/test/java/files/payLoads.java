package files;

public class payLoads {
	
	
	public static String getPostData04_1()
	{
		String b="{"+
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
		"}";
		return b;
		
			
	}

	public static String getPostData04_2()
	{
		String b="{"+
		
				    "\"name\": \"morpheus\","+
				    "\"job\": \"leader\""+
				"}";
		return b;
		
			
	}
	
	public static String getPostData05_1()
	{
		String b="{"+
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
				"}";
		return b;	
			
	}
	public static String getPostData05_2()
	{
		String b=("{"+
			    "\"email\": \"eve.holt@reqres.in\","+
			    "\"password\": \"cityslicka\""+
			"}");
		return b;	
			
	}
}
