package module.Validations;

import core.general.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import requestPayloads.UpdateEmployeeDetailsPayloads;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsNot.not;

public class UpdateEmployeeDetails extends BaseTest{
    public UpdateEmployeeDetails(){
    }

    @Test
    public static void sanityFlowUpdateEmployeeDetails(String employeeId, String employeeName, String employeeSalary, String employeeAge){
        logStep("Sanity API - Update Employee Details");

        response =
                given()
//                    .log().all()
                    .headers( "Content-Type", "application/json")
                    .body(UpdateEmployeeDetailsPayloads.sanityPayload(employeeName, employeeSalary, employeeAge))
                    .pathParam("employeeId", employeeId)
                .when()
                    .put("/api/v1/update/{employeeId}")
                .then()
//                    .log().all()
                    .assertThat().statusCode(200)
//                    .body("size()", not(null))
                .extract()
                    .response();
    }

}
