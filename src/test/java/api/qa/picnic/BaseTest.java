package api.qa.picnic;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.junit.jupiter.api.BeforeAll;
import testSteps.steps.GetAuthTokenSteps;
import static testSteps.apiRequests.Configuration.URI;

public class BaseTest {

    GetAuthTokenSteps getAuthTokenSteps = new GetAuthTokenSteps();

    public String token;

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = URI;
    }

    @Step("Precondition: get authToken")
    public String getAuthToken() {
        Response authTokenResponse = getAuthTokenSteps.getAuth();
        token = authTokenResponse.jsonPath().getString("token");
        return token;
    }
}
