package api.qa.picnic.authAPITest;
import api.qa.picnic.BaseTest;
import assertions.CoreAssertions;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testSteps.steps.GetAuthTokenSteps;

import static org.junit.jupiter.api.Assertions.assertAll;

public class AuthTest extends BaseTest {

    CoreAssertions assertions = new CoreAssertions();
    GetAuthTokenSteps getAuthTokenSteps = new GetAuthTokenSteps();


    @Test
    @DisplayName("Get auth token successfully")
    public void getAuthTokenTest() {

        Response getAuthToken = getAuthTokenSteps.getAuth();

        assertAll(
                () -> assertions.checkResponseBodyFieldNotNull(getAuthToken, "token"),
                () -> assertions. checkResponseStatus(getAuthToken, 200)
        );
    }
}
