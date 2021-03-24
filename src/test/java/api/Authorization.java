package api;

import io.restassured.http.ContentType;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authorization {
    public Map<String, String> login(String username, String password) {
        return
                given()
                        .contentType(ContentType.URLENC)
                        .formParam("Email", username)
                        .formParam("Password", password)
                        .when()
                        .post("/login")
                        .then()
                        .statusCode(302)
                        .log().body()
                        .extract().cookies();
    }
}
