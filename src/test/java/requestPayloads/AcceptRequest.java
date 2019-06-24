package requestPayloads;

import core.general.BaseTest;

public class AcceptRequest extends BaseTest {

public AcceptRequest(){}


    public static String sanityPayload(String BookingID){


        req = "{\n" +
                "  \"bookingConfirmationId\": "+BookingID+",\n" +
                "  \"comments\": \"\",\n" +
                "  \"rejectionReasonDataValueId\": 0,\n" +
                "  \"rejectionReasonText\": \"\",\n" +
                "  \"requestedBy\": \"Mariam\",\n" +
                "  \"statusId\": 80\n" +
                "}";

        return req;
    }
}
