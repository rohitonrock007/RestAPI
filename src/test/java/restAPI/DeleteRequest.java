package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {

	@Test
	public void test1() {

		RestAssured.baseURI = "http://localhost:7000/employees";
	
		RequestSpecification request = RestAssured.given();
		
		Response response = request.delete("/11");
	
		String ResponseBody = response.getBody().asString();
		
		System.out.println(ResponseBody);
	
		int ResponseCode = response.getStatusCode();
		
		Assert.assertEquals(ResponseCode, 200);
	
		System.out.println(ResponseCode);
		
JsonPath jpath = response.jsonPath();  //It is the perfect way to do
		
		List<String> names =jpath.get("name");
	
		System.out.println(names);
	}


		
	}
	

