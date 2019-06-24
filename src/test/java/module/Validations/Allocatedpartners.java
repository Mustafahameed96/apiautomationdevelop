package module.Validations;

import core.general.BaseTest;
import gherkin.deps.com.google.gson.JsonArray;
import gherkin.deps.com.google.gson.JsonObject;
import gherkin.lexer.Ar;
import org.testng.annotations.Test;
import requestPayloads.CreateRegistrationPayload;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Allocatedpartners extends BaseTest {

    public Allocatedpartners () {}


     @Test
    public static String [] GetListOfAllocatedPartners(String bookingID ,  String  accessToken){
        logStep("Request List of Allocated Partners - request for list");
String id_bookId [] = {"",""} ;

        response =
                given()
                        .headers( "Authorization", "bearer " + accessToken )
                        .when()
//                        .post("/oauth/token").getBody().jsonPath().get("access_token");
                        .get("/v1.0/service-provider/" + bookingID+"/allocatedPartners")
                        .then()
                        .assertThat().statusCode(200).extract()
                        .response();
          response.body().jsonPath().getString("data");

        Map<ArrayList,ArrayList> company = response.jsonPath().getMap("data");
        HashMap newobj   = (HashMap) company.get("content").get(3);
        String testID = (String)newobj.get("id").toString();
        String bookingConfirmationId = (String)newobj.get("bookingConfirmationId").toString();

        id_bookId[0]=testID;

        id_bookId[1]=bookingConfirmationId;

       // Object newobj1 = newobj.get(3);


       // System.out.println(testID);
        //System.out.println(bookingConfirmationId);
       return id_bookId;



    }
}
