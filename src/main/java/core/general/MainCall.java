package core.general;

import com.relevantcodes.extentreports.ExtentReports;
import core.configuration.TestsConfig;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;

import java.io.IOException;
import java.util.Properties;

public class MainCall {
    public MainCall(){}
    public static ExtentReports extent;
    public static String baseUri = TestsConfig.getConfig().getBaseUri();



    public static ExtentReports startReport() {
        extent = new ExtentReports(System.getProperty("user.dir") + "/build/reports/ExtentReport.html", true);

        extent.addSystemInfo("Environment", TestsConfig.getConfig().getEnvironment());

        return extent;
    }

    public static ExtentReports getExtentReport() {
        if (extent != null) {
            return extent;
        } else {
            throw new IllegalStateException("Extent Report object not initialized");
        }
    }

    public static void setupRestAssured(){
        //Rest Assured config
        RestAssured.baseURI = baseUri;
//            RestAssured.port = Integer.valueOf(props.getProperty("api.port"));
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL);
        RestAssured.useRelaxedHTTPSValidation();
    }

    public static void setupPreReqs(){
        //Rest Assured config
        RestAssured.baseURI = baseUri;
//            RestAssured.port = Integer.valueOf(props.getProperty("api.port"));
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL);
        RestAssured.useRelaxedHTTPSValidation();
    }

}
