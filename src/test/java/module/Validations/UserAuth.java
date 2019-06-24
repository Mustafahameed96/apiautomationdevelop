package module.Validations;

import core.general.BaseTest;
import org.testng.annotations.Test;
import requestPayloads.CreateEmployeePayloads;

import static io.restassured.RestAssured.given;

public class UserAuth extends BaseTest {
    public UserAuth(){}



    @Test
    public static String userAuthToServiceMarket(String username, String  password, String clientId , String grantType){
        logStep("Auth API - request for token");



        response =
                given()
//                    .log().all()
                        .headers( "Content-Type", "application/x-www-form-urlencoded")
//                        .body(CreateEmployeePayloads.sanityPayload(name, salary, age))
                        .formParam("username", username)
                        .formParam("password", password )
                        .formParam("client_id", clientId)
                        .formParam("grant_type", grantType)
                        .when()
//                        .post("/oauth/token").getBody().jsonPath().get("access_token");
                        .post("/oauth/token")

                        .then()
                        .assertThat().statusCode(200).extract()
                        .response();
        return  response.body().jsonPath().getString("access_token");


    }


}
