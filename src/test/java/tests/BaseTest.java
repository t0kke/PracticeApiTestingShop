package tests;

import api.steps.ApiSteps;
import api.steps.UISteps;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    static ApiSteps restAssured;
    static UISteps ui;

    @BeforeAll
    public static void setUp() {
        restAssured = new ApiSteps();
        ui = new UISteps();
        Configuration.baseUrl = "http://demowebshop.tricentis.com/";
    }
}
