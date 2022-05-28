package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {

	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:7000/employees";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.contentType(ContentType.JSON)
		
		.accept(ContentType.JSON)
		.body("{\r\n"
				+ "        \"name\": \"Robina\",\r\n"
				+ "        \"salary\": \"5000\"\r\n"
				+ "}")
		
		.post("/create");
		
int ResponseCode = response.getStatusCode();
		
		Assert.assertEquals(ResponseCode, 201);
		System.out.println(ResponseCode);
		
		String ResponseBody = response.getBody().asString();
		
		System.out.println(ResponseBody);
	
JsonPath jpath = response.jsonPath();  //It is the perfect way to do
		
		jpath.get("id");
		
		// List<String> names=jpath.get("id");   print all id
	
		System.out.println("id"+jpath.get("id"));

		
	}
	
}
