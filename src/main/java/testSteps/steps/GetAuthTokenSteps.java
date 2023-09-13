package testSteps.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import testSteps.apiRequests.GetAuthRequest;

public class GetAuthTokenSteps {

    GetAuthRequest getAuthRequest = new GetAuthRequest();

    @Step("Step: get authToken")
    public Response getAuth() {
        Response response = getAuthRequest.sendGetAuthRequest();
        return response;
    }
}
