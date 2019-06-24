package module.Validations;

import core.general.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class rejectChangeInRequest extends BaseTest {
    rejectChangeInRequest(){

    }
    @Test
    public static String changeRequest( String  bookingConfirmationId , String accessToken){
        logStep("reject change request Partner Request API - request for accept booking request");



        response =
                given()
//                    .log().all()

                        .headers( "Authorization", "bearer " + accessToken )
                        .headers( "Content-Type", "application/json")
                        .headers( "accessToken", accessToken)
                        .headers("isCustomerLoggedIn",true)

                        .body(requestPayloads.rejChangeRequest.sanityPayload(bookingConfirmationId))
                        .when()
//                        .post("/oauth/token").getBody().jsonPath().get("access_token");
                        .put(" /v2/booking-change-request/reject")
                        .then()
                        .assertThat().statusCode(200).extract()
                        .response();
        return  response.body().jsonPath().getString("success");


    }


}
