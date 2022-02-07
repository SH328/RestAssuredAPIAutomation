package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class AnotherTest {

    @Test
    public void test_3(){

        Response response = RestAssured.given().
                get("https://reqres.in/api/users?page=2").
               then().contentType("application/json; charset=utf-8").
        statusCode(200).
                log().all().extract().response();



    }
}
