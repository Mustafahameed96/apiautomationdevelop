package core.PreReqs;

import core.PreReqs.utils.RequestPayloads;
import core.general.ReusableMethods;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestPage {
    public TestPage(){}

    public static Response response = null;

//    **********************************************    GET - READ   **********************************************

    public static Response getItinerary(String orderId) {
        response =
                given()
//                    .log().all()
                    .headers("Authorization", ReusableMethods.authenticateUser(), "Accept", "*/*")
                    .queryParam("orderId", orderId)
                .when()
                    .get("/itineraries")
                .then()
//                    .log().all()
                    .assertThat().statusCode(200).and()
                    .body("responseHeader.statusCode",equalTo(0)).and()
                    .body("responseHeader.message",equalTo("OK")).and()
                    .body("responseHeader.error",equalTo(false)).and()
                .extract()
                    .response();

        return response;
    }

//    **********************************************    POST - WRITE   **********************************************

    public static void addPreference() {
        given()
//            .log().all()
            .headers( "Authorization", ReusableMethods.authenticateUser(), "Content-Type", ContentType.JSON)
            .body(RequestPayloads.createEmployee())
        .when()
            .post("/preference/save")
        .then()
//            .log().all()
            .assertThat().statusCode(204);
    }

//    **********************************************    Functions   **********************************************


}
