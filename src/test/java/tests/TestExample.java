package tests;

import static io.restassured.RestAssured.*;


import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TestExample {

    @Test
    public void test_1(){

       Response response =  get("https://reqres.in/api/users?page=2")
               .then().statusCode(200)
               .extract().response();
//        System.out.println(response.getStatusCode());
//        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getHeader("content-type"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println(response.body().asString());



    }

    @Test
    public void test_2(){
        baseURI = "https://reqres.in/api";
        given().
                get("users?page=2").
                then().
                statusCode(200);
    }


}
