package api.spec;

import config.ConfigHelper;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static api.filter.LogFilter.filters;
import static io.restassured.RestAssured.given;

public class BaseSpec {
	private final RequestSpecification request = given()
			.baseUri(ConfigHelper.getBaseURL())
			.contentType(ContentType.URLENC)
			.cookies(getCookiesAuthorization())
			.filter(filters().withCustomTemplates())
			.log().uri()
			.when();

	public Map<String, String> getCookiesAuthorization() {
		return
				given()
						.baseUri(ConfigHelper.getBaseURL())
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
		return request;
	}
}
