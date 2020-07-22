package com.company.apitests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class ApiTests {

    public static Map<String, String> singleUserReq = new HashMap<>();


    @BeforeClass
    public static void baseURL(){
        RestAssured.baseURI = "https://reqres.in/" ;
    }

    @Test
    public void createUserTest(){
        singleUserReq.put("name", "morpheus");
        singleUserReq.put("job", "leader");
        given()
                .contentType ( ContentType.JSON).body(singleUserReq)
                .post("api/users")
                .then()
                .statusCode(201)
                .and()
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"));
    }


    @Test
    public void getSingleUserByIdTest(){
        given().when().get ( "api/users/12")
                .then()
                .assertThat ()
                .statusCode(200)
                .and()
                .contentType ( ContentType.JSON )
                .body("data.id", equalTo(12))
                .body("data.email", equalTo("rachel.howell@reqres.in"));
        }

    @Test
    public void updateUserTest(){
        singleUserReq.put("name", "morpheus");
        singleUserReq.put("job", "zion resident");
        given()
                .contentType ( ContentType.JSON).body(singleUserReq)
                .put("api/users/12")
                .then()
                .statusCode(200)
                .and()
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("zion resident"));
    }

    @Test
    public void deleteUserTest(){
        given()
                .contentType ( ContentType.JSON).body(singleUserReq)
                .delete("api/users/2")
                .then()
                .statusCode(204);
    }

}
