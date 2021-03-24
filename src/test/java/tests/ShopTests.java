package tests;

import api.Authorization;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.is;

public class ShopTests extends BaseTest {
    @Test
    void addGoodsToWishlist() {
        Map<String, String> cookiesAuth = new Authorization().login("qaguru@qa.guru", "qaguru@qa.guru1");
        given()
                .cookies(cookiesAuth)
                .contentType(ContentType.URLENC)
                .body("giftcard_1.RecipientName=Lolik&giftcard_1.RecipientEmail=g%40gg.aa&giftcard_1.SenderName=Me&giftcard_1.SenderEmail=fg%40gg.aa&giftcard_1.Message=q&addtocart_1.EnteredQuantity=1")
                .when()
                .post("/addproducttocart/details/1/2")
                .then()
                .statusCode(200)
                .body("success", is(true))
                .and()
                .body("message", hasToString("The product has been added to your <a href=\"/wishlist\">wishlist</a>"))
                .log().body();
    }
}
