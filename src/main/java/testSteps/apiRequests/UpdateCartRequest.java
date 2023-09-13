package testSteps.apiRequests;

import dataProvider.Product;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import java.util.List;
import static io.restassured.RestAssured.given;
import static testSteps.spec.apiSpec.requestSpec;
import static testSteps.spec.apiSpec.responseSpec;


public class UpdateCartRequest {

    @Step("Send Patch request to /cart with auth")
    public Response sendPatchCartWithAuthRequest(List<Product> products, String token) {
        Response response = given()
                .spec(requestSpec)
                .header("x-auth", token)
                .and()
                .body(products)
                .when()


                .patch("/cart/");
        response.then().spec(responseSpec);
       return response;
    }

    @Step("Send Patch request to /cart w/t auth")
    public Response sendPatchCartWithoutAuthRequest(List<Product> products) {
        Response response = given()
                .spec(requestSpec)
                .and()
                .body(products)
                .when()
                .patch("/cart/");
        response.then().spec(responseSpec);
        return response;
    }



}