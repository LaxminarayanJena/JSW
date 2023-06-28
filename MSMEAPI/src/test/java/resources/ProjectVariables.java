package resources;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuild;

public class ProjectVariables {
    public static RequestSpecification res;
    public static  ResponseSpecification resspec;
    public static String orderNum ;
    public static String ctorderId ;
    public static String jwtToken ;
    public static Response response;
    public static String channelId;
    public static String ctLineItemId;
    public static  TestDataBuild data = new TestDataBuild();
}