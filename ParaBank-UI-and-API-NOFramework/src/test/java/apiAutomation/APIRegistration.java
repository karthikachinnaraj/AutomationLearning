package apiAutomation;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIRegistration {
	
	public void RegisterSuccessAPI() {
		RestAssured
		.baseURI="https://parabank.parasoft.com/parabank/";
		Response response =given()
				.contentType("Application/json")
				 .body("\"{\"\r\n"
				 		+ "            + \"  \\\"firstName\\\": \\\"John\\\",\"\r\n"
				 		+ "            + \"  \\\"lastName\\\": \\\"Doe\\\",\"\r\n"
				 		+ "            + \"  \\\"address\\\": {\"\r\n"
				 		+ "            + \"    \\\"street\\\": \\\"123 Test St\\\",\"\r\n"
				 		+ "            + \"    \\\"city\\\": \\\"Test City\\\",\"\r\n"
				 		+ "            + \"    \\\"state\\\": \\\"CA\\\",\"\r\n"
				 		+ "            + \"    \\\"zipCode\\\": \\\"90210\\\"\"\r\n"
				 		+ "            + \"  },\"\r\n"
				 		+ "            + \"  \\\"phoneNumber\\\": \\\"555-123-4567\\\",\"\r\n"
				 		+ "            + \"  \\\"ssn\\\": \\\"123-45-6789\\\",\"\r\n"
				 		+ "            + \"  \\\"username\\\": \\\"johndoe123\\\",\"\r\n"
				 		+ "            + \"  \\\"password\\\": \\\"password123\\\"\"\r\n"
				 		+ "            + \"  \\\"repeatedPassword\\\": \\\"password123\\\"\"\r\n"
				 		+ "            + \"}\"")
				 .when()
				 .post("customers");
				 
				 System.out.println(response.getStatusCode());
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		APIRegistration successapi= new APIRegistration();
		successapi.RegisterSuccessAPI();
		
	}

}
