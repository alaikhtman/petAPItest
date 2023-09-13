package testSteps.apiRequests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static testSteps.spec.apiSpec.requestSpec;
import static testSteps.spec.apiSpec.responseSpec;

public class GetAuthRequest  {

    @Step("Send GET request to /auth")
    public Response sendGetAuthRequest() {
        Response response = given()
                .spec(requestSpec)
                .when()
                .get("/auth");

        response.then().spec(responseSpec);
        return response;

    }

}
