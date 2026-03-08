package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AuthAPI {

    public static String getLoginCookie(String baseUrl, String user, String pass) {
        Response response = RestAssured.given()
                .baseUri(baseUrl)
                .contentType("application/x-www-form-urlencoded")
                .formParam("username", user)
                .formParam("password", pass)
                .post("/web/index.php/auth/validate");

        return response.getCookie("orangehrm");
    }
}