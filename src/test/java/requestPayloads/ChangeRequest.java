package requestPayloads;

import core.general.BaseTest;

public class ChangeRequest extends BaseTest {
    ChangeRequest() {
    }

    public static String sanityPayload(String BookingID) {


        req = "{\n" +
                "\t\"id\":428,\n" +
                "\t\"service_code\":\"CK\",\n" +
                "\t\"booking_id\":"+ BookingID +",\n" +
                "\t\"booking_event_id\":null,\n" +
                "\t\"new_data\":\n" +
                "\t{\n" +
                "\t\t\"request\":null,\n" +
                "\t\t\"booking_data\":\n" +
                "\t\t{\n" +
                "\t\t\t\"id\":null,\n" +
                "\t\t\t\"voucherModel\":null,\n" +
                "\t\t\t\"price_plan_id\":null,\n" +
                "\t\t\t\"start_date\":\"2019-06-30\"\n" +
                "\t\t\t,\"end_date\":null,\n" +
                "\t\t\t\"frequency\":null,\n" +
                "\t\t\t\"time\":\"21:00:00\",\n" +
                "\t\t\t\"number_of_week_days\":null,\n" +
                "\t\t\t\"service_detail\":null,\n" +
                "\t\t\t\"service_provider_ids\":null,\n" +
                "\t\t\t\"book_again\":null,\n" +
                "\t\t\t\"images\":null\n" +
                "\t\t\t\n" +
                "\t\t},\n" +
                "\t\t\"booking_event_data\":null\n" +
                "\t\t\n" +
                "\t},\n" +
                "\t\"creator_comment\":\"\",\n" +
                "\t\"status\":\"CHANGE_REQUEST_STATUS_PENDING\",\n" +
                "\t\"requested_by\":\"CUSTOMER\",\n" +
                "\t\"apply_on_future_events\":true\n" +
                "\t\n" +
                "}";

        return req;
    }
}
