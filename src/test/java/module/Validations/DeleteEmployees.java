package module.Validations;

import core.general.BaseTest;
import org.testng.annotations.Test;
import requestPayloads.UpdateEmployeeDetailsPayloads;

import static io.restassured.RestAssured.given;

public class DeleteEmployees extends BaseTest{
    public DeleteEmployees(){}

    @Test
    public static void sanityFlowDeleteEmployees(String employeeId){
        logStep("Sanity API - Delete Employee");

        response =
                given()
//                    .log().all()
                        .pathParam("employeeId", employeeId)
                .when()
                        .delete("/api/v1/delete/{employeeId}")
                .then()
//                    .log().all()
                        .assertThat().statusCode(200)
//                    .body("size()", not(null))
                .extract()
                        .response();
    }

}
