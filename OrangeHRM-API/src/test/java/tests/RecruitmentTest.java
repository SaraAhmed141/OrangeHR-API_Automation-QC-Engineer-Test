package tests;

import api.AuthAPI;
import utils.ConfigLoader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RecruitmentTest {

    private String baseUrl;
    private final String endpoint = "/web/index.php/api/v2/recruitment/candidates";
    private RequestSpecification requestSpec;

    @BeforeClass
    public void setup() {
        this.baseUrl = ConfigLoader.getProperty("baseUrl");

        String cookie = AuthAPI.getLoginCookie(baseUrl,
                ConfigLoader.getProperty("username"),
                ConfigLoader.getProperty("password"));

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(this.baseUrl)
                .addCookie("orangehrm", cookie)
                .addHeader("X-XSRF-TOKEN", cookie)
                .setContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void testAddCandidate() {
        RestAssured.given()
                .spec(requestSpec)
                .body("{\"firstName\":\"Sara\", \"lastName\":\"Magdy\", \"email\":\"sara@test.com\", \"vacancyId\":1}")
                .when()
                .post(endpoint)
                .then()
                .statusCode(200);
    }
}