package restAPI;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestwithMap {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:7000/employees";
		
		Map<String,Object>	MapObj = new HashMap<String,Object>();
		MapObj.put("name", "Apoorva");
		MapObj.put("salary", "20000");
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.contentType(ContentType.JSON)
		
		.accept(ContentType.JSON)
		.body(MapObj)
		
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



