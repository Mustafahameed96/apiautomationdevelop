package requestPayloads;

import core.general.BaseTest;
import org.kohsuke.rngom.parse.host.Base;

public class rejChangeRequest extends BaseTest {
    rejChangeRequest(){}

    public static String sanityPayload(String BookingID) {


        req = "{\n" +
                "\t\"booking_change_request_id\":428,\n" +
                "\t\"service_code\":\"CK\",\n" +
                "\t\"updater_comment\":\"some updation comment\"\n" +
                "}";

        return req;
    }
}
