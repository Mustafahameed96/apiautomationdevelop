package requestPayloads;

import core.general.BaseTest;
import core.general.ReusableMethods;

public class CreateRegistrationPayload  extends BaseTest {

    public CreateRegistrationPayload(){}
    public static String sanityPayload(String Email, String FirstName, String LastName , String Password){


        req = "{\n" +
                "    \"email\": \"" + Email + "\",\n" +
                "    \"firstName\": \"" + FirstName + "\",\n" +
                "    \"lastName\": \"" + LastName +"\",\n" +
                "    \"password\": \"" + Password + "\"\n" +
                "}";

        return req;
    }
}
