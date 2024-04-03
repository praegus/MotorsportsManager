package io.sdet.motorsportsmanager.steps;

import io.cucumber.java.en.Then;
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

    @Then("I retrieve {string}")
    public void assertCallResponse(String path) {
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
