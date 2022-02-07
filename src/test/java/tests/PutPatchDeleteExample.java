package tests;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PutPatchDeleteExample {

    @Test
    public void testPut(){


        JSONObject request = new JSONObject();
        request.put("name", "Sead");
        request.put("job", "SDET");

        System.out.println(request.toString());

        baseURI = "https://reqres.in/api";
        given().body(request.toString()).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                when().
                put("/users/2").
                then().
                statusCode(200).log().all();

    }

    @Test
    public void testPatch(){


        JSONObject request = new JSONObject();
        request.put("name", "Sead");
        request.put("job", "SDET");

        System.out.println(request.toString());

        baseURI = "https://reqres.in";
        given().body(request.toString()).
                contentType(ContentType.JSON).
                     accept(ContentType.JSON).
                when().
                    patch("/api/users/2").
                then().
                    statusCode(200).log().all();

    }

    @Test
    public void testDelete(){
        baseURI = "https://reqres.in";
                when().
                        delete("/api/users/2").
                then().
                statusCode(204).log().all();

    }




}
