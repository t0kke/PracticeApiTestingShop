package tests;

import api.steps.Steps;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    static Steps restAssured;

    @BeforeAll
    public static void setUp() {
        restAssured = new Steps();
        RestAssured.baseURI = "http://demowebshop.tricentis.com";
    }

}
