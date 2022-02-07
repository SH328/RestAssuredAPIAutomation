package tests;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;

public class GetAndPostExample {

    @Test
    public void testGet(){

        baseURI = "https://reqres.in/api";

        given().
                get("/users?page=2").
                then().
                statusCode(200).
                body("data[4].first_name",equalTo("George")).
                body("data[3].email",equalTo("byron.fields@reqres.in")).
                body("per_page",equalTo(6));

        baseURI = "https://reqres.in/api";

        given().
                get("/users?page=2").
                then().
                statusCode(200).
                body("data[0].id",equalTo(7)).
                body("data[0].first_name",equalTo("Michael")).
                body("data[0].last_name",equalTo("Lawson")).
                body("data[0].avatar",equalTo("https://reqres.in/img/faces/7-image.jpg"));
    }
        @Test
        public void testPost(){

//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("name","Sead");
//            map.put("job", "SDET");
//            System.out.println(map);

            // OR CAN USE JSONOBJECT DOWNLOADED FROM MAVENREPOSITORY

            JSONObject request = new JSONObject();
            request.put("name", "Sead");
            request.put("job", "SDET");
            System.out.println(request.toString());

            baseURI = "https://reqres.in/api";
            given().body(request.toString()).
                    contentType(ContentType.JSON).
                    accept(ContentType.JSON).
                    when().
                          post("/users").
                    then().
                         statusCode(201).log().all();

        }


}
