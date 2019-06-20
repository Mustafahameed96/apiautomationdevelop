package core.general;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import core.PreReqs.TestBase;
import core.configuration.TestsConfig;

import core.dbConnect.DbConnect_mySql;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.LogHelper;

import java.awt.*;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;

public class BaseTest extends LogHelper{
    private static ExtentTest logger;
    private static String isEnableReporting = TestsConfig.getConfig().getIsEnableReporting();
    private static Date time = ReusableMethods.getTime();

    public static String req = "";
    public static Response response = null;
    public static RequestSpecification request = null;

    public BaseTest(){}

    @BeforeSuite
    public void startReport(){
        if (isEnableReporting.equals("true")) {


            try
            {
                DbConnect_mySql.ConnectDataBase();

            }
            catch (SQLException e)
            {
                // do something appropriate with the exception, *at least*:
                e.printStackTrace();
            }


            MainCall.startReport();

        }

        MainCall.setupRestAssured();
        TestBase.setup();
    }

    @BeforeMethod
    public void setup(Method method) throws MalformedURLException, AWTException, SQLException {
        if (isEnableReporting.equals("true")) {
            logger = MainCall.getExtentReport().startTest(method.getName(), "");
            logger.setStartedTime(ReusableMethods.getTime());
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (isEnableReporting.equals("true")) {
            if (result.getStatus() == ITestResult.FAILURE) {
                logger.log(LogStatus.FAIL, "Test Case Failed reason is: " + result.getThrowable());
                logger.log(LogStatus.INFO, "StackTrace Result: " + Arrays.toString(result.getThrowable().getStackTrace()));
//                logger.log(LogStatus.FAIL, logger.addScreenCapture(Screenshots.takeScreenshot(result.getMethod().getMethodName())));
            } else if (result.getStatus() == ITestResult.SKIP) {
                logger.log(LogStatus.SKIP, "Test Case Skipped is: " + result.getName());
            } else {
                logger.log(LogStatus.PASS, result.getMethod().getMethodName() + " is Passed");
            }

            logger.setEndedTime(time);
            MainCall.getExtentReport().endTest(logger);
        }
    }

    @AfterSuite
    public void endReport() {
        if (isEnableReporting.equals("true")) {
            MainCall.getExtentReport().flush();
            MainCall.getExtentReport().close();
        }
    }
}
