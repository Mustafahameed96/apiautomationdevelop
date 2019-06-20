package module.Validations;

import core.general.BaseTest;
import io.restassured.http.ContentType;
import requestPayloads.VisitedAirportsPayloads;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class CAE_17_VisitedAirports extends BaseTest{
    public CAE_17_VisitedAirports() throws AWTException {
    }

//    @Test
    public void correctLastUpdatedTime() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InterruptedException {
        given()
//            .log().all()
            .headers( "Content-Type", ContentType.JSON)
            .body(VisitedAirportsPayloads.correctLastUpdatedTime())
        .when()
            .post("")
        .then()
//            .log().all()
            .assertThat().statusCode(200)
            .body("data.fetchVisitedAirports.responseHeaderDto.message", equalTo("OK"),
                  "data.fetchVisitedAirports.responseHeaderDto.statusCode", equalTo(0),
                  "data.fetchVisitedAirports.responseHeaderDto.isError", equalTo(false));
    }

//    @Test
    public void completeFieldsAndSubFields() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InterruptedException {
        given()
//            .log().all()
            .headers( "Content-Type", ContentType.JSON)
            .body(VisitedAirportsPayloads.completeFieldsAndSubFields())
        .when()
            .post("")
        .then()
//            .log().all()
            .assertThat().statusCode(200)
            .body("data.fetchVisitedAirports.responseHeaderDto.message", equalTo("OK"),
                    "data.fetchVisitedAirports.responseHeaderDto.statusCode", equalTo(0),
                    "data.fetchVisitedAirports.responseHeaderDto.isError", equalTo(false));
    }

//    @Test
    public void msServerDown() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InterruptedException {
        given()
//            .log().all()
            .headers( "Content-Type", ContentType.JSON)
            .body(VisitedAirportsPayloads.msServerDown())
        .when()
            .post("")
        .then()
//            .log().all()
            .assertThat().statusCode(200)
            .body("data.fetchVisitedAirports.responseHeaderDto.message", equalTo("Unable to connect the server"),
                    "data.fetchVisitedAirports.responseHeaderDto.statusCode", equalTo(1002),
                    "data.fetchVisitedAirports.responseHeaderDto.isError", equalTo(true));
    }

//    @Test
    public void incorrectContext() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InterruptedException {
        given()
//            .log().all()
            .headers( "Content-Type", ContentType.JSON)
            .body(VisitedAirportsPayloads.incorrectContext())
        .when()
            .post("")
        .then()
//            .log().all()
            .assertThat().statusCode(200)
            .body("data.fetchVisitedAirports.responseHeaderDto.message", equalTo("User not authenticated"),
                "data.fetchVisitedAirports.responseHeaderDto.statusCode", equalTo(1003),
                    "data.fetchVisitedAirports.responseHeaderDto.isError", equalTo(true));
    }

}
