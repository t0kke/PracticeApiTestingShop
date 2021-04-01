package api.spec;

import config.ConfigHelper;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseSpec {
	private final RequestSpecification requestSpec = given()
			.baseUri(ConfigHelper.getBaseURL())
			.contentType(ContentType.URLENC)
			.cookies(getCookiesAuthorization())
			.log().uri()
			.when();

	public Map<String, String> getCookiesAuthorization() {
		return
				given()
						.contentType(ContentType.URLENC)
						.formParam("Email", ConfigHelper.getEmail())
						.formParam("Password", ConfigHelper.getPassword())
						.when()
						.post("/login")
						.then()
						.statusCode(302)
						.log().body()
						.extract().cookies();
	}

	public static BaseSpec spec() {
		return new BaseSpec();
	}

	public RequestSpecification request() {
		return requestSpec;
	}
}
