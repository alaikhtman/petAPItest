package testSteps.steps;

import dataProvider.Product;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import testSteps.apiRequests.UpdateCartRequest;

import java.util.List;

public class UpdateCartSteps {

    UpdateCartRequest updateCartRequest = new UpdateCartRequest();

    @Step("Step: update cart with auth")
    public Response updateCartWithAuth(List<Product> products, String token) {
        Response response = updateCartRequest.sendPatchCartWithAuthRequest(products, token);
        return response;
    }

    @Step("Step: update cart")
    public Response updateCartWithoutAuth(List<Product> products) {
        Response response = updateCartRequest.sendPatchCartWithoutAuthRequest(products);
        return response;
    }

}

