package requestPayloads;

import core.general.BaseTest;

public class UpdateEmployeeDetailsPayloads extends BaseTest{
    public UpdateEmployeeDetailsPayloads(){}

    public static String sanityPayload(String employeeName, String employeeSalary, String employeeAge){
        String newEmployeeName = employeeName + " NEW";
        String newEmployeeSalary = employeeSalary + 10;
        String newEmployeeAge = employeeAge + 1;

        req = "{\n" +
                "    \"name\": \"" + newEmployeeName + "\",\n" +
                "    \"salary\": \"" + newEmployeeSalary + "\",\n" +
                "    \"age\": \"" + newEmployeeAge + "\"\n" +
                "}";

        return req;
    }


}
