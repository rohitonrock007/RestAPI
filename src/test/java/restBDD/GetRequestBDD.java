package restBDD;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequestBDD {
	
	@Test
public void test1() {
		
		RestAssured.given()
		.baseUri("http://localhost:7000/employees")
	    .get()
	    //get("/1")   //getting 1st employee
	    .then()
	    .log()
	    .all()
		.statusCode(200);
		
//	.body();
	
}
	@Test
public void test2() {
		
		RestAssured.given()
		.baseUri("http://localhost:7000/employees")
	    .queryParam("id", "2")
		.get()
	  	.then()
	    .log()
	    .body()
		.statusCode(200)
		.body("[1].name", Matchers.equalTo("David"));   // started with 0
		
	}
	
	@Test
public void test3() {
		
	Response response = RestAssured.given()
		.baseUri("http://localhost:7000/employees")
	    .queryParam("id", "1")
		.get();
	  	
JsonPath jpath = response.jsonPath();  //It is the perfect way to do
		
		List<String> names =jpath.get("name");
	
		System.out.println(names.get(0));
		
		Assert.assertEquals(names.get(0), "Pankaj");
		
		String Header = response.getHeader("Content-Type");  //Print Header & for multiple use headers and list
		
		System.out.println(Header);
		
		//Response Body
//String ResponseBody = response.getBody().asString();
        
//        System.out.println("Response body : " + ResponseBody);
        
	}
	
}
