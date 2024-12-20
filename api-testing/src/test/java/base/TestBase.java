package base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class TestBase {
    public static RequestSpecification adminRequest;
    public static RequestSpecification userRequest;

    static {
        RestAssured.baseURI = "http://localhost:7081";

        // Admin user
        adminRequest = RestAssured
                .given()
                .auth()
                .preemptive()
                .basic("admin", "password")
                .contentType("application/json");

        // Regular user
        userRequest = RestAssured
                .given()
                .auth()
                .preemptive()
                .basic("user", "password")
                .contentType("application/json");
    }
}
