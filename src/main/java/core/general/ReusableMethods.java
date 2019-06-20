package core.general;

import core.configuration.TestsConfig;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

import static io.restassured.RestAssured.given;

public class ReusableMethods {
    public ReusableMethods(){
    }

    private static String grantType = TestsConfig.getConfig().getGrantType();
    private static String clientId = TestsConfig.getConfig().getClientId();
    private static String clientSecret = TestsConfig.getConfig().getClientSecret();
    private static String username = TestsConfig.getConfig().getUsername();
    private static String password = TestsConfig.getConfig().getPassword();

    public static String authenticateUser() {
        Map<String, String> formMap = new HashMap<>();

        formMap.put("grant_type", grantType);
        formMap.put("client_id", clientId);
        formMap.put("client_secret", clientSecret);
        formMap.put("username", username);
        formMap.put("password", password);

        String token =
            given()
                .headers("Content-Type", ContentType.URLENC.withCharset("UTF-8"), "Accept", "*/*")
                .formParams(formMap)
            .when()
                .post("https://ssodev.vistajet.com/auth/realms/vistajet/protocol/openid-connect/token")
            .then()
                .assertThat().statusCode(200)
            .extract()
                .path("access_token");

        return "bearer " + token;
    }

    public static String generateAutoSubject() {
        String s = RandomStringUtils.randomNumeric(5);
        String autoSub = "Auto-Test-" + s ;

        return autoSub;
    }

    public static int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static Date getTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }


}
