import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETAPI {
	
	public void GetAllProdsList() {
		RestAssured
		.baseURI="https://automationexercise.com/"	;
		RequestSpecification rs= RestAssured.given()
		.contentType("Application-json");
		Response response=rs.request(Method.GET, "api/productsList");
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());

	}
	public void GetAllBrands() {
		
		RestAssured.baseURI="https://automationexercise.com/";
		RequestSpecification rs =RestAssured.given()
				.contentType("Application/json");
		Response response=rs.request(Method.GET,"api/brandsList");
		
		if(response.getStatusCode()==200) {
			System.out.println("Valid staus code:200 ");
			System.out.println(response.jsonPath().prettify());
		}
		else {
			System.out.println("Invalid error"+response.getStatusCode());
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GETAPI api=new GETAPI();
		//api.GetAllProdsList();
		api.GetAllBrands();

	}

}
