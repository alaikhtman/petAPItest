package testSteps.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import testSteps.apiRequests.GetCartRequest;

public class GetCartSteps {

    GetCartRequest getCartRequest = new GetCartRequest();

    @Step("Step: get cart with authentication")
    public Response getCart (String token) {
        Response response = getCartRequest.sendAuthGetCartRequest(token);
        return response;
    }
}
