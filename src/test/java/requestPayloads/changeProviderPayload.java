package requestPayloads;

import core.general.BaseTest;

public class changeProviderPayload extends BaseTest {

    changeProviderPayload(){}


    public static String sanityPayload(String BookingID) {


        req = "{\n" +
                "  \"firstName\": \"Mariam\",\n" +
                "  \"lastName\": \"Altaf\",\n" +
                "  \"email\": \"testpartner@mailinator.com\"\n" +
                "}";

        return req;
    }
}
