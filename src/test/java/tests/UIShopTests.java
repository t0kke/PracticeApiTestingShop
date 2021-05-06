package tests;

import annotations.JiraIssue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UIShopTests extends UIBaseTest {
    @JiraIssue("QC3-32")
    @Test
    @DisplayName("Проверка добавления товара в список избранного через UI")
    void checkProductAdditionToWishListPopUpInUI() {
       restAssured.setCookieFileInUITest();
       ui.addProduckAndcheckPopUpAddToWishList("/50s-rockabilly-polka-dot-top-jr-plus-size");
    }
}
