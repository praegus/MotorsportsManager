package io.sdet.msm.configuration.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.javacrumbs.jsonunit.core.Option;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.hamcrest.Matchers.equalTo;

public class ApiSteps {
    @LocalServerPort
    protected int port;

    protected Response response;

    @When("I create {string} with:")
    public void post(String path, String body) {
        response = baseRequest().body(body).contentType(ContentType.JSON).when().post(path);
    }

    @Then("I retrieve {string}")
    public void get(String path) {
        response = baseRequest().when().get(path);
    }

    @Then("I should receive:")
    public void assertResponse(String expectedBody) {
        assertThatJson(response.getBody().prettyPrint()).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(expectedBody);
    }

    @Then("I should receive a response with status code {int}")
    public void iShouldReceiveAResponseWithStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("I should receive the http location header with path {string}")
    public void iShouldReceiveTheHttpLocationHeaderWithPath(String path) {
        response.then().header("location", String.format("http://localhost:%d%s", port, path));
    }

    private RequestSpecification baseRequest() {
        return given().port(port);
    }

    @Then("I should receive the error message {}")
    public void iShouldReceiveTheErrorMessage(String message) {
        response.then().body("detail", equalTo(message));
    }
}
