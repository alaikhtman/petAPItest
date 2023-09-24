package testSteps.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import testSteps.apiRequests.GetAccountsCreditCardRequest;

public class GetAccountsCreditCardSteps {

    GetAccountsCreditCardRequest getAccountsCreditCardRequest = new GetAccountsCreditCardRequest();

    @Step("Step: get account's credit card")
    public Response getAccountsCreditCard (String token) {
        Response response = getAccountsCreditCardRequest.sendGetAccountsCreditCardRequest(token);
        return response;
    }
}
