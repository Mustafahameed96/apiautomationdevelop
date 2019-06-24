package requestPayloads;

import core.general.BaseTest;

public class accChangeRequest extends BaseTest {

    accChangeRequest(){


    }

    public static String sanityPayload(String BookingID) {


        req = "{\n" +
                "  \"service_code\":\"CK\",\n" +
                "  \"booking_change_request_id\":428,\n" +
                "  \"updater_comment\":\"some updation comment\"\n" +
                "}";

        return req;
    }
}
