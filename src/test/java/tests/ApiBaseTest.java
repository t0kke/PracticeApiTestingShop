package tests;

import api.steps.ApiSteps;
import api.steps.UISteps;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class ApiBaseTest {
	static ApiSteps restAssured;
	static UISteps ui;

	@BeforeAll
	public static void setUp() {
		restAssured = new ApiSteps();
		ui = new UISteps();
		addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
	}
}
