package requestPayloads;

import core.general.BaseTest;

public class CancelRequest extends BaseTest {

    public CancelRequest(){}


    public static String sanityPayload(String BookingID){


        req = "{\n" +
                "  \"bookingId\": "+ BookingID +",\n" +
                "  \"cancellationReason\": \"asdf\",\n" +
                "  \"comments\": \"asdf\",\n" +
                "  \"feedbackDto\": {\n" +
                "    \"feedbackReason\": \"\",\n" +
                "    \"feedbackReasonId\": 3,\n" +
                "    \"feedbackSource\": \"CUSTOMER_WEB\",\n" +
                "    \"feedbackType\": \"ONCE_BOOKING_CANCELLATION\",\n" +
                "    \"id\": 0\n" +
                "  },\n" +
                "  \"requestedBy\": \"customer\",\n" +
                "  \"sendEmailToCustomer\": 0,\n" +
                "  \"statusId\": 72\n" +
                "}";

        return req;
    }
}
