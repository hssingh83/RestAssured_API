package files;

public class vw_payLoads {
	
	
	public static String getClinet(String ClientName)
	{
		String b="{\"name\":\""+ClientName+"\",\"description\":\"null\",\"subscription_start_date\":1570536000,\"subscription_end_date\":1570615200,\"max_tests_allowed\":0,\"max_qa_tests\":0,\"max_load_tests\":0,\"max_vw_channels\":0,\"max_qa_channels\":0,\"max_load_channels\":0,\"min_test_schedule_period_in_minutes\":15,\"partner_id\":-1,\"partner_name\":\"\",\"Client\":\"\",\"partner_end_tied\":0,\"partner_schedule_tied\":0}";
		return b;
		
			
	}
	
	public static String tag(String tagname)
	{
		String pay="{\"name\": \""+tagname+"\"}";
		return pay;
		
			
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


	/*public static String getPostauthcred()
	{
		String b=({\"username\": "\myuser\", \"password\": \"mypassword\"});
		return b;	
			
	}*/
	
	
	
}
