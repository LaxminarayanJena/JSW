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

public class Payment extends Utils {

	@Then("extract the ctorderId")
	public void extract_the_ctorderId() {

		ProjectVariables.ctorderId = Utils.getexpectedValue("identifier.id");
		System.out.println(ProjectVariables.ctorderId);
	}
	
	@Given("user calls {string} with {string} http request with pathParam for {string}")
	public void user_calls_with_http_request_with_path_param_for(String resource, String method, String pathParamValue) throws IOException
	{
		if (method.equalsIgnoreCase("Post")) {
			
			ProjectVariables.res = given().spec(requestSpecification())
					.header("access_token", Utils.getGlobalValue("token")).pathParam("id", ProjectVariables.ctorderId);
			APIResources resourceAPI = APIResources.valueOf(resource);
			ProjectVariables.response = ProjectVariables.res.when().post(resourceAPI.getResource() + "/{id}");


		} else if (method.equalsIgnoreCase("Get")) {

			ProjectVariables.res = given().spec(requestSpecification())
					.header("access_token", Utils.getGlobalValue("token")).pathParam("id", ProjectVariables.ctorderId);
			APIResources resourceAPI = APIResources.valueOf(resource);
			ProjectVariables.response = ProjectVariables.res.when().get(resourceAPI.getResource() + "/{id}");

		}
		System.out.println(ProjectVariables.response.asPrettyString());
	}

	
	

}
