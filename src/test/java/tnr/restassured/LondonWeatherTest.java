package tnr.restassured;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class LondonWeatherTest {

    static final String ENDPOINT = "https://samples.openweathermap.org/data/2.5/weather";
    static final String APP_ID = "439d4b804bc8187953eb36d2a8c26a02";
    static final String QUERY = "London,uk";

    @Test
    public void checkStatusCode(){
        given().
                queryParam("q",QUERY).
                queryParam("appid",APP_ID).
        when().
                get(ENDPOINT).
        then().
                statusCode(200);
    }

    @Test
    public void checkResponseCityName(){
        given().
                queryParam("q",QUERY).
                queryParam("appid",APP_ID).
        when().
                get(ENDPOINT).
        then().
                body("name", containsString("London"));
    }
}
