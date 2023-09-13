package assertions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class CoreAssertions {

    public SoftAssertions softAssertions = new SoftAssertions();


    @Step("Result: check response status ")
    public CoreAssertions checkResponseStatus(Response response, int statusCode) {
        assertEquals(statusCode, response.statusCode());
        return this;

    }


    @Step("Result: check response body field value")
    public CoreAssertions checkResponseBodyFieldValue(Response response, String field, String expectedValue) {
        assertEquals(expectedValue, response.jsonPath().getString(field));
        return this;

    }


    @Step("Result: check response body field not null")
    public CoreAssertions checkResponseBodyFieldNotNull(Response response, String fieldName) {
        assertNotNull(response.jsonPath().getString(fieldName));
        return this;
    }

}


