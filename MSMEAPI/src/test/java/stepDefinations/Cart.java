package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import resources.APIResources;
import resources.ProjectVariables;
import resources.Utils;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class Cart extends Utils {

	@Given("user calls {string} with {string} http request for {string}")
	public void user_calls_something_with_something_http_request_for_something(String resource, String method,
			String payloadBody) throws Throwable {

		if (method.equalsIgnoreCase("Post")) {
			ProjectVariables.res = given().spec(requestSpecification())
					.header("access_token", Utils.getGlobalValue("token")).contentType(ContentType.JSON)
					.body(Utils.getJsonData(payloadBody));
			APIResources resourceAPI = APIResources.valueOf(resource);
			ProjectVariables.response = ProjectVariables.res.when().post(resourceAPI.getResource());

		} else if (method.equalsIgnoreCase("Get")) {

			ProjectVariables.res = given().spec(requestSpecification()).header("access_token",
					Utils.getGlobalValue("token"));
			APIResources resourceAPI = APIResources.valueOf(resource);
			ProjectVariables.response = ProjectVariables.res.when().get(resourceAPI.getResource());

		}
		System.out.println(ProjectVariables.response.asPrettyString());
	}

	@Then("^validate that the \"([^\"]*)\"  call response is success with status code \"([^\"]*)\"$")
	public void validate_that_the_something_call_response_is_success_with_status_code_something(String strArg1,
			String responseCode) throws Throwable {
		assertEquals(ProjectVariables.response.getStatusCode(), Integer.parseInt(responseCode));
	}

	@And("^validate the \"([^\"]*)\" response time is less than \"([^\"]*)\" ms$")
	public void validate_the_something_response_time_is_less_than_something_ms(String strArg1, String expectedTime)
			throws Throwable {
		int time = Long.valueOf(ProjectVariables.response.getTime()).intValue();
		System.out.println("time" + time);
		assert time < Integer.decode(expectedTime);
	}

	@And("^validate the \"([^\"]*)\" payload structure has \"([^\"]*)\"$")
	public void validate_the_something_payload_structure_has_something(String strArg1, String validationKeyword)
			throws Throwable {
		assertThat(ProjectVariables.response.asPrettyString(), containsString(validationKeyword));
	}

	@Then("wait for sometime")
	public void wait_for_sometime() throws InterruptedException {
		Thread.sleep(8000);
	}

	@Then("extract the ctLineItemId")
	public void extract_the_ctLineItemId() {
		ProjectVariables.ctLineItemId = Utils
				.getexpectedValue("orderCartSummary.lineItemList[0].lineItemIdentifier.ctLineItemId");
		System.out.println(ProjectVariables.ctLineItemId);
	}

	@Given("user calls {string} with {string} http request with queryParam for {string}")
	public void user_calls_with_http_request_with_path_param_for(String resource, String method, String queryParamValue)
			throws IOException {
		if (method.equalsIgnoreCase("Post")) {

			ProjectVariables.res = given().spec(requestSpecification())
					.header("access_token", Utils.getGlobalValue("token")).contentType(ContentType.JSON)
					.queryParam(queryParamValue, ProjectVariables.ctLineItemId);
			;
			APIResources resourceAPI = APIResources.valueOf(resource);
			ProjectVariables.response = ProjectVariables.res.when().post(resourceAPI.getResource());

		}
		System.out.println(ProjectVariables.response.asPrettyString());
	}

}
