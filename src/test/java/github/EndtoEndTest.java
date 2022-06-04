package github;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndtoEndTest {
	
	@Test
	public void test1() {
		RestAssured.baseURI = "https://api.github.com/users/rohitonrock007/repos";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get();
	
		String ResponseBody = response.getBody().asString();
		
		System.out.println(ResponseBody);
	
		int ResponseCode = response.getStatusCode();
		
		Assert.assertEquals(ResponseCode, 200);
	
		System.out.println(ResponseCode);
		
JsonPath jpath = response.jsonPath();  //It is the perfect way to do
		
		List<String> names =jpath.get("name");
	
		System.out.println(names);
	}

	@Test
public void test2() throws IOException {
		
		RestAssured.baseURI = "https://api.github.com/user/repos";
		
		byte[] dataBytes =Files.readAllBytes(Paths.get("data.json"));//give full path of file
		
		
		RequestSpecification request = RestAssured.given();
		

		Response response = request.auth()
                					.oauth2("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")
                					.contentType(ContentType.JSON)
									.accept(ContentType.JSON)	
									.body(dataBytes)
									.post();

		
int ResponseCode = response.getStatusCode();
Assert.assertEquals(ResponseCode, 201);
System.out.println(ResponseCode);

String ResponseBody = response.getBody().asString();

System.out.println(ResponseBody);
		
	}


}

