package requestPayloads;

import core.general.BaseTest;
import core.general.ReusableMethods;

public class CreateEmployeePayloads extends BaseTest{
    public CreateEmployeePayloads(){}

    public static String sanityPayload(String employeeName, String employeeSalary, String employeeAge){
        String rand = String.valueOf(ReusableMethods.generateRandomIntIntRange(0,100));

        req = "{\n" +
                "    \"name\": \"" + employeeName+rand + "\",\n" +
                "    \"salary\": \"" + employeeSalary+rand + "\",\n" +
                "    \"age\": \"" + employeeAge+rand + "\"\n" +
                "}";

        return req;
    }

}
