package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.File;
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

public class Customer extends Utils {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data = new TestDataBuild();

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) throws IOException {
		res = given().spec(requestSpecification()).header("access_token", Utils.getGlobalValue("token"))
				.contentType(ContentType.JSON).body(Utils.getJsonData("login"));
		APIResources resourceAPI = APIResources.valueOf(resource);
		response = res.when().post(resourceAPI.getResource());
		System.out.println(response.asPrettyString());
	}

	@Given("user calls {string} with {string} http request for registration")
	public void user_calls_with_http_request_for_registration(String resource, String method) throws IOException {

		res = given().spec(requestSpecification()).contentType(ContentType.JSON)
				.body(Utils.getJsonData("registration"));
		APIResources resourceAPI = APIResources.valueOf(resource);
		response = res.when().post(resourceAPI.getResource());
		System.out.println(response.asPrettyString());
	}

	@Then("the API call response is success with status code {int}")
	public void the_api_call_response_is_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("validate the login response time is less than {string} ms")
	public void validate_the_login_response_time_is_less_than_ms(String expectedTime) {

		int time = Long.valueOf(response.getTime()).intValue();
		System.out.println("time" + time);
		assert time < Integer.decode(expectedTime);
	}

	@And("^validate the payload structure has \"([^\"]*)\"$")
	public void validate_the_payload_structure_has_something(String validationKeyword) throws Throwable {

		String reponseMsg = getJsonPath(response, "token_type");
		assertNotNull(reponseMsg);
		assertEquals(reponseMsg, validationKeyword);
	}

}
