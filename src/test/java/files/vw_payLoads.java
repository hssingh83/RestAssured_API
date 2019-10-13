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
	
	public static String Partner(String PartnerName)
	{
		String pay="{{\\r\\n    \\r\\n    \\\"name\\\": \\\""+PartnerName+"\\\",\\r\\n    \\\"description\\\": null,\\r\\n    \\\"subscription_start_date\\\": 1553169600,\\r\\n    \\\"subscription_end_date\\\": 1553248800,\\r\\n    \\\"max_tests_allowed\\\": 1,\\r\\n    \\\"max_qa_tests\\\": 1,\\r\\n    \\\"max_load_tests\\\": 1,\\r\\n    \\\"max_vw_channels\\\": 0,\\r\\n    \\\"max_qa_channels\\\": 10,\\r\\n    \\\"max_load_channels\\\": 50,\\r\\n    \\\"min_test_schedule_period_in_minutes\\\": 15,\\r\\n    \\\"client_apps\\\": [\\r\\n        \\\"VoiceWatch\\\",\\r\\n        \\\"ART\\\",\\r\\n        \\\"HammerOnCall\\\"\\r\\n    ],\\r\\n    \\\"allow_go_script\\\": true,\\r\\n    \\\"allow_upload_script\\\": true,\\r\\n    \\\"allow_testcase_import\\\": false,\\r\\n    \\\"allow_non_toll_free\\\": false,\\r\\n    \\\"allow_qa_non_toll_free\\\": false,\\r\\n    \\\"allow_load_non_toll_free\\\": false,\\r\\n    \\\"max_non_toll_free\\\": 0,\\r\\n    \\\"max_qa_non_toll_free\\\": 0,\\r\\n    \\\"max_load_non_toll_free\\\": 0,\\r\\n    \\\"allow_csv_transformer\\\": false,\\r\\n    \\\"default_hammer_group_id\\\": 1,\\r\\n    \\\"hammer_labels\\\": {}\\r\\n}}";
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
