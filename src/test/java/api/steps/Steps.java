package api.steps;

import static api.spec.BaseSpec.spec;

public class Steps {
	public void addGoodsToWishlist(final int id) {
		spec().request()
				.post("/addproducttocart/details/1/{id}", id)
				.then()
				.log().body();
	}
}
