package module.Validations;

import core.general.BaseTest;
import org.testng.annotations.Test;
import requestPayloads.CreateRegistrationPayload;

import static io.restassured.RestAssured.given;

public class RejectRequest extends BaseTest {
    RejectRequest(){

    }

    @Test
    public static String partnerRejectRequest( String  bookingConfirmationId , String accessToken){
        logStep("Reject Partner Request API - request for accept booking request");



        response =
                given()
//                    .log().all()
                        .headers( "signedInUserId", "7")
                        .headers( "Authorization", "bearer " + accessToken )
                        .headers( "Content-Type", "application/json")
                        .headers( "accessToken", accessToken)
                        .body(requestPayloads.RejectRequest.sanityPayload(bookingConfirmationId))
                        .when()
//                        .post("/oauth/token").getBody().jsonPath().get("access_token");
                        .put("v1.0/booking/confirmation")
                        .then()
                        .assertThat().statusCode(200).extract()
                        .response();
        return  response.body().jsonPath().getString("operationMessage");


    }


}
