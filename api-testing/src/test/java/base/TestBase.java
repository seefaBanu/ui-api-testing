package base;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class TestBase {
    public static RequestSpecification adminRequest;
    public static RequestSpecification userRequest;
    public static RequestSpecification unAuthenticatedRequest;

    static {
        RestAssured.baseURI = "http://localhost:7081";

        // Admin user
        adminRequest = RestAssured
                .given()
                .filter(new AllureRestAssured())
                .auth()
                .preemptive()
                .basic("admin", "password")
                .contentType("application/json");

        // Regular user
        userRequest = RestAssured
                .given()
                .filter(new AllureRestAssured())
                .auth()
                .preemptive()
                .basic("user", "password")
                .contentType("application/json");

        unAuthenticatedRequest = RestAssured
                .given()
                .filter(new AllureRestAssured())
                .contentType("application/json");
    }
}
