package tnr.restassured;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CairnsWeatherTest {

    static final String ENDPOINT = "https://samples.openweathermap.org/data/2.5/weather";
    static final String APP_ID = "439d4b804bc8187953eb36d2a8c26a02";
    static final String CITY_ID = "2172797";

    @Test
    public void checkStatusCode(){
        given().
                queryParam("id", CITY_ID).
                queryParam("appid", APP_ID).
        when().
                get(ENDPOINT).
        then().
                statusCode(200);
    }

    @Test
    public void checkWeather(){
        given().
                queryParam("id", CITY_ID).
                queryParam("appid", APP_ID).
        when().
                get(ENDPOINT).
         then().
                body("weather.main", hasToString("[Clouds]"));
    }

    @Test
    public void checkCoordinateXFailure(){
        given().
                queryParam("id", CITY_ID).
                queryParam("appid", APP_ID).
        when().
                get(ENDPOINT).
        then().
                body("coord.lon", equalTo(145));
    }
}
