package requestPayloads;

import core.general.BaseTest;

public class RejectRequest extends BaseTest {

    public RejectRequest(){}


    public static String sanityPayload(String BookingID){


        req = "{\n" +
                "  \"bookingConfirmationId\": "+BookingID+",\n" +
                "  \"comments\": \"\",\n" +
                "  \"rejectionReasonDataValueId\": 0,\n" +
                "  \"rejectionReasonText\": \"\",\n" +
                "  \"requestedBy\": \"Mariam\",\n" +
                "  \"statusId\": 82\n" +
                "}";

        return req;
    }
}
