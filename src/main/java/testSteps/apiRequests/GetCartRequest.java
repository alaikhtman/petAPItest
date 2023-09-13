package testSteps.apiRequests;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static testSteps.spec.apiSpec.requestSpec;
import static testSteps.spec.apiSpec.responseSpec;


public class GetCartRequest {

    @Step("Send GET request with auth to /cart")
    public Response sendAuthGetCartRequest(String token) {
        Response response = given()
                .spec(requestSpec)
                .header("x-auth", token)
                .and()
                .when()
                .get("/cart");
        response.then().spec(responseSpec);
        return response;

    }

}
