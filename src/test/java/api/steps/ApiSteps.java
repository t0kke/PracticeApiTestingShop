package api.steps;

import api.model.WishList;
import api.spec.BaseSpec;
import org.openqa.selenium.Cookie;

import static api.spec.BaseSpec.spec;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ApiSteps {
	public WishList addGoodsToWishList(final int id) {
			return
					spec().request()
						.body("giftcard_1.RecipientName=Lolik&giftcard_1.RecipientEmail=g%40gg.aa&giftcard_1.SenderName=Me&giftcard_1.SenderEmail=fg%40gg.aa&giftcard_1.Message=q&addtocart_1.EnteredQuantity=1")
						.post("/addproducttocart/details/1/{id}", id)
					.then()
						.log().body()
						.extract()
						.as(WishList.class);
	}

	public void setCookieFileInUITest()
	{
		open("http://demowebshop.tricentis.com/Themes/DefaultClean/Content/images/logo.png");
		getWebDriver().manage().addCookie(new Cookie("Nop.customer", BaseSpec.spec().getCookiesAuthorization().get("Nop.customer")));
		getWebDriver().manage().addCookie(new Cookie("NOPCOMMERCE.AUTH", BaseSpec.spec().getCookiesAuthorization().get("NOPCOMMERCE.AUTH")));
		getWebDriver().manage().addCookie(new Cookie("ARRAffinity", BaseSpec.spec().getCookiesAuthorization().get("ARRAffinity")));
		open("");
	}

}
