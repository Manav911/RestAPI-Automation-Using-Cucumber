package com.testing.stepDefinations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.runner.RunWith;

import com.testing.model.AddPlace;
import com.testing.model.Location;
import com.testing.resources.ReUseUtils;
import com.testing.resources.TestDataBuild;

import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

@RunWith(Cucumber.class)
public class PlaceStep extends ReUseUtils {
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	Response response;
	TestDataBuild testDataBuild = new TestDataBuild();

	@Given("Add place API payload")
	public void add_place_api_payload() throws IOException {

		requestSpecification = given().spec(requestSpecBuilder()).body(testDataBuild.addPlacePayLoad());
	}

	@When("user calls {string} with Post http Request")
	public void user_calls_with_post_http_request(String string) {

		responseSpecification = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200)
				.build();
		
		response = requestSpecification.when().post("maps/api/place/add/json").then().spec(responseSpecification)
				.extract().response();

	}

	@Then("the API call is sucess with status code {int}")
	public void the_api_call_is_sucess_with_status_code(Integer int1) {

		assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
		String res = response.asString();
		JsonPath jsonPath = new JsonPath(res);
		assertEquals(jsonPath.get(key).toString(), value);
		System.out.println(res);
	}

}
