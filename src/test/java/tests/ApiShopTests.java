package tests;

import api.model.WishList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.is;

public class ApiShopTests extends ApiBaseTest{
	@Test
	@DisplayName("Проверка добавления товара в список избранного")
	void checkProductAdditionToWishList() {
		WishList wishList = restAssured.addGoodsToWishList(2);

		assertThat(wishList.getMessage(),
				hasToString("The product has been added to your <a href=\"/wishlist\">wishlist</a>"));
		assertThat(wishList.isSuccess(), is(true));
	}

}
