package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.ProjectVariables;
import resources.TestDataBuild;
import resources.Utils;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class OrderSummary extends Utils {

	@Then("extract the orderno")
	public void extract_the_orderno() {
		String ordernourl = Utils.getexpectedValue("payments[0].paymentLink");
		ProjectVariables.orderNum = ordernourl.substring(ordernourl.indexOf("=") + 1);
		System.out.println(ProjectVariables.orderNum);
	}


	@Given("user calls {string} with {string} http request with pathParam {string}")
	public void user_calls_with_http_request_with_path_param(String resource, String method, String pathParamValue)
			throws IOException {

		if (method.equalsIgnoreCase("Post")) {

		} else if (method.equalsIgnoreCase("Get")) {

			ProjectVariables.res = given().spec(requestSpecification())
					.header("access_token", Utils.getGlobalValue("token")).pathParam("id", ProjectVariables.orderNum);
			APIResources resourceAPI = APIResources.valueOf(resource);
			ProjectVariables.response = ProjectVariables.res.when().get(resourceAPI.getResource() + "/{id}");

		}
		System.out.println(ProjectVariables.response.asPrettyString());
	}
	
	

}
