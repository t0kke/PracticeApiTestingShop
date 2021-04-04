package api.steps;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UISteps {
	public void addProduckAndcheckPopUpAddToWishList(String pathToProduct)
	{
		open("" + pathToProduct);
		$(".add-to-wishlist-button").click();
		$("p.content").shouldHave(Condition.appear).shouldHave(text("The product has been added to your "));
	}
}

