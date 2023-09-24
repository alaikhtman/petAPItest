package testSteps.apiRequests;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static testSteps.spec.apiSpec.requestSpec;
import static testSteps.spec.apiSpec.responseSpec;


public class GetAccountsCreditCardRequest {

    @Step("Send GET credit card request to /accounts")
    public Response sendGetAccountsCreditCardRequest(String id) {
        Response response = given()
                .spec(requestSpec)
                .and()
                .when()
                .get("/r/frs/productInfo/kreditkarte/" + id);
        response.then().spec(responseSpec);
        return response;

    }

}
