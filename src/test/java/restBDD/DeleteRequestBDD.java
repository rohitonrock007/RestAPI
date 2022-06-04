package restBDD;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteRequestBDD {

	

	@Test
	public void test1() {
		
			RestAssured.given()
			.baseUri("http://localhost:7000/employees")
			.contentType(ContentType.JSON)
			
			.accept(ContentType.JSON)
						.when()
			.delete("/25")
			.then()
			.log()
			.body()
			.statusCode(200)
			
			.body("name", Matchers.equalTo(null));
			
		    
			
	}
}
