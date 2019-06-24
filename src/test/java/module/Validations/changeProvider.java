package module.Validations;

import core.general.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class changeProvider extends BaseTest {
    changeProvider(){}

    @Test
    public static String changeRequest( String  BookingId , String accessToken,String partner_ID){
        logStep("Change Partner Request API - request for accept booking request");



        response =
                given()
//                    .log().all()
                        .headers("signedInUserId","7")
                        .headers( "Authorization", "bearer " + accessToken )
                        .headers( "Content-Type", "application/json")
                        .headers( "accessToken", accessToken)

                        .body(requestPayloads.rejChangeRequest.sanityPayload(BookingId))
                        .when()
//                        .post("/oauth/token").getBody().jsonPath().get("access_token");
                        .put("/v2/booking/change-provider/"+BookingId+"/"+960+"")
                        .then()
                        .assertThat().statusCode(200).extract()
                        .response();
        return  response.body().jsonPath().getString("success");


    }


}
