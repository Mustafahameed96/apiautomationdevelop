package requestPayloads;

import core.general.BaseTest;

public class CreateBookingPayload extends BaseTest {
    public CreateBookingPayload(){}
    public static String sanityPayload(String customerID){


        req = "{\n" +
                "  \"service_code\": \"CK\",\n" +
                "  \"service_location_code\":\"DXB\",\n" +
                "  \"customer_id\":" +  customerID +",\n" +
                "  \"contact_information\": {\n" +
                "    \"personName\": \"Mariam\",\n" +
                "    \"personLastName\": \"Hammad\",\n" +
                "    \"personEmail\": \"mariam.hammad@venturedive.com\",\n" +
                "    \"personPhone\": \"+971333222111\"\n" +
                "  },\n" +
                "  \"address\": {\n" +
                "    \"line1\": \"\",\n" +
                "    \"line2\": \"\",\n" +
                "    \"city_id\": \"1\",\n" +
                "    \"area_id\": \"76\",\n" +
                "    \"building\": \"OceanAce Towers\",\n" +
                "    \"apartment\": \"A100\"\n" +
                "  },\n" +
                "  \"voucher_code\":\"\",\n" +
                "  \"description\":\"Please send a professional and experienced cleaner with a good track record\",\n" +
                "  \"booking\":{\n" +
                "    \"price_plan_id\":55,\n" +
                "    \"start_date\":\"2019-07-13\",\n" +
                "    \"frequency\":\"ONCE\",\n" +
                "    \"time\":\"10:30:00\",\n" +
                "    \"number_of_week_days\":[2],\n" +
                "  \"service_detail\":{\n" +
                "    \"property_type\":\"apartment\",\n" +
                "    \"no_of_rooms\": \"2\"\n" +
                "  }\n" +
                "  },\n" +
                "  \"payment\": {\n" +
                "    \"paymentMethod\": \"CASH_ON_DELIVERY\"\n" +
                "  }\n" +
                "}";

        return req;
    }
}
