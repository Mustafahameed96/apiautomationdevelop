package module.Validations;

import core.general.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class FetchRespectiveEmployees extends BaseTest {
    public FetchRespectiveEmployees(){}

    @Test
    public static void sanityFlowFetchRespectiveEmployees(String employeeId){
        logStep("Sanity API - Fetch Respective Employees");

        response =
            given()
//                .log().all()
                .headers( "Accept", "*/*")
                .pathParam("employeeId", employeeId)
            .when()
                .get("/api/v1/employee/{employeeId}")
            .then()
//                .log().all()
                .assertThat().statusCode(200)
//                .body("size()", not(null))
            .extract()
                .response();
    }

}
