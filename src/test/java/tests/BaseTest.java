package tests;

import api.steps.ApiSteps;
import api.steps.UISteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static config.ConfigHelper.isVideoOn;
import static helpers.AttachmentsHelper.*;
import static helpers.DriverHelpers.*;

public class BaseTest {
    static ApiSteps restAssured;
    static UISteps ui;

    @BeforeAll
    public static void setUp() {
        restAssured = new ApiSteps();
        ui = new UISteps();
        configureDriver();
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = getSessionId();

        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        if (isVideoOn()) attachVideo(sessionId);

        closeWebDriver();
    }
}
