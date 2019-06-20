package module.Validations;

import core.general.BaseTest;
import org.testng.annotations.Test;
import requestPayloads.CreateEmployeePayloads;

import static io.restassured.RestAssured.given;

public class CreateEmployees extends BaseTest{
    public CreateEmployees(){}

    @Test
    public static void sanityFlowCreateEmployees(String name, String salary, String age){
        logStep("Sanity API - Create Employee");

        response =
            given()
//                    .log().all()
                    .headers( "Content-Type", "application/json")
                    .body(CreateEmployeePayloads.sanityPayload(name, salary, age))
            .when()
                    .post("/api/v1/create")
            .then()
//                    .log().all()
                    .assertThat().statusCode(200)
//                .body("size()", not(null))
            .extract()
                    .response();
    }

}
