package module.Validations;

import core.general.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class acceptChangeRequest extends BaseTest {
    acceptChangeRequest(){

    }
    @Test
    public static String changeRequest( String  bookingConfirmationId , String accessToken){
        logStep("accept change request Partner Request API - request for accept booking request");



        response =
                given()
//                    .log().all()

                        .headers( "Authorization", "bearer " + accessToken )
                        .headers( "Content-Type", "application/json")
                        .headers( "accessToken", accessToken)

                        .body(requestPayloads.accChangeRequest.sanityPayload(bookingConfirmationId))
                        .when()
//                        .post("/oauth/token").getBody().jsonPath().get("access_token");
                        .put("https://uat1-api.servicemarket.com/v2/booking-change-request/accept")
                        .then()
                        .assertThat().statusCode(200).extract()
                        .response();
        return  response.body().jsonPath().getString("success");


    }


}
