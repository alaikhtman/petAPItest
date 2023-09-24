package api.qa.picnic.getAccountsCreditCardAPITest;

import api.qa.picnic.BaseTest;
import assertions.AccountsAssertion;
import assertions.CoreAssertions;
import dataProvider.responses.AccountsCreditCardInfo;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import testSteps.steps.GetAccountsCreditCardSteps;

import static org.junit.jupiter.api.Assertions.assertAll;

public class GetAccountCreditCardTest extends BaseTest {

    AccountsAssertion assertions = new AccountsAssertion();
    GetAccountsCreditCardSteps getAccountsCreditCardSteps = new GetAccountsCreditCardSteps();

    @Test
    @DisplayName("Get accounts' credit cards with correct id")
    @Tag("High")
    public void getAccountsCreditCardWithCorrectIdTest() {
        Response response = getAccountsCreditCardSteps.getAccountsCreditCard("200007");
        AccountsCreditCardInfo accountsCreditCardInfo = response.as(AccountsCreditCardInfo.class);

        assertAll(
                () -> assertions.checkResponseStatus(response, 200),
                () -> assertions.checkPositiveAccountsCreditCardInfoResponse(accountsCreditCardInfo)

        );


    }

    @Test
    @DisplayName("Get accounts' credit cards with invalid id")
    @Tag("High")
    public void getAccountsCreditCardWithInvalidIdTest() {
        Response response = getAccountsCreditCardSteps.getAccountsCreditCard("abcd");
        assertions.checkResponseStatus(response, 404)
                .checkResponseBodyFieldValue(response, "message", "HTTP 404 Not Found");

    }

    @Test
    @DisplayName("Get accounts' credit cards with non-existed id")
    @Tag("High")
    public void getAccountsCreditCardWithNonExistedIdTest() {
        Response response = getAccountsCreditCardSteps.getAccountsCreditCard("5456");
        assertions.checkResponseStatus(response, 204);

    }

}
