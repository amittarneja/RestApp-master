import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class restBasicAuthenticationTest {
	@Test
	public void restBasicAuthenticationValidUserTest() {

		RestAssured.baseURI = "http://localhost:8006";

		Response response = null;

		String username = "amit";
		String password = "tarneja";

		// Scenario with valid user name & password
		response = given().auth().basic(username, password).when().get("/login");

		System.out.println("Access Granted \nStatus Code :" + response.getStatusCode());
		System.out.println("Response :" + response.asString());
	}

	@Test
	public void restBasicAuthenticationinvalidUserTest() {

		RestAssured.baseURI = "http://localhost:8006";

		Response response = null;

		String username = "amit";
		String password = "incorrectpassword";

		// Scenario with failed login due to incorrect password
		response = given().auth().basic(username, password).when().get("/login");

		System.out.println("Access Not granted \nStatus Code :" + response.getStatusCode());
		System.out.println("Response :" + response.asString());

	}
}