package tests;

import api.steps.ApiSteps;
import api.steps.UISteps;
import org.junit.jupiter.api.BeforeAll;

public class ApiBaseTest {
	static ApiSteps restAssured;
	static UISteps ui;

	@BeforeAll
	public static void setUp() {
		restAssured = new ApiSteps();
		ui = new UISteps();
	}
}
