package module.Validations;

import core.general.BaseTest;
import org.testng.annotations.Test;
import requestPayloads.CreateEmployeePayloads;
import requestPayloads.CreateRegistrationPayload;

import static io.restassured.RestAssured.given;

public class CustomerRegistration extends BaseTest {

    public CustomerRegistration(){}

    @Test
    public static String userRegistrationToServiceMarket(String email, String  firstName, String lastName , String password , String accessToken){
        logStep("Registration API - request for registration");



        response =
                given()
//                    .log().all()
                        .headers( "signedInUserId", "7")
                        .headers( "Authorization", "bearer " + accessToken )
                        .headers( "Content-Type", "application/json")
                        .headers( "accessToken", accessToken)
                        .body(CreateRegistrationPayload.sanityPayload(email,firstName,lastName,password))
                        .when()
//                        .post("/oauth/token").getBody().jsonPath().get("access_token");
                        .post("/v2/customer/validate-and-register")

                        .then()
                        .assertThat().statusCode(200).extract()
                        .response();
        return  response.body().jsonPath().getString("data");


    }




}
