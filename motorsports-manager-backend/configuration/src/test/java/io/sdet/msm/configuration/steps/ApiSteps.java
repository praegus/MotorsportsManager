package io.sdet.msm.configuration.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.javacrumbs.jsonunit.core.Option;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;

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

    private RequestSpecification baseRequest() {
        return given().port(port);
    }
}
