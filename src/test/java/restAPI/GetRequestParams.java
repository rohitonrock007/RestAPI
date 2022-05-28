package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestParams {

	@Test
public void test1(){
		
		RestAssured.baseURI = "http://localhost:7000/employees";
	
		RequestSpecification request = RestAssured.given();
		
		Response response = request.param("id", "1").get();
	
		String ResponseBody = response.getBody().asString();
		
		System.out.println(ResponseBody);
	
		int ResponseCode = response.getStatusCode();
		
		Assert.assertEquals(ResponseCode, 200);
	
		System.out.println(ResponseCode);
	
		Assert.assertTrue(ResponseBody.contains("Pankaj"));  //it is not a perfect way to do
		
		JsonPath jpath = response.jsonPath();  //It is the perfect way to do
		
		List<String> names =jpath.get("name");
	
		System.out.println(names.get(0));
		
		Assert.assertEquals(names.get(0), "Pankaj");
		
		String Header = response.getHeader("Content-Type");  //Print Header & for multiple use headers and list
		
		System.out.println(Header);
		
}
}
