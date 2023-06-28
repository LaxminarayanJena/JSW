package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import resources.APIResources;
import resources.ProjectVariables;
import resources.Utils;

public class PlantSupplyOrder extends Utils {

	@Then("extract the jwtToken")
	public void extract_the_jwt_token() {
		ProjectVariables.jwtToken = Utils.getexpectedValue("jwtToken");
		System.out.println(ProjectVariables.jwtToken);

	}

	@Then("user calls {string} with {string} http request for {string} with header")
	public void user_calls_with_http_request_for_with_header(String resource, String method, String payloadBody)
			throws IOException {
		if (method.equalsIgnoreCase("Post")) {
			ProjectVariables.res = given().spec(requestSpecification())
					.header("access_token", ProjectVariables.jwtToken).contentType(ContentType.JSON)
					.body(Utils.getJsonData(payloadBody));
			APIResources resourceAPI = APIResources.valueOf(resource);
			ProjectVariables.response = ProjectVariables.res.when().post(resourceAPI.getResource());

		} else if (method.equalsIgnoreCase("Get")) {

			ProjectVariables.res = given().spec(requestSpecification()).header("access_token",
					ProjectVariables.jwtToken);
			APIResources resourceAPI = APIResources.valueOf(resource);
			ProjectVariables.response = ProjectVariables.res.when().get(resourceAPI.getResource());

		}
		System.out.println(ProjectVariables.response.asPrettyString());
	}

	@Then("extract the channelId")
	public void extract_the_channel_id() {
		ProjectVariables.channelId = Utils.getexpectedValue("channelId");
		System.out.println(ProjectVariables.channelId);
	}

}
