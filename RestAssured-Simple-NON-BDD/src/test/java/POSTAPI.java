	import io.restassured.RestAssured;
	import io.restassured.http.Method;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;
	
	public class POSTAPI {
	
		
		public void PostToAllProdList() {
			RestAssured.baseURI="https://automationexercise.com/";
			RequestSpecification rs=RestAssured.given();
			rs.contentType("Application/json");
			rs.body("{\n" +
	                "  \"products\": [\n" +
	                "    {\n" +
	                "      \"id\": 241,\n" +
	                "      \"name\": \"Blue Top\",\n" +
	                "      \"price\": \"Rs. 500\",\n" +
	                "      \"brand\": \"Polo\",\n" +
	                "      \"category\": {\n" +
	                "        \"usertype\": {\n" +
	                "          \"usertype\": \"Women\"\n" +
	                "        },\n" +
	                "        \"category\": \"Tops\"\n" +
	                "      }\n" +
	                "    }\n" +
	                "  ]\n" +
	                "}");
			Response response=rs.request(Method.POST, "api/productsList");
			
			System.out.println(response.prettyPrint()) ;
			
			
			
			
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			POSTAPI psapi=new POSTAPI();
			psapi.PostToAllProdList();
	
		}
	
	}
