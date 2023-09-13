package assertions;

import dataProvider.Product;
import dataProvider.responses.Cart;
import io.qameta.allure.Step;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CartAssertions extends CoreAssertions {


    @Step("Result: check full cart response")
    public CartAssertions checkFullCartResponse(Cart cart, List<Product> products) {


        if (cart.getItems().size() == products.size()) {

            double totalCount = 0.0;
            for (int i = 0; i < products.size(); i++) {

                double count = cart.getItems().get(i).getPrice() * cart.getItems().get(i).getQuantity();
                totalCount += count;

                softAssertions.assertThat(cart.getItems().get(i).getProduct_id()).isEqualTo(products.get(i).getProductId());
                softAssertions.assertThat(cart.getItems().get(i).getQuantity()).isEqualTo(products.get(i).getQuantity());
                softAssertions.assertThat(cart.getItems().get(i).getName()).isNotNull();

            }

            softAssertions.assertThat(cart.getTotal()).isEqualTo(String.valueOf(totalCount));
            softAssertions.assertAll();


        } else {
            fail("The cart response doesn't match the request");
        }
        return this;

    }



}
