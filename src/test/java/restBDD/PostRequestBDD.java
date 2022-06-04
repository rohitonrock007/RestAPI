package restBDD;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;

public class PostRequestBDD {
	
	@Test
	public void test1() {
		
		Map<String,Object>	MapObj = new HashMap<String,Object>();
		MapObj.put("name", "Tom");
		MapObj.put("salary", "80000");
	
			
			RestAssured.given()
			.baseUri("http://localhost:7000/employees")
			.contentType(ContentType.JSON)
			
			.accept(ContentType.JSON)
			.body(MapObj)
			.when()
			.post("/create")
			.then()
			.log()
			.body()
			.statusCode(201)
			.body("name", Matchers.equalTo("Tom"));
			
		    
			
	}
	
}
