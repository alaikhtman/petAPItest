package assertions;

import dataProvider.responses.AccountsCreditCardInfo;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountsAssertion  extends  CoreAssertions{


    @Step("Result: check accounts' credit card info response body ")
    public AccountsAssertion checkPositiveAccountsCreditCardInfoResponse(AccountsCreditCardInfo accountsCreditCardInfo) {
        assertAll(
                () -> assertEquals(accountsCreditCardInfo.getProductId(), 0),
                () -> assertEquals("Allgemein", accountsCreditCardInfo.getTabs().getGeneral().getTabName()),
                () -> assertEquals("Bezahlung", accountsCreditCardInfo.getTabs().getPayment().getTabName()),
                () -> assertEquals("Bargeld", accountsCreditCardInfo.getTabs().getCashWithdrawl().getTabName()),
                () -> assertEquals("Gebühren", accountsCreditCardInfo.getTabs().getFees().getTabName()),
                () -> assertEquals("Weitere Infos & Bonus", accountsCreditCardInfo.getTabs().getAdditionalInfoAndBonus().getTabName()),
                () -> assertEquals("Versicherung", accountsCreditCardInfo.getTabs().getInsurance().getTabName()),
                () -> assertEquals("Travel", accountsCreditCardInfo.getTabs().getTravel().getTabName())
        );

        return this;
    }
}
