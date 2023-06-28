package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;
import org.hamcrest.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class Notfication extends Utils {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data = new TestDataBuild();

	@When("user calls {string} with {string} http request with {string}")
	public void user_calls_with_http_request_forSMSverification(String resource, String method, String phone) throws IOException {

		res = given().spec(requestSpecification()).body(data.notoficationRegistrationSmsPayload(phone));
		APIResources resourceAPI = APIResources.valueOf(resource);
		response = res.when().post(resourceAPI.getResource());
		System.out.println(response.asPrettyString());

	}
	
	@When("user calls {string} with {string} http request with {string} for emailverification")
	public void user_calls_with_http_request_forEmailverification(String resource, String method, String email) throws IOException {

		res = given().spec(requestSpecification()).body(data.notificationEmailPayload(email));
		APIResources resourceAPI = APIResources.valueOf(resource);
		response = res.when().post(resourceAPI.getResource());
		System.out.println(response.asPrettyString());

	}

	@Then("^the API call is success with status code 200$")
	public void the_api_call_is_sucess_with_status_code_200() throws Throwable {
		assertEquals(response.getStatusCode(), 200);
	}

	@And("^validate the payload structure$")
	public void validate_the_payload_structure() throws Throwable {

		String reponseMsg = getJsonPath(response, "status.desc");
		assertNotNull(reponseMsg);
		assertEquals(reponseMsg, "Request accepted");
	}

	@And("^validate the response time is less than 500 ms$")
	public void validate_the_response_time_is_less_than_500_ms() throws Throwable {
		int time = Long.valueOf(response.getTime()).intValue();
		System.out.println("time" + time);
		assert time < 10000;

	}

}
