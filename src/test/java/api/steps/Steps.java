package api.steps;

import io.restassured.response.ValidatableResponse;

import static api.spec.BaseSpec.spec;

public class Steps {
	public ValidatableResponse addGoodsToWishList(final int id) {
			return
					spec().request()
						.body("giftcard_1.RecipientName=Lolik&giftcard_1.RecipientEmail=g%40gg.aa&giftcard_1.SenderName=Me&giftcard_1.SenderEmail=fg%40gg.aa&giftcard_1.Message=q&addtocart_1.EnteredQuantity=1")
						.post("/addproducttocart/details/1/{id}", id)
					.then()
						.log().body();
	}
}
