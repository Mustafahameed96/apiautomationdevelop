package module.Validations;

import core.general.BaseTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import requestPayloads.CreateBookingPayload;
import requestPayloads.CreateRegistrationPayload;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CustomerBooking extends BaseTest {
    public CustomerBooking(){}

    @Test
    public static String userBookingToServiceMarket( String CustomerID,String accessToken){
        logStep("Booking API - request for Booking");



   JsonPath newobj  = null;

        response =
                given()
//                    .log().all()
                        .headers( "signedInUserId", "7")
                        .headers( "Authorization", "bearer " + accessToken )
                        .headers( "Content-Type", "application/json")
                        .headers( "accessToken", accessToken)
                        .body(CreateBookingPayload.sanityPayload(CustomerID))
                        .when()
//                        .post("/oauth/token").getBody().jsonPath().get("access_token");
                        .post("/v2/booking")

                        .then()
                        .assertThat().statusCode(200).extract()
                        .response();


        Map<String, String> company = response.jsonPath().getMap("data");
       return String.valueOf(company.get("bookingId"));




    }
}
