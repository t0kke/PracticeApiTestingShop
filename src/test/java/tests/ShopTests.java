package tests;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.is;

public class ShopTests extends BaseTest {
    @Test
    void checkProductAdditionToWishList() {
        restAssured.addGoodsToWishList(2)
                .body("success", is(true))
                .body("message", hasToString("The product has been added to your <a href=\"/wishlist\">wishlist</a>"));
    }
}
