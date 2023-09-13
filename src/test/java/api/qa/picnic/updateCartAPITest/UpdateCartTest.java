package api.qa.picnic.updateCartAPITest;

import api.qa.picnic.BaseTest;
import assertions.CartAssertions;
import dataProvider.Product;
import dataProvider.responses.Cart;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import testSteps.steps.GetCartSteps;
import testSteps.steps.UpdateCartSteps;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;


public class UpdateCartTest extends BaseTest {

    CartAssertions assertions = new CartAssertions();
    UpdateCartSteps updateCartSteps = new UpdateCartSteps();
    GetCartSteps getCartSteps = new GetCartSteps();


    @Test
    @DisplayName("Update empty cart: add new product with amount = 1")
    @Tag("High")
    public void updateEmptyCartWithOneProduct() {

        token = getAuthToken();

        List<Product> products = new ArrayList<>();
        products.add(new Product(101, 1));

        Response updateCartResponse = updateCartSteps.updateCartWithAuth(products, token);
        Cart updateCart = updateCartResponse.as(Cart.class);

        Response getCartResponse = getCartSteps.getCart(token);
        Cart getCart = getCartResponse.as(Cart.class);

        assertAll(
                () -> assertions.checkResponseStatus(updateCartResponse, 200),
                () -> assertions.checkFullCartResponse(updateCart, products),
                () -> assertions.checkFullCartResponse(getCart, products)
        );


    }


    @Test
    @DisplayName("Update non-empty cart: increase quantity up")
    @Tag("High")
    public void updateNonEmptyCartWithMoreQuantityOfProductTest() {

        token = getAuthToken();

        List<Product> products = new ArrayList<>();
        products.add(new Product(101, 1));
        products.add(new Product(102, 2));

        updateCartSteps.updateCartWithAuth(products, token);

        products.get(0).setQuantity(3);

        Response updateCartResponse = updateCartSteps.updateCartWithAuth(products, token);
        Cart updateCart = updateCartResponse.as(Cart.class);

        Response getCartResponse = getCartSteps.getCart(token);
        Cart getCart = getCartResponse.as(Cart.class);

        assertAll(
                () -> assertions.checkResponseStatus(updateCartResponse, 200),
                () -> assertions.checkFullCartResponse(updateCart, products),
                () -> assertions.checkFullCartResponse(getCart, products)

        );


    }


    @Test
    @DisplayName("Update cart: invalid product id is impossible to add")
    @Tag("Low")
    public void updateWithInvalidProductTest() {

        token = getAuthToken();
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, 1));

        Response updateCartResponse = updateCartSteps.updateCartWithAuth(products, token);

        assertAll(
                () -> assertions.checkResponseStatus(updateCartResponse, 404),
                () -> assertions.checkResponseBodyFieldValue(updateCartResponse, "detail", "Product id 1 not found")

        );
    }

    @Test
    @DisplayName("Update cart: update cart without authentication is impossible")
    @Tag("High")
    public void updateWithoutAuthTest() {

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, 1));

        Response updateCartResponse = updateCartSteps.updateCartWithoutAuth(products);

        assertAll(
                () -> assertions.checkResponseStatus(updateCartResponse, 401),
                () -> assertions.checkResponseBodyFieldValue(updateCartResponse, "detail", "Unauthorized Access")

        );
    }
}
