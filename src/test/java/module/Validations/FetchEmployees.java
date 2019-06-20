package module.Validations;

import core.dbConnect.DbConnect_mySql;
import core.dbConnect.DbConnect_oracle;
import core.general.BaseTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class FetchEmployees extends BaseTest {
    public FetchEmployees() throws AWTException {}

    @Test
    public static void sanityFlowFetchEmployees() throws SQLException, ClassNotFoundException {
        logStep("Sanity API - Fetch Employee");

//        DbConnect_oracle.getVerificationCode();
        List<String> actualData = DbConnect_mySql.getDataFromPatientConsentTable("HC12345677");
//        System.out.println(actualData.get(0));

        response =
            given()
//                .log().all()
                .headers( "Accept", "*/*")
            .when()
                .get("/api/v1/employees")
            .then()
//                .log().all()
                .assertThat().statusCode(200)
//                .body("size()", not(null))
            .extract()
                .response();
    }
}
